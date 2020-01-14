package com.briup.crm.service.impl;

import java.awt.geom.FlatteningPathIterator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.CstCustomer;
import com.briup.crm.bean.CstCustomerExample;
import com.briup.crm.bean.SysUser;
import com.briup.crm.bean.SysUserExample;
import com.briup.crm.dao.CstCustomerMapper;
import com.briup.crm.dao.SysUserMapper;
import com.briup.crm.service.CustomerService;
import com.briup.crm.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月2日 上午9:44:50 
*  
*/
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CstCustomerMapper mapper;

	@Override
	public List<CstCustomer> findAllCustomer() {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> customers = mapper.selectByExample(example);
		return customers;
	}

	//分页显示所有用户信息
	@Override
	public PageInfo<CstCustomer> findAllCustomerByPage(int curPage, int size) {
		// TODO Auto-generated method stub
		//设置当前是哪一页，以及每页显示几条数据
		PageHelper.startPage(curPage,size);
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> customers = mapper.selectByExample(example);
		PageInfo<CstCustomer> customerInfo = new PageInfo<CstCustomer>(customers);
		 
		return customerInfo;
	}

	@Override
	public CstCustomer findCustomerById(long id) {
		// TODO Auto-generated method stub
		CstCustomer customer = mapper.selectByPrimaryKey(id);
		return customer;
	}

	@Override
	public void saveOrUpdateCustomer(CstCustomer customer) {
		// TODO Auto-generated method stub
		//判断id是否为空,如果为空则是保存操作,否则是更新操作
		
		if(customer.getCustId() == null){
			mapper.insertSelective(customer);
		}else{
			mapper.updateByPrimaryKey(customer);
		}
	 
	}

	@Override
	public void deleteCustomerById(long id) {
		// TODO Auto-generated method stub
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void updateCustomer(CstCustomer customer) {
		// TODO Auto-generated method stub
		mapper.updateByPrimaryKeySelective(customer);
		
	}

	@Override
	public PageInfo<CstCustomer> findCustomerLike(int curPage, int size, CstCustomer customer) {
		// TODO Auto-generated method stub
		//设置当前是哪一页，以及每页显示几条数据
		PageHelper.startPage(curPage,size);
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustNameLike("%"+customer.getCustName() +"%")
		.andCustRegionLike("%"+customer.getCustRegion()+"%")
		.andCustLevelLabelLike("%"+customer.getCustLevelLabel()+"%");
		List<CstCustomer> customers = mapper.selectByExample(example);
		PageInfo<CstCustomer> customerInfo =
				new PageInfo<CstCustomer>(customers);
		 
		return customerInfo;
	}

	
	public float getRegionTotal(String region){
		float sum = 0;
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustRegionEqualTo(region);
		List<CstCustomer> custList = mapper.selectByExample(example);
		for (CstCustomer cstCustomer : custList) {
			sum+= cstCustomer.getCustTurnover();
		}
		return sum;
	}
	
	public float getTotal(){
	    float total =0 ;
		CstCustomerExample example = new CstCustomerExample();
		List<CstCustomer> custList = mapper.selectByExample(example);
		for (CstCustomer cstCustomer : custList) {
			total += cstCustomer.getCustTurnover();
		}
		return total;
	}
	
	//获得每个区域的百分比
	@Override
	public float getRegionPercent(String region) {
		// TODO Auto-generated method stub
		float percent = getRegionTotal(region)/getTotal();
		return percent;
	}

	@Override
	public int getCustByLevel(String level) {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustLevelLabelEqualTo(level);
		List<CstCustomer> custlist = mapper.selectByExample(example);
		return custlist.size();
	}

	@Override
	public int getCustByCredit(int credit) {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustCreditEqualTo(credit);
		List<CstCustomer> custlist = mapper.selectByExample(example);
		return custlist.size();
	}

	@Override
	public int getCustBySatisfy(int satisfy) {
		// TODO Auto-generated method stub
		CstCustomerExample example = new CstCustomerExample();
		example.createCriteria().andCustSatisfyEqualTo(satisfy);
		List<CstCustomer> custlist = mapper.selectByExample(example);
		return custlist.size();
	}

	@Override
	public Set<String> findAllLevel() {
		// TODO Auto-generated method stub
		Set<String> levelSet = new HashSet<String>();
		List<CstCustomer> custlist = findAllCustomer();
		for (CstCustomer cstCustomer : custlist) {
			String level = cstCustomer.getCustLevelLabel();
			levelSet.add(level);
		}
		System.out.println("等级set"+levelSet);
		return levelSet;
	}

	@Override
	public Set<Integer> findAllCredit() {
		// TODO Auto-generated method stub
		Set<Integer> creditSet = new HashSet<Integer>();
		List<CstCustomer> custlist = findAllCustomer();
		for (CstCustomer cstCustomer : custlist) {
			int credit = cstCustomer.getCustCredit();
			creditSet.add(credit);
		}
		System.out.println("信用set"+creditSet);
		return creditSet;
	}

	@Override
	public Set<Integer> findAllSatisfy() {
		// TODO Auto-generated method stub
		Set<Integer> levelSet = new HashSet<Integer>();
		List<CstCustomer> custlist = findAllCustomer();
		for (CstCustomer cstCustomer : custlist) {
			Integer level = cstCustomer.getCustSatisfy();
			levelSet.add(level);
		}
		return levelSet;
	}

 
    
	
	 

}
