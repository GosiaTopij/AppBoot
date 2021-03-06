package com.example.demo.services;
import com.example.demo.modal.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public void saveMyUser(User user ) {
        userRepository.save(user);
    }

    public List<User> allUsers(){
        List<User> users = new ArrayList<User>();
        for(User user: userRepository.findAll()){
            users.add(user);
        }
        return users;
    }
    public void deleteMyUser(int id){
        userRepository.deleteById(id);
    }
    public User editUser(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return user;
        }
        return null;
    }
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);

    }
}
