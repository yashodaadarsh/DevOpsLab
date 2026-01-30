package org.adarsh.devopslab05.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("hello")
    public String greetings(){
        return "Hello World bhai";
    }

    @GetMapping("message")
    public String message(){
        return "This is the testing message from jenkins. Healthy application";
    }

}
