package com.briup.crm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.runner.ReactiveWebApplicationContextRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.CstLinkman;
 
import com.briup.crm.service.CustomerService;
import com.briup.crm.service.LinkManService;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.Session;

/** 
*       Title:客户联系人控制器
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月4日 上午9:15:57 
*  
*/
@RequestMapping("/linkman")
@Controller
public class LinkManController {
    
	@Autowired
	private LinkManService service;
	
	@RequestMapping("/findLinkmanByCustId/{custId}/{curPage}")
	public String findLinkmanByCustId(@PathVariable long custId,@PathVariable int curPage,HttpSession session){
		PageInfo<CstLinkman> linkmanInfo = service.findLinkmanByCustId(custId, 5, curPage);
		//System.out.println("linkmanInfo中的list信息:"+linkmanInfo.getList());
	 
		session.setAttribute("linkmanInfo", linkmanInfo);
		session.setAttribute("custId", custId);
		 
		return "customer/linkman";
	}
	
	@RequestMapping("/deleteLinkmanById/{id}")
	public String deleteLinkmanById(@PathVariable long id,HttpSession session) {
		service.deleteLinkmanById(id);
		long custId = (long)session.getAttribute("custId");
		System.out.println("custId为："+custId);
		return "forward:/linkman/findLinkmanByCustId/"+custId+"/"+"1";
	}
	
	@RequestMapping("/findLinkmanById/{id}")
	@ResponseBody
	public CstLinkman findLinkmanById(@PathVariable long id ){
		CstLinkman linkman = service.findLinkmanById(id);
		return linkman;
	}
	
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(CstLinkman lkm , HttpSession session){
		long custId = (long)session.getAttribute("custId");
		lkm.setLkmCustId(custId);
		service.saveOrUpdate(lkm);
		return "forward:/linkman/findLinkmanByCustId/"+custId+"/"+"1";
	}
}
