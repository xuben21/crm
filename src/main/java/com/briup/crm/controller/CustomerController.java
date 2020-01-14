package com.briup.crm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.lookup.ReductionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.crm.bean.CstCustomer;
 
import com.briup.crm.service.CustomerService;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月2日 下午2:51:53 
*  
*/
@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	//简单查询所有顾客信息
	@RequestMapping("/findAllCustomer")
	@ResponseBody
	public List<CstCustomer> findAllCustomer(HttpServletResponse response) {
		List<CstCustomer> customers = service.findAllCustomer();
	 
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
		return customers;
	}
	 
	
	
	//分页查询所有顾客信息
	@RequestMapping("/findAllCustomerByPage/{curPage}")
	public String findAllCustomerByPage(HttpServletRequest request, @PathVariable int curPage) {
		
		PageInfo<CstCustomer> customerInfo = service.findAllCustomerByPage(curPage, 5);
		request.setAttribute("customerInfo", customerInfo);
		return "customer/customer";
	}
	
	//根据客服id查询客户信息
	@RequestMapping("/findCustomerById/{id}")
	@ResponseBody
	public CstCustomer findCustomerById(@PathVariable long id){
		CstCustomer customer = service.findCustomerById(id);
		
		return customer;
	}
	
	@RequestMapping("/saveOrUpdateCustomer")
	@ResponseBody
	public String saveOrUpdateCustomer(CstCustomer customer){
	    service.saveOrUpdateCustomer(customer);
	    if(customer.getCustId()==null){
		return "保存成功!";
	    }else{
	    	return "更新成功!";
	    }
	}
	
	@RequestMapping("/deleteCustomerById/{id}")
	@ResponseBody
	public String deleteCustomerById(@PathVariable long id) {
		service.deleteCustomerById(id);
		return "删除成功";
	}
	
	@RequestMapping("/updateCustomer")
	@ResponseBody
	public String updateCustomer(CstCustomer customer) {
		
		service.updateCustomer(customer);
		return "更新成功";
	}
	
	@RequestMapping("/findCustomerLike/{curPage}")
	public String findCustomerLike(@PathVariable int curPage, CstCustomer customer,HttpServletRequest request){
		PageInfo<CstCustomer> customerInfo = service.findCustomerLike(curPage, 5, customer);
		request.setAttribute("customerInfo", customerInfo);
		return "customer/customer";
	}
}
