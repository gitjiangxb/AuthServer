package com.jxb.controller;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @Package:com.jxb.controller
 * @ClassName:HomeController
 * @Description:TODO 
 * @author:Jiangxb
 * @date:2018年9月18日 下午4:25:54
 * 前后端分离思想： 
 *	在用户第一次登录成功后，服务端返回一个token回来，这个token是根据userId进行加密的，密钥只有服务器知道，
 *然后浏览器每次请求都把这个token放在Header里请求，这样服务器只需进行简单的解密就知道是哪个用户了。
 *前后端分离之Java后端
 *	https://blog.csdn.net/jimo_lonely/article/details/69357365
 *前后端分离之VueJS前端
 *	https://blog.csdn.net/jimo_lonely/article/details/69664785
 */
@RestController
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/login")
	@ResponseBody
    public String login(@RequestParam("username") String name, @RequestParam("password") String pass)
            throws ServletException {
        String token = "";
        if (!"admin".equals(name)) {
            throw new ServletException("找不到该用户");
        }
        if (!"1234".equals(pass)) {
            throw new ServletException("密码错误");
        }
        token = Jwts.builder().setSubject(name).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "base64EncodedSecretKey").compact();
        return token;
    }
}
