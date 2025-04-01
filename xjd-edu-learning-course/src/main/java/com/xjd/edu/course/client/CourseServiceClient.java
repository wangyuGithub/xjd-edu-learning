package com.xjd.edu.course.client;

import com.xjd.edu.api.course.CourseClient;
import com.xjd.edu.api.user.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/com.xjd.edu.course.client.CourseServiceClient")
public class CourseServiceClient implements CourseClient {

    @PostMapping("/course/info")
    @Override
    public String info() {
        return "CourseClient info";
    }
}
