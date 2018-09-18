package com.jxb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package:com.jxb.controller
 * @ClassName:UserController
 * @Description:TODO 登录成功/失败的处理器
 * @author:Jiangxb
 * @date:2018年9月18日 下午4:34:27
 * 
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/success")
    public String success() {
        return "恭喜您登录成功";
    }

    @GetMapping("/getEmail")
    public String getEmail() {
        return "xxxx@qq.com";
    }
}
