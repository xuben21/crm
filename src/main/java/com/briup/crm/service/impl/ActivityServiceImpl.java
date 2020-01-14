package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.CstActivity;
import com.briup.crm.bean.CstCustomer;
 
import com.briup.crm.bean.CstActivityExample;
import com.briup.crm.dao.CstActivityMapper;
import com.briup.crm.service.ActivityService;
 
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月6日 上午9:24:56 
*  
*/
@Service
public class ActivityServiceImpl implements ActivityService{
	
	@Autowired
	private CstActivityMapper mapper;
	
	public PageInfo<CstActivity> findActivitiesByCustId(int curPage, int size,long custId){
		
		PageHelper.startPage(curPage,size);
		CstActivityExample example = new CstActivityExample();
		example.createCriteria().andAtvCustIdEqualTo(custId);
		List<CstActivity> activitys = mapper.selectByExample(example);
		//System.out.println("Activity集合信息:"+Activitys);
		PageInfo<CstActivity> activityInfo = new PageInfo<CstActivity>(activitys);
		 
		return activityInfo;
		 
		
	}

	@Override
	public void saveOrUpdate(CstActivity activity) {
		// TODO Auto-generated method stub
		if(activity.getAtvId() == null){
			mapper.insertSelective(activity);
		}else{
			mapper.updateByPrimaryKey(activity);
		}
	}

	@Override
	public CstActivity findActivityById(long id) {
		// TODO Auto-generated method stub
		CstActivity a = mapper.selectByPrimaryKey(id);
		return a;
	}

	@Override
	public void deleteActivityById(long id) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(id);
	}
	   
}
