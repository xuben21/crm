package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.crm.bean.CstCustomer;
import com.briup.crm.bean.CstCustomerExample;
import com.briup.crm.bean.SalChance;
import com.briup.crm.bean.SalChanceExample;
import com.briup.crm.bean.extend.SalChanceExtend;
import com.briup.crm.dao.SalChanceMapper;
import com.briup.crm.dao.extend.SalChanceExtendMapper;
import com.briup.crm.service.SaleChanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月6日 下午2:20:23 
*  
*/
@Service
public class SaleChanceServiceImpl implements SaleChanceService{

	@Autowired
	private SalChanceMapper mapper;
	
	@Autowired
	private SalChanceExtendMapper  chanceExtendMapper;
	
	@Override
	public PageInfo<SalChance> findSaleChance(int size, int curPage) {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage,size);
		SalChanceExample example = new SalChanceExample();
		List<SalChance> salChance = mapper.selectByExample(example);
		PageInfo<SalChance> salInfo = new PageInfo<SalChance>(salChance);
		 
		return salInfo;
	}

	@Override
	public PageInfo<SalChance> findSaleChanceLike(int size, int curPage, String custName, String custRegion) {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage,size);
		SalChanceExample example = new SalChanceExample();
		example.createCriteria().andChcCustNameLike("%"+custName+"%" ).andChcAddrLike("%"+custRegion+"%" );
		List<SalChance> salChance = mapper.selectByExample(example);
		PageInfo<SalChance> salInfo = new PageInfo<SalChance>(salChance);
		return salInfo;
	}

	@Override
	public void saveOrUpdate(SalChance chance) {
		// TODO Auto-generated method stub
		if(chance.getChcId() == null){
			mapper.insertSelective(chance);
		}else{
			mapper.updateByPrimaryKey(chance);
		}
	}

	@Override
	public SalChance findSaleChanceById(long id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteSaleChanceById(long id) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageInfo<SalChance> findChanceByUserId(int curPage,String dueto) {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage,5);
		SalChanceExample example = new SalChanceExample();
		example.createCriteria().andChcDueToEqualTo(dueto);
		List<SalChance> salChance = mapper.selectByExample(example);
		PageInfo<SalChance> salInfo = new PageInfo<SalChance>(salChance);
		return salInfo;
		 
	}

	@Override
	public PageInfo<SalChance> findChanceByUserNameAndRegion(int curPage, int size, String dueTo, String region) {
		// TODO Auto-generated method stub
		PageHelper.startPage(curPage,5);
		SalChanceExample example = new SalChanceExample();
		example.createCriteria().andChcDueToEqualTo(dueTo).andChcAddrEqualTo(region);
		List<SalChance> salChance = mapper.selectByExample(example);
		PageInfo<SalChance> salInfo = new PageInfo<SalChance>(salChance);
		return salInfo;
	}

	@Override
	public SalChanceExtend findChanceWithPlanById(long id) {
		// TODO Auto-generated method stub
		SalChanceExtend chance = chanceExtendMapper.selectChanceWithPlanById(id);
		System.out.println("chance属性值为:"+chance.getPlans());
		return chance;
	}

}
