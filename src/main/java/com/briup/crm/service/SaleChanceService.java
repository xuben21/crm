package com.briup.crm.service;

import com.briup.crm.bean.SalChance;
import com.briup.crm.bean.extend.SalChanceExtend;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月6日 下午2:20:03 
*  
*/
public interface SaleChanceService {

	public PageInfo<SalChance> findSaleChance(int size,int curPage);
	
	public PageInfo<SalChance> findSaleChanceLike(int size,int curPage,String custName,String custRegion);
	
	public void saveOrUpdate(SalChance chance);

	public SalChance findSaleChanceById(long id);
	
	public void deleteSaleChanceById(long id);
	
	public PageInfo<SalChance> findChanceByUserId(int curPage,String dueTo);
	
	public PageInfo<SalChance> findChanceByUserNameAndRegion(int curPage,int size,String dueTo,String region);
	
	public SalChanceExtend findChanceWithPlanById(long id);
}
