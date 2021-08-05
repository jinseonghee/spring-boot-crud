package com.example.response.controller;

import com.example.response.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //HTML 페이지 리소스를 찾음
public class PageController {

    @RequestMapping("/main")
    public String main() { //return 자체가 String이 되면 자동으로 리소에 있는 html 파일을 찾아감
        return "main.html";
    }

    //json을 내려주는 방법 2가지
    //ResponseEntity

    //ResponseBody - 잘 선호하지 않는 방법(RestController를 선호)
    @ResponseBody //객체 자체를 return 했을 떄 리소스를 찾지 않고 responsebody를 만들어서 내리겠다는 annotation
    @GetMapping("/user")
    public User user(){

        var user = new User(); //타입 추론(자바 11 지원) = User user = new User();
        user.setName("steve");
        user.setAddress("서울시 마포구");

        return user;
    }
}
