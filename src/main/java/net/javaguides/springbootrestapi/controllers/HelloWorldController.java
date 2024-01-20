package net.javaguides.springbootrestapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
//HTTP GET Request
    //http:localhost:8080/helloWorld
//@GetMapping Mapping("/helloWorld")
@RequestMapping("/helloWorld")
    public String helloWorld(){
        return"HEllo World";
    }


}
