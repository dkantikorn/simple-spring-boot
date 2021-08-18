package com.example.demo;

import com.example.demo.entity.student.Students;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Logger;

@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String home(ModelMap model) {
        String hello = "Hello sarawutt.b";
        Students student = new Students("sarawutt bureekeaw", "sarawutt.b@gmail.com", LocalDate.of(1986, Month.SEPTEMBER, 23));
        model.addAttribute("welcomeMessage", hello);
        model.addAttribute("students", student);
        return "home/index";
    }

//    @GetMapping("/")
//    public String welcomePage() {
//        return "Welcome to Spring Boot";
//    }

//	@GetMapping
//	public String hello(){
//		return "Hello Sarawutt";
//	}

//	@GetMapping
//	public List<String> hello(){
//		return List.of("Hello World","Sarawutt");
//	}
}
