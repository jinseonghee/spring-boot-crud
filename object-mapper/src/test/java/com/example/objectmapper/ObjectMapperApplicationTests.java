package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("------------------");

		//Text Json -> Object
		//Object -> Text Json

		//Controller req Json(text) -> object
		//response object -> json(text)

		var objectMapper = new ObjectMapper(); // 추론 타입(java 11부터 지원)

		//object -> text (object mapper가 get method를 활용)
		var user = new User("steve",
				10,
				"010-1111-2222");

		var text = objectMapper.writeValueAsString(user); //text로 바꿈. writeValueAsString는 value를 String으로 바꾸는 형태
																 //괄호 안에 객체를 넣음.
		System.out.println(text);

		//text -> object (object mapper가 동작 하기 위해서 default constructor가 필요)
		var objectUser = objectMapper.readValue(text, User.class); //()안에 text는 json text를 말하고, 두번째는 어떤 클래스를 바꿀건지 넣어줌
		System.out.println(objectUser);
	}
}
