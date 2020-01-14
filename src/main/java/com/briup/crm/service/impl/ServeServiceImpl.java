package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.CstService;
import com.briup.crm.bean.CstServiceExample;
import com.briup.crm.dao.CstServiceMapper;
import com.briup.crm.service.ServeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ServeServiceImpl implements ServeService{

	@Autowired
	CstServiceMapper serviceMapper;
	
	public PageInfo<CstService> findServiceByUserName(int curPage, int size, String userName) {
		PageHelper.startPage(curPage, size);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrDisposeEqualTo(userName);
		List<CstService> list = serviceMapper.selectByExample(example);
		PageInfo<CstService> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	//模糊查询
	@Override
	public PageInfo<CstService> findServiceByCustNameAndType(int curPage, int size, CstService service) {
		PageHelper.startPage(curPage, size);
		CstServiceExample example = new CstServiceExample();
		String custName = service.getSvrCustName();
		String type = service.getSvrType();
		String userName = service.getSvrDispose();
		example.createCriteria().andSvrCustNameLike("%"+custName+"%").andSvrTypeEqualTo(type).andSvrDisposeEqualTo(userName);
		List<CstService> list = serviceMapper.selectByExample(example);
		PageInfo<CstService> pageInfo = new PageInfo<>(list);
		return pageInfo;
		
	}

	//增加或修改
	@Override
	public void saveOrUpdate(CstService service) {
		if(service.getSvrId() == null) {
			serviceMapper.insertSelective(service);
		} else {
			serviceMapper.updateByPrimaryKeySelective(service);
		}
	}

	//根据id查找service
	@Override
	public CstService findServiceById(Long id) {
		CstService service = serviceMapper.selectByPrimaryKey(id);
		return service;
	}

	//更新status为已处理
	@Override
	public void updateStatusById(Long id) {
		CstService service = serviceMapper.selectByPrimaryKey(id);
		service.setSvrStatus("已处理");
		serviceMapper.updateByPrimaryKey(service);
	}

	@Override
	public PageInfo<CstService> findFeedbackByUserName(int curPage, int size, String userName) {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage, size);
		CstServiceExample example = new CstServiceExample();
		example.createCriteria().andSvrDisposeEqualTo(userName);
		List<CstService> list = serviceMapper.selectByExample(example);
		PageInfo<CstService> feedbackInfo = new PageInfo<>(list);
		return feedbackInfo;
		 
	}

}
