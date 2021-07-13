package com.example.demo.controllers;

import com.example.demo.entity.user.User;
import com.example.demo.model.AjaxResponseBody;
import com.example.demo.model.SearchCriteria;
import com.example.demo.repository.UserRepository;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final String redirectIndex = "redirect:/users/index";
    private final UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @GetMapping({"", "/index"})
    public String listAllUser(Model model) {
        model.addAttribute("users",userRepository.findAll());
        return "users/index";
    }

    @ResponseBody
    @PostMapping("/api/search")
    public ResponseEntity<?> searchUserViaAjax(@Valid @RequestBody SearchCriteria searchCriteria, Errors result){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if(result.hasErrors()){
            ajaxResponseBody.setMsg(result.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);
        }

        Optional<List<User>> users = userService.findByUserNameOrEmail(searchCriteria.getName());
        System.out.println("name: " + searchCriteria.getName());
        System.out.println("User: " + users);
        if (!users.isPresent()) {
            ajaxResponseBody.setMsg("no user found!");
        } else {
            ajaxResponseBody.setMsg("success");
        }
        ajaxResponseBody.setResult(users);
        return ResponseEntity.ok(ajaxResponseBody);
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

    @ResponseBody()
    @DeleteMapping("/delete/{id}")
    //@GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id,Model model){
            User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid user id: " + id));
            userRepository.deleteById(id);
            return "success";
            //return redirectIndex;
    }
}
