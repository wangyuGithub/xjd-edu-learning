package com.xjd.edu.user.client;

import com.xjd.edu.api.user.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/com.xjd.edu.user.client.UserServiceClient")
public class UserServiceClient implements UserClient {

    @PostMapping("/user/info")
    public String info(@RequestParam("name") String name, @RequestParam("id") Long id) {
        return name + id;
    }
}
