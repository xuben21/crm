package com.briup.crm.service;

import com.briup.crm.bean.CstService;
import com.github.pagehelper.PageInfo;

public interface ServeService {

	public PageInfo<CstService> findServiceByUserName(int curPage, int size, String userName);
	
	//模糊查询
	public PageInfo<CstService> findServiceByCustNameAndType(int curPage, int size, CstService service);
	
	//增加或修改
	public void saveOrUpdate(CstService service);
	
	//根据id查找service
	public CstService findServiceById(Long id);
	
	//更新status为已处理
	public void updateStatusById(Long id);
	
	//查询服务反馈
	public PageInfo<CstService> findFeedbackByUserName(int curPage, int size, String userName);
	
}
