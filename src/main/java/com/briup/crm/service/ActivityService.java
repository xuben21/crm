package com.briup.crm.service;

import com.briup.crm.bean.CstActivity;
import com.briup.crm.bean.CstLinkman;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月6日 上午9:24:26 
*  
*/
public interface ActivityService {
	public PageInfo<CstActivity> findActivitiesByCustId(int curPage, int size,long custId);
	
	public void saveOrUpdate(CstActivity activity);

	public CstActivity findActivityById(long id);

	public void deleteActivityById(long id);
}
