package com.utfda.springbootjpa100.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//return 타입이 View 리졸버가 아니라 String 형태로 반환하는 컨트롤러
@RestController
public class SecondController {


    @RequestMapping(value = "/ hello-spring", method = RequestMethod.GET)
    public String helloString(){

        return"Hello Spring";
    }


    //Mapping에 method 값을 덧붙여서 @GetMapping을 쓸 수 있다.
    @GetMapping("/hello-rest")
    public String helloRest(){

        return "hello rest";
    }

    //API는 내가 가지고 있는 기능을 외부에 제공하는 것 -> 보통 api라는 도메인을 써서 제공함
    @GetMapping("/api/helloworld")
    public String helloRestApi(){
        return "hello rest api";
    }


}
