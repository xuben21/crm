package com.briup.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.CstService;
import com.briup.crm.bean.SysUser;
import com.briup.crm.service.ServeService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired
	ServeService serveService;
	
	//根据经理id查找service
	@RequestMapping("/findServiceByUserName/{curPage}")
	public String findServiceByUserName(@PathVariable int curPage, HttpSession session) {
		SysUser user = (SysUser)session.getAttribute("user");
		String userName = user.getUsrName();
		PageInfo<CstService> info = serveService.findServiceByUserName(curPage, 5, userName);
		session.setAttribute("serviceInfo", info);
		return "service/service";
	}
	
	//模糊查询
	@RequestMapping("/findServiceByCustNameAndType/{curPage}")
	public String findServiceByCustNameAndType(@PathVariable int curPage, CstService service, HttpSession session) {
		SysUser user = (SysUser)session.getAttribute("user");
		String userName = user.getUsrName();
		service.setSvrDispose(userName);
		PageInfo<CstService> info = serveService.findServiceByCustNameAndType(curPage, 5, service);
		session.setAttribute("serviceInfo", info);
		return "service/service";
	}
	
	//新增和更新
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(CstService service, HttpSession session) {
		
		serveService.saveOrUpdate(service);
		
		return "forward:/service/findServiceByUserName/1" ;
	}
	
	//根据serId查找service
	@RequestMapping("/findServiceById/{svrId}")
	@ResponseBody
	public CstService findServiceById(@PathVariable Long svrId) {
		CstService service = serveService.findServiceById(svrId);
		return service;
	}
	
	//更新状态为已处理
	@RequestMapping("/updateStatusById/{svrId}")
	public String updateStatusById(@PathVariable Long svrId) {
		serveService.updateStatusById(svrId);
		return "forward:/service/findServiceByUserName/1";
	}
	
	//根据svrId查找service
	@RequestMapping("/findServiceDetailById/{svrId}")
	public String findServiceById(@PathVariable Long svrId, HttpSession session) {
		CstService service = serveService.findServiceById(svrId);
		session.setAttribute("service", service);
		return "service/serviceDetail2";
	}
	
	//根据用户名字查询用户反馈
	@RequestMapping("/findFeedbackByUserName/{curPage}")
	public String findFeedbackByUserName(@PathVariable int curPage, HttpSession session){
		SysUser user = (SysUser)session.getAttribute("user");
		String userName = user.getUsrName();
		PageInfo<CstService> info = serveService.findServiceByUserName(curPage, 5, userName);
		session.setAttribute("feedbackInfo", info);
		return "service/feedback";
	}
}
