package com.example.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostRequestDto {

    private String account; //요청하는 json의 key에 해당되기 때문에 json의 key와 매칭이 되어야 함
    private String email;
    private String address;
    private String password;

    @JsonProperty("phone_number") //변수에 다 달아줘야 하는 단점이 있지만 이 어노테이션을 쓰고 이름을 달아주면 특정 이름에 매칭 가능
    private String phoneNumber; //camelcase, phone_number(snakecase)
                                //object mapper를 library를 통해서 text data가 결국엔 Object로 바뀌게 되는데, 따로 변수 이름을 바꿔주지 않으면
                                //json형식에서 보낸 snakecase를 찾아가기 떄문에 camelcase로 변수 선언이 되어있는걸 못 찾음

    @JsonProperty("OTP")//camelcase, snakecase도 아닌 특정한 값이나 약어를 사용할 때, @JsonProperty를 사용하여, 실제로 json으로 들어오는 이름 값을 매칭
    private  String OTP;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "PostRequestDto{" +
                "account='" + account + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", OTP='" + OTP + '\'' +
                '}';
    }
}
