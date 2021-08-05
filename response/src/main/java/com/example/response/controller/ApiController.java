package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    //TEXT
    @GetMapping("/text")
    public String text(@RequestParam String account) { //Getmapping으로 넘어온 특정 한 값을 return(String의 형태로 response 내림)
        return account;
    }

    //JSON
    //req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user) {
        return user; //200 ok
    }


    //ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user) {

        //응답에 대한 customizing이 필요하다면 ResponseEntity사용
        return ResponseEntity.status(HttpStatus.CREATED).body(user); //response를 내려줄 때, HTTP status를 정해줌(created는 리소스가 생성되어있을떄 코드가 201을 내림 )
        //ResponseEntity.ok(user); 200
    }
}
