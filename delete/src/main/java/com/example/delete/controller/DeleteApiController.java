package com.example.delete.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteApiController {

    @DeleteMapping("/delete/{userId}") //delete는 request가 틀리지 않는 이상 항상 똑같은 응답을 받기 때문에 멱등
    public void delete(@PathVariable String userId, @RequestParam String account) {

        System.out.println(userId);
        System.out.println(account);

        //delete -> 리소스 삭제 200 ok (리소스가 있으나 없으나 삭제되는 건 똑같기 때문에 항상 200ok)
    }
}
