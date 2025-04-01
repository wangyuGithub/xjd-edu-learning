package com.xjd.edu.api.course;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@FeignClient(name = "xjd-edu-learning-course", contextId = "courseServiceClient", path = "/com.xjd.edu.course.client.CourseServiceClient")
public interface CourseClient {
    @PostMapping("/course/info")
    String info();
}
