package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 Class는 REST API를 처리하는 Controller
@RequestMapping("/api") // RequestMapping은 URI 를 지정해 주는 Annotation(주소 할당)
public class ApiController {

    @GetMapping("/hello") // Get방식으로 동작 할 것이기 때문에 GetMapping(http://localhost:8080/api/hello)
    public String hello() { // 문자열을 내려줄 거기 때문에 String
        return "hello spring boot!"; // 해당 주소로 Get방식으로 요청이 들어오면, hello spring boot 문자를 return
    }
}
