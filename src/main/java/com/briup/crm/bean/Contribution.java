package com.briup.crm.bean;
/** 
*       Title:
* Description:
* @author 作者 xuben 
* @version 创建时间：2020年1月9日 下午2:13:34 
*  
*/
public class Contribution {

	private String name;
	
	private float y;

	public Contribution(String name, float y) {
		super();
		this.name = name;
		this.y = y;
	}

	public Contribution() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Contribution [name=" + name + ", y=" + y + "]";
	}
	
	
}
