package com.briup.crm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.SalChance;
import com.briup.crm.service.SaleChanceService;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月6日 下午2:16:28 
*  
*/
@Controller
@RequestMapping("/sale")
public class SaleChanceController {

	@Autowired
	private SaleChanceService service;
	
	@RequestMapping("/findSaleChance/{curPage}")
	public String findSaleChance(@PathVariable int curPage,HttpSession session) {
		PageInfo<SalChance> saleChance = service.findSaleChance(5, curPage);
		session.setAttribute("saleInfo", saleChance);
		return "sales/sales";
	}
	
	@RequestMapping("/findSaleChanceLike/{curPage}")
	public String findSaleChanceLike(@PathVariable int curPage,String custName,String region,HttpSession session){
		PageInfo<SalChance> saleChance = service.findSaleChanceLike(5, curPage,custName , region);
		session.setAttribute("saleInfo", saleChance);
		return "sales/sales";
	}
	
	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public String saveOrUpdate(SalChance chance){
		
		service.saveOrUpdate(chance);
		return "操作成功";
	}
	
	@RequestMapping("/findSaleById/{id}")
	@ResponseBody
	public SalChance findSaleById(@PathVariable long id){
		SalChance sale = service.findSaleChanceById(id);
		return sale;
	}
	
	@RequestMapping("/deleteSaleById/{id}")
	public String deleteSaleById(@PathVariable long id){
		service.deleteSaleChanceById(id);
		return "forward:/sale/findSaleChance/1";
	}
	
	
}
