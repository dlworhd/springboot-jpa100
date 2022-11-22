package com.utfda.springbootjpa100.ch1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FirstController {


    //주소 매핑과 Method를 같이 설정하는 RequestMapping 방식
    @RequestMapping(value = "/first-url", method = RequestMethod.GET)
    public void first(){

    }

}
