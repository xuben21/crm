package com.briup.crm.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.Contribution;
import com.briup.crm.dao.extend.CustomerExtendMapper;
import com.briup.crm.service.ContributionService;
import com.briup.crm.service.CustomerService;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月9日 下午2:18:33 
*  
*/
@Service
public class ContributionServiceImpl implements ContributionService{

	@Autowired
	private CustomerExtendMapper mapper;
	
	@Autowired
	private CustomerService service;
	
	@Override
	public List<Contribution> findContribution() {
		List<String> regionlist = mapper.selectRegion();
		System.out.println("地区数组为:"+regionlist);
		List<Contribution> conlist = new ArrayList<Contribution>();
		
		for (String region  : regionlist) {
			Contribution con = new Contribution();
			con.setName(region);
			con.setY(service.getRegionPercent(region));
			conlist.add(con);
		}
		// TODO Auto-generated method stub
		System.out.println("最后的贡献对象数组为:"+conlist);
		return conlist;
	}

	@Override
	public List<Contribution> getConstitute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contribution> findCustMarkUp(int condition) {
		// TODO Auto-generated method stub
		int count = service.findAllCustomer().size();
		List<Contribution> contributions = new ArrayList<Contribution>();
		
		if(condition == 0){//等级
			Set<String> levels = service.findAllLevel();
			System.out.println("等级"+levels);
		    for (String string : levels) {
				int size = service.getCustByLevel(string);
				float percent = (float)size/count;
				Contribution con = new Contribution();
				con.setName(string);
				con.setY(percent);
				System.out.println(con);
				contributions.add(con);
			}
		    System.out.println("在serviceImpl里面的Contribution集合"+contributions);
		    return contributions;
		}else if(condition == 1){//信誉度
			Set<Integer> levels = service.findAllCredit();
		    for (Integer string : levels) {
				int size = service.getCustByCredit(string);
				float percent = (float)size/count;
				Contribution con = new Contribution();
				con.setName(""+string);
				con.setY(percent);
				System.out.println(con);
				contributions.add(con);
			}
		    System.out.println("在serviceImpl里面的Contribution集合"+contributions);
		    return contributions;
		}else {//按满意度
			Set<Integer> levels = service.findAllSatisfy();
		    for (Integer string : levels) {
				int size = service.getCustBySatisfy(string);
				float percent = (float)size/count;
				Contribution con = new Contribution();
				con.setName(""+string);
				con.setY(percent);
				System.out.println(con);
				contributions.add(con);
			}
		    System.out.println("在serviceImpl里面的Contribution集合"+contributions);
		    return contributions;
		}
		
	}

}
