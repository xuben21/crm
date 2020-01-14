package com.briup.crm.controller;

import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.SalChance;
import com.briup.crm.bean.SalPlan;
import com.briup.crm.bean.SysUser;
import com.briup.crm.bean.extend.SalChanceExtend;
import com.briup.crm.service.PlanService;
import com.briup.crm.service.SaleChanceService;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.Session;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月7日 上午9:09:53 
*  
*/
@Controller
@RequestMapping("/plan")
public class PlansController {

	@Autowired
	private PlanService service;
	
	@Autowired
	private SaleChanceService salService;
	
	@RequestMapping("/findPlansByUserId/{curPage}")
	public String findPlansByUserId(@PathVariable int curPage,HttpSession session){
		SysUser user  = (SysUser) session.getAttribute("user");
		PageInfo<SalChance> chanceInfo = salService.findChanceByUserId(curPage, user.getUsrName());
		session.setAttribute("chanceInfo", chanceInfo);
		return "sales/plans";
	}
	
	@RequestMapping("findChanceByUserNameAndRegion")
	public String findChanceByUserNameAndRegion(@PathVariable int curPage,String region,HttpSession session){
		SysUser user  = (SysUser) session.getAttribute("user");
		PageInfo<SalChance> chanceInfo = salService.findChanceByUserNameAndRegion(curPage, 5, user.getUsrName(), region);
		session.setAttribute("chanceInfo", chanceInfo);
		return "sales/plans";
	}
	
	@RequestMapping("/toPlanAdd/{chanceId}")
	public String toPlanAdd(@PathVariable long chanceId,HttpSession session){
		session.setAttribute("chanceId", chanceId);
		SalChance chance = salService.findSaleChanceById(chanceId);
		session.setAttribute("chance", chance);
		return "sales/plan_add";
	}
	
	@RequestMapping("/toPlanEdit/{chanceId}")
	public String toPlanEdit(@PathVariable long chanceId,HttpSession session){
		SalChanceExtend chanceExtend = salService.findChanceWithPlanById(chanceId);
		session.setAttribute("chanceId", chanceId);
	    session.setAttribute("chance", chanceExtend);
		return "sales/plan_edit";
	}
	
	@RequestMapping("/addPlan")
	public String addPlan(SalPlan plan,HttpSession session){
		long chanceId = (long)session.getAttribute("chanceId");
		service.savePlan(plan, chanceId);
		return "forward:/plan/findPlansByUserId/1";
	}
	
	@RequestMapping("/toPlanDetail/{chanceId}")
	public String toPlanDetial(@PathVariable long chanceId,HttpSession session){
	    SalChanceExtend chanceExtend = salService.findChanceWithPlanById(chanceId);
	    session.setAttribute("chance", chanceExtend);
		return "sales/plan_detail";
	}
	
	@RequestMapping("/findPlanById/{id}")
	@ResponseBody
	public SalPlan findPlanById(@PathVariable long id){
		SalPlan plan = service.findPlanById(id);
		return plan;
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(SalPlan plan,HttpSession session){
		long chanceId = (long)session.getAttribute("chanceId");
		service.saveOrUpdatePlan(plan);
		return "forward:/toPlanEdit/"+chanceId;
	}
	
}
