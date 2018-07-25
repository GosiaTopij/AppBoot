package com.example.demo.controller;
import com.example.demo.modal.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@Controller
public class WelcomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request){
        request.setAttribute("mode","MODE_HOME");
        return "welcomepage";
    }

    @RequestMapping("/register")
    public String registration(HttpServletRequest request){
        request.setAttribute("mode","MODE_REGISTER");
        return "welcomepage";
    }

    @PostMapping("/save-user")
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request){
        userService.saveMyUser(user);
        request.setAttribute("mode","MODE_HOME");
        return "welcomepage";
    }
    @GetMapping("/all-users")
    public String allUsers(HttpServletRequest request){
        request.setAttribute("users", userService.allUsers());
        request.setAttribute("mode","ALL_USERS");
        return "welcomepage";
    }

    @RequestMapping("/delete-user")
    public String deleteUser(@RequestParam int id, HttpServletRequest request){
        userService.deleteMyUser(id);
        request.setAttribute("users", userService.allUsers());
        request.setAttribute("mode","ALL_USERS");
        return "welcomepage";
    }

    @RequestMapping("/edit-user")
    public String editUser(@RequestParam int id,HttpServletRequest request) {
        request.setAttribute("user", userService.editUser(id));
        request.setAttribute("mode", "MODE_UPDATE");
        return "welcomepage";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_LOGIN");
        return "welcomepage";
    }

    @RequestMapping ("/login-user")
    public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
        if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
            request.setAttribute("mode", "MODE_SUCCESS");
            return "welcomepage";
        }
        else {
            request.setAttribute("error", "Invalid Username or Password");
            request.setAttribute("mode", "MODE_LOGIN");
            return "welcomepage";

        }
    }
}
