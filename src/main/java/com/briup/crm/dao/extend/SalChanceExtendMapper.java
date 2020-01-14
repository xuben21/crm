package com.briup.crm.dao.extend;

import com.briup.crm.bean.extend.SalChanceExtend;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月7日 下午2:38:17 
*  
*/
public interface SalChanceExtendMapper {
	
       public SalChanceExtend selectChanceWithPlanById(long chanceId);
}
