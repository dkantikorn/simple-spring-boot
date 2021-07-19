package com.example.demo.entity.customer;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50, message = "First name length between 2 - 50")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 100, message = "Last name length between 2 - 100")
    private String lastName;

    @Min(value = 18, message = "Age possible minimum value is 18")
    private Integer age;

    @Email(message = "Please provide for valid email address")
    private String email;
}
