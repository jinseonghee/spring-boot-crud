package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

   @GetMapping(path = "/hello")
   public String hello() {
       return "get Hello";
   }

   // 옛날에 사용하던 방식. method를 사용하지 않으면 /get/post/put/delete 모두 할당 됨
   @RequestMapping(path = "/hi", method = RequestMethod.GET) // path, method 이 두가지를 합친게 GetMapping
   public String hi() {
       return "hi";
   }

   // http://localhost:8080/api/get/path-variable/{계속 바뀌는 값}. 가독성을 위해 주소에 대문자는 사용하지 않는다.
   @GetMapping("/path-variable/{name}") //pathvariable 뒤에 바뀌는 값에 {}를 쳐주고 무엇을 바꿀건지 괄호 안에 넣어줌
   public String pathVariable(@PathVariable(name = "name") String PathName) { //그런 후 pathVariable annotation 을 사용해서 변수 선언(문자열이고 name을 받음)
       System.out.println("PathVariable : " +PathName); //위에 String 으로 받은 name을 찍어줌
       return PathName;
   }

   // ?key=value&key2=value2(쿼리 파람의 형태는 key=value이기 때문에 map으로 받음)
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) { //queryParam이라는 변수에 String<key>, String<value>로 받음.
                                                                             //@RequestParam 이걸 통해 query parameter를 받음
                                                                             //QueryParameter를 map 으로 받을 경우 key를 전혀 알 수 없어서 모든 key를 다 받음
       StringBuilder sb = new StringBuilder();

       queryParam.entrySet().forEach( entry -> {    // entrySet(Map에 값을 전체 출력)은 entry를 return. forEach는 entry를 반환
           System.out.println(entry.getKey());
           System.out.println(entry.getValue());
           System.out.println("\n");

           sb.append(entry.getKey() + " = " + entry.getValue() + "\n");
       });
       return sb.toString();
    }

    //명확히 api를 지정 후, query parameter에 name,email,age만 들어오라고 지정된 경우 @을 각 변수에 붙여줌
    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,  // queryParam.get("name"); Map 으로 받을 경우 이런식으로 하나씩 넣어줘야 함.
            @RequestParam String email,
            @RequestParam int age
    ) {
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    // dto를 만들어서 queryParameter를 추가 하는 방법
    //매개변수로 객체가 들어오게 되면 queryParameter의 주소들을 spring-boot에서 판단을 하고 key에 해당되는 부분들을 해당 객체(UserRequest)를 찾아 들어가 변수와 이름 매칭
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest) { //패키지 dto의 UserRequest 클래스를 객체로 받아옴.(단 @RequestParam은 사용하지 X)
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
