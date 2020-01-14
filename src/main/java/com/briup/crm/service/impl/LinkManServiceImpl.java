package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.CstLinkman;
import com.briup.crm.bean.CstLinkmanExample;
import com.briup.crm.bean.CstLinkman;
import com.briup.crm.dao.CstLinkmanMapper;
import com.briup.crm.service.LinkManService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月4日 上午9:19:49 
*  
*/
@Service
public class LinkManServiceImpl implements LinkManService{

	@Autowired
	private CstLinkmanMapper mapper;
	
	@Override
	public PageInfo<CstLinkman> findLinkmanByCustId(long custId,int size, int curPage) {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage,size);
		CstLinkmanExample example = new CstLinkmanExample();
		example.createCriteria().andLkmCustIdEqualTo(custId);
		List<CstLinkman> linkmans = mapper.selectByExample(example);
		//System.out.println("linkman集合信息:"+linkmans);
		PageInfo<CstLinkman> linkmanInfo = new PageInfo<CstLinkman>(linkmans);
		 
		return linkmanInfo;
	}

	@Override
	public void deleteLinkmanById(long id) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public CstLinkman findLinkmanById(long id) {
		// TODO Auto-generated method stub
		 
		CstLinkman linkman = mapper.selectByPrimaryKey(id);
		return linkman;
	}
	
	@Override
	public void saveOrUpdate(CstLinkman linkman) {
		// TODO Auto-generated method stub
		if(linkman.getLkmId() == null){
			mapper.insertSelective(linkman);
		}else{
			mapper.updateByPrimaryKey(linkman);
		}
	}

	 
  
}
