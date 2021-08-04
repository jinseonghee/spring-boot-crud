package com.example.put;

import com.example.put.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class PutApiController {


    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") Long id) {
                                        //@PathVariable은 {userId}와 메서드에 써준 변수의 이름과 일치해야 하는데, 그럴 수 없을 경우 Name property를 사용하여 맞춰준다.

        System.out.println(id);
        //System.out.println(requestDto); //RestController의 경우 그냥 object를 Return 시키면 Spring boot가 이 object를 가지고
        return requestDto;              // object mapper를 통해 json으로 바꿔준다
                                        //에코 - 내가 매개변수로 받았던 데이터를 그대로 return되기 때문에 내가 보냈던 데이터가 그대로 return
    }
}

