package com.briup.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.crm.bean.SysUser;
import com.briup.crm.bean.SysUserExample;
import com.briup.crm.dao.SysUserMapper;
import com.briup.crm.service.UserService;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月2日 上午9:44:50 
*  
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private SysUserMapper mapper;
	
	@Override
	public SysUser login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		SysUserExample example = new SysUserExample();
		example.createCriteria().andUsrNameEqualTo(username);
		List<SysUser> user = mapper.selectByExample(example);
		SysUser u = new SysUser();
		if(user.size()>0){
			  u = user.get(0);
			  if(u.getUsrPassword().equals(password)){
					return u;
				}else{
					throw new Exception("密码错误!");
				}
		}else{
			throw new Exception("用户名不存在的亲");
		}
		
		 
	}

}
