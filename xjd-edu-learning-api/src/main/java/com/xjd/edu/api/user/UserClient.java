package com.xjd.edu.api.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@FeignClient(name = "xjd-edu-learning-user", contextId = "userServiceClient", path = "/com.xjd.edu.user.client.UserServiceClient")
public interface UserClient {

    @PostMapping("/user/info")
    String info(@RequestParam("name") String name, @RequestParam("id") Long id);


}
