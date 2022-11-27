package com.utfda.springbootjpa100.hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {


    //주소 매핑과 Method를 같이 설정하는 RequestMapping 방식
    @RequestMapping(value = "/first-url", method = RequestMethod.GET)
    public void first(){

    }

    /*
     * RequestMapping의 method default 값은 GET이다.
     * @Controller는 View 페이지를 리턴하게 되어 있어서, @ResponseBody라는 annotation을 써서 사용
     *
     * */

    @ResponseBody
    @RequestMapping("/helloworld")
    public String helloWorld(){

        return "hello World";
    }


}
