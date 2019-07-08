package com.hezeu.model;
/**
 *
 * @ClassName: UserState
 * @Description: Model
 * @author 四海兴唐-朱进博
 * @date 2019年6月17日	下午8:11:17
 * @version V1.0
 */
public class UserState {

	private Integer Id;    //状态Id
	private String StateName;   //状态名

	public Integer getId() {
		return this.Id;
	}
	public void setId( Integer id ) {
		this.Id = id;
	}
	public String getStateName() {
		return this.StateName;
	}
	public void setStateName( String stateName ) {
		this.StateName = stateName;
	}

}
