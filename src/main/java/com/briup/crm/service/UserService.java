package com.briup.crm.service;

import com.briup.crm.bean.SysUser;

/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月2日 上午9:44:33 
*  
*/
public interface UserService {

	SysUser login(String username, String password) throws Exception;

}
