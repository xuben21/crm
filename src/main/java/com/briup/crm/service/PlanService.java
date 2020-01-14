package com.briup.crm.service;

import com.briup.crm.bean.SalPlan;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月7日 上午9:10:46 
*  
*/
public interface PlanService {
    public void savePlan(SalPlan plan,long chanceId);
    
    public SalPlan findPlanById(long id);
    
    public void saveOrUpdatePlan(SalPlan plan);
}
