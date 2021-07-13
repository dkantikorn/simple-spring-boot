package com.example.demo.controllers;

import com.example.demo.entity.user.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final String redirectIndex = "redirect:/users/index";

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping({"", "/index"})
    public String listAllUser(Model model) {
        model.addAttribute("users",userRepository.findAll());
        return "users/index";
    }

    @GetMapping("/signup")
    public String showRegisterForm(User user) {
        return "users/add";
    }

    @PostMapping("/addUser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "users/add";
        }

        userRepository.save(user);
        return redirectIndex;
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user id: " + id));
        model.addAttribute("user", user);
        return "users/update";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()){
            user.setId(id);
            return "users/update";
        }

        userRepository.save(user);
        return redirectIndex;
    }

    //@DeleteMapping("/delete/{id}")
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id,Model model){
            User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid user id: " + id));
            userRepository.deleteById(id);
            return redirectIndex;
    }
}
