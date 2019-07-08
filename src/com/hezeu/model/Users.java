package com.hezeu.model;
/**
 *
 * @ClassName: Users
 * @Description: UsersModel类
 * @author 四海兴唐-朱进博
 * @date 2019年6月17日	下午7:59:47
 * @version V1.0
 */
public class Users {

	private Integer Id;     //Id
	private String User_Account;  //登陆账号
	private String User_Password;  //密码
	private String User_Name;   //姓名
	private Integer User_Age; 	//年龄
	private String User_Phone;   //手机号
	private Integer User_Role;   //角色
	private Integer User_State;  //状态
	private String code;  //验证码

	public String getUser_Email() {
		return this.User_Email;
	}
	public void setUser_Email( String user_Email ) {
		this.User_Email = user_Email;
	}
	private String User_Email; //邮箱
	public String getCode() {
		return this.code;
	}
	public void setCode( String code ) {
		this.code = code;
	}
	public Integer getId() {
		return this.Id;
	}
	public void setId( Integer id ) {
		this.Id = id;
	}
	public String getUser_Account() {
		return this.User_Account;
	}
	public void setUser_Account( String user_Account ) {
		this.User_Account = user_Account;
	}
	public String getUser_Password() {
		return this.User_Password;
	}
	public void setUser_Password( String user_Password ) {
		this.User_Password = user_Password;
	}
	public String getUser_Name() {
		return this.User_Name;
	}
	public void setUser_Name( String user_Name ) {
		this.User_Name = user_Name;
	}
	public Integer getUser_Age() {
		return this.User_Age;
	}
	public void setUser_Age( Integer user_Age ) {
		this.User_Age = user_Age;
	}
	public String getUser_Phone() {
		return this.User_Phone;
	}
	public void setUser_Phone( String user_Phone ) {
		this.User_Phone = user_Phone;
	}
	public Integer getUser_Role() {
		return this.User_Role;
	}
	public void setUser_Role( Integer user_Role ) {
		this.User_Role = user_Role;
	}
	public Integer getUser_State() {
		return this.User_State;
	}
	public void setUser_State( Integer user_State ) {
		this.User_State = user_State;
	}
	@Override
	public String toString() {
		return "Users [Id=" + this.Id + ", User_Account=" + this.User_Account + ", User_Password=" + this.User_Password
				+ ", User_Name=" + this.User_Name + ", User_Age=" + this.User_Age + ", User_Phone=" + this.User_Phone
				+ ", User_Role=" + this.User_Role + ", User_State=" + this.User_State + ", code=" + this.code
				+ ", User_Email=" + this.User_Email + "]";
	}




}
