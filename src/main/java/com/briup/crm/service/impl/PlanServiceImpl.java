package com.briup.crm.service.impl;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.SalChance;
import com.briup.crm.bean.SalPlan;
import com.briup.crm.dao.SalChanceMapper;
import com.briup.crm.dao.SalPlanMapper;
import com.briup.crm.service.PlanService;

/** 
*       Title:开发计划
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月7日 上午9:11:05 
*  
*/
@Service
public class PlanServiceImpl implements PlanService {
     
	@Autowired
	private SalPlanMapper planMapper;

	@Autowired
	private SalChanceMapper chanceMapper;
	
	@Override
	public void savePlan(SalPlan plan,long chanceId) {
		// TODO Auto-generated method stub
		planMapper.insertSelective(plan);
		SalChance chance = chanceMapper.selectByPrimaryKey(chanceId);
		chance.setChcStatus(2);
		chanceMapper.updateByPrimaryKey(chance);
		
	}

	@Override
	public SalPlan findPlanById(long id) {
		// TODO Auto-generated method stub
		SalPlan plan = planMapper.selectByPrimaryKey(id);
		return plan;
	}

	@Override
	public void saveOrUpdatePlan(SalPlan plan) {
		// TODO Auto-generated method stub
		if(plan.getPlaId()!=null){
		planMapper.updateByPrimaryKeySelective(plan);
		}else{
			planMapper.insertSelective(plan);
		}
		
	}
}
