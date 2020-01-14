package com.briup.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
*       Title:定义首页
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月2日 上午10:21:18 
*  
*/
@Controller
public class ViewController {

	@RequestMapping("/")
	public String wow(){
		return "login";
	}
}
