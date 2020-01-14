package com.briup.crm.service;

import java.util.List;

import com.briup.crm.bean.Contribution;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月9日 下午2:16:56 
*  
*/
public interface ContributionService {

	public List<Contribution> findContribution();
	
	public List<Contribution> findCustMarkUp(int condition);
	
	public List<Contribution> getConstitute();
}
