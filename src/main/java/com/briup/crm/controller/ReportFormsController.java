package com.briup.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.Contribution;
import com.briup.crm.service.ContributionService;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月9日 下午2:08:03 
*  
*/
@Controller
@RequestMapping("reportForms")
public class ReportFormsController {

	@Autowired
	private ContributionService service;
	
	@RequestMapping("/toContribution")
	public String toContribution(){
		return "reportForms/contribution";
	}
	
	@RequestMapping("/getContribution")
	@ResponseBody
	public List<Contribution> getContribution(){
		List<Contribution> contributions = service.findContribution();
		return contributions;
	}
	
	
	@RequestMapping("/toConstitute")
	public String toConstitute(){
		return "reportForms/constitute";
	}
	
	@RequestMapping("/getConstitute/{constitute}")
	@ResponseBody
	public List<Contribution> getConstitute(@PathVariable int constitute){
		List<Contribution> contributions = service.findCustMarkUp(constitute);
		System.out.println("构成集合为:"+contributions);
		return contributions;
	}
	 
}
