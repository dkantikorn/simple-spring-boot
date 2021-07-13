package com.example.demo.model;

import com.example.demo.entity.user.User;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
public class AjaxResponseBody {
    String msg;
    Optional<List<User>> result;
}
