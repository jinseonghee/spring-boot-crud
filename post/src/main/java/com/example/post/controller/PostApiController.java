package com.example.post.controller;

import com.example.post.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiController {

    @PostMapping("/post")
    public void post(@RequestBody Map<String, Object> requestData) { //key, value 이기 떄문에 map, value에 해당되는 값들은 boolean도 있고 number도 있어서 object로 받음
                                                                     //http post에 요청을 보낼때 body에 data를 심었다라는 뜻에서 @RequestBody를 붙어줘야 함.
                                                                     //Map은 어떤값을 보낼지 알아야 하는데, 알 수 없어서 쓰기 애매함.
        requestData.forEach((key, value) -> {
            System.out.println("key : " + key);
            System.out.println("value : " + value);
        });
        /*
         requestData.entrySet().forEach(stringObjectEntry -> {
            System.out.println("key : " + stringObjectEntry.getKey());
            System.out.println("value : " + stringObjectEntry.getValue());
        });
        */
    }

    @PostMapping("/post1")
    public void post(@RequestBody PostRequestDto requestData) {
        System.out.println(requestData);

       //requestData.getAccount() 특정 변수에 있는 데이터를 가져올 경우 이런식으로 데이터를 처리
    }
}
