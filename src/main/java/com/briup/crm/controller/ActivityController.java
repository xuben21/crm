package com.briup.crm.controller;

import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.CstActivity;
import com.briup.crm.service.ActivityService;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月6日 上午9:22:03 
*  
*/
@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private ActivityService service;
	
	@RequestMapping("/findActivitiesByCustId/{custId}/{curPage}")
	public String findActivitiesByCustId(@PathVariable long custId,@PathVariable int curPage,HttpSession session){
		PageInfo<CstActivity> activities = service.findActivitiesByCustId(curPage, 5, custId);
		session.setAttribute("activityInfo", activities);
		session.setAttribute("custId", custId);
		return "customer/activities";
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(CstActivity activity,HttpSession session){
		long custId = (long)session.getAttribute("custId");
		activity.setAtvCustId(custId);
		service.saveOrUpdate(activity);
		return "forward:/activity/findActivitiesByCustId/"+custId+ "/1";
	}
	
	@RequestMapping("/findActivityById/{id}")
	@ResponseBody
	public CstActivity findActivityById(@PathVariable long id){
		CstActivity a = service.findActivityById(id);
		return a;
	}
	
	@RequestMapping("/deleteActivityById/{id}")
	public String deleteActivityById(@PathVariable long id,HttpSession session){
		long custId = (long)session.getAttribute("custId");
		service.deleteActivityById(id);
		return "forward:/activity/findActivitiesByCustId/"+custId+ "/1";
	}
}
