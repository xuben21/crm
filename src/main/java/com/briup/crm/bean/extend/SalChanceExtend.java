package com.briup.crm.bean.extend;

import java.util.List;

import com.briup.crm.bean.SalChance;
import com.briup.crm.bean.SalPlan;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月7日 下午2:25:23 
*  
*/
public class SalChanceExtend extends SalChance{
    private List<SalPlan> plans;

	public List<SalPlan> getPlans() {
		return plans;
	}

	public void setPlans(List<SalPlan> plans) {
		this.plans = plans;
	}
    
    
    
}
