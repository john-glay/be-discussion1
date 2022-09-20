package johnglay.discussion1.service;

import johnglay.discussion1.model.UserRequest;
import johnglay.discussion1.model.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    public List<UserResponse> getAllUser() {
        return db();
    }

    public List<UserResponse> addUser(UserRequest userRequest) {
        List<UserResponse> newAllUsers = db();

        newAllUsers.add(UserResponse.builder().id(4).fullName(userRequest.getFirstName().concat(" ").concat(userRequest.getLastName())).build());

        return newAllUsers;
    }

    public List<UserResponse> modifyUser(Integer id, String fullName) {
        List<UserResponse> oldList = db();
        List<UserResponse> newList = new ArrayList<>();

        oldList.forEach(user -> {
            if(Objects.equals(id, user.getId())) {
                newList.add(UserResponse.builder().id(id).fullName(fullName).build());
            } else {
                newList.add(user);
            }
        });


        return newList;
    }

    public List<UserResponse> deleteUser(Integer id) {
        List<UserResponse> oldList = db();
        List<UserResponse> newList = new ArrayList<>();

        oldList.forEach(user -> {
            if(!Objects.equals(id, user.getId())) {
                newList.add(user);
            }
        });

        return newList;
    }

    private List<UserResponse> db() {
        List<UserResponse> allUsers = new ArrayList<>();

        allUsers.add(UserResponse.builder().id(1).fullName("Michael Jordan").build());
        allUsers.add(UserResponse.builder().id(2).fullName("Lebron James").build());
        allUsers.add(UserResponse.builder().id(3).fullName("Kobe Bryant").build());

        return allUsers;
    }
}
