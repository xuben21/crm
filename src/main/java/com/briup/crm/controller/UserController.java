package com.briup.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.bean.SysUser;
import com.briup.crm.service.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月2日 上午9:46:19 
*  
*/
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserService userService;
    
    @RequestMapping("/login")
    public String login(String username,String password, HttpSession session)
    {
         String url = "";
         try {
			SysUser user = userService.login(username, password);
			session.setAttribute("user", user);
			return "index";
		} catch (Exception e) {
			// TODO: handle exception
			session.setAttribute("msg", e.getMessage());
			return url="login";
		}
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.removeAttribute("user");
    	return "login";
    }
}
