package com.briup.crm.service;

import com.briup.crm.bean.CstCustomer;
import com.briup.crm.bean.CstLinkman;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月4日 上午9:18:08 
*  
*/
public interface LinkManService {

	public PageInfo<CstLinkman> findLinkmanByCustId(long custId,int size, int curPage);
	
	public void deleteLinkmanById(long id);

	public CstLinkman findLinkmanById(long id);
	
	public void saveOrUpdate(CstLinkman linkman);
}
