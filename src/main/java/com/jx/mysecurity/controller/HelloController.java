package com.jx.mysecurity.controller;

import com.jx.mysecurity.util.Result;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author
 * @Date 2022/7/7 17:13
 */
@RestController
public class HelloController {


    @PreAuthorize("hasRole('other')")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    @PreAuthorize(("hasAuthority('run')"))
    @GetMapping("/run")
    public String run() {
        return "run";
    }

}
