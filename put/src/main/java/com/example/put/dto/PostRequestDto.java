package com.example.put.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

//class에 대해서 전체적으로 같은 룰을 적용 시킴.(해당 클래스는 object라는 모듈이 동작 할 때 snakecase로 인식 함)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PostRequestDto {

    private String name;
    private int age;
    //@JsonProperty 일괄적으로 한가지 변수에 대해 naming을 지어주는 @
    private List<CarDto> carList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CarDto> getCarList() {
        return carList;
    }

    public void setCarList(List<CarDto> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", carList=" + carList +
                '}';
    }
}
