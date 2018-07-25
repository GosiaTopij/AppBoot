package com.example.demo.controller;
import com.example.demo.modal.User;
import com.example.demo.repository.KlientRepository;
import com.example.demo.services.KlientService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UserService userService;

    @Autowired
    private KlientService klientService;
    @Autowired
    KlientRepository klientRepository;

    @RequestMapping(value="/all")
    public String allKlients(){
        return klientService.findAll().toString();
    }
    /* @GetMapping("/all2")
    public String testMethod() {
        StringBuilder response = new StringBuilder();

        Klient klient = new Klient("imie","nazw",585);
        klientRepository.save(klient);

        for(Klient i: klientRepository.findAll()) {
            response.append(i).append("<br>");
        }
        return response.toString();
    }*/

    @GetMapping("/hello")
    public String hello() {
        return "This is Home page";
    }

    @GetMapping("/save-user")
    public String saveUser(@RequestParam String username, @RequestParam String firstname,  @RequestParam String lastname,  @RequestParam int age, @RequestParam String password  ){
        User user = new User(username,firstname,lastname,age,password);
        userService.saveMyUser(user);
        return "User saved!";
    }

}
