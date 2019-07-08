package com.hezeu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.hezeu.model.Users;
import com.hezeu.service.UserService;
import com.hezeu.util.CaptchaUtil;

/**
 *
 * @ClassName: UserController
 * @Description: 用户控制层，实现用户信息操作
 * @author 四海兴唐-朱进博
 * @date 2019年7月7日	下午11:44:50
 * @version V1.0
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 网站后台加载页面
	 * @return
	 */
	@GetMapping("/toLogin")
	public String toLogin() {
		return "login";
	}

	/**
	 * 网站后台登陆页
	 * @param users
	 * @param session
	 * @return */
	@RequestMapping("/adminLogin")
	@ResponseBody
	public JSONObject adminLogin( Users users , HttpSession session ) {
		// 验证验证码是否正确
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "3");
		String code = (String) session.getAttribute(CaptchaUtil.RANDOMCODEKEY);
		if (!users.getCode().equals(code)) {
			jsonObject.put("msg", "0");
		}
		if (!this.userService.validateLogin(users)) {
			System.out.println("密码错误");
			jsonObject.put("msg", "1");
		}
		System.out.println(jsonObject);
		return jsonObject;

	}

	/**
	 * 后台跳转页面
	 * @return */
	@RequestMapping("/Index")
	public String Index() {
		return "index";
	}
	/**
	 * 判断用户是否存在
	 * @param users
	 * @param request
	 * @return
	 */
	@RequestMapping("/appLogin")
	@ResponseBody
	public String AppLogin( Users users , HttpServletRequest request ) {
		String functionName = request.getParameter("callback");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "3");
		if (!this.userService.validateLogin(users)) {
			System.out.println("密码错误");
			jsonObject.put("msg", "1");
		}
		System.out.println(jsonObject);
		System.out.println(functionName+"("+jsonObject.toString()+")");
		return functionName+"("+jsonObject.toString()+")";
	}
	/**
	 * 加载找回密码页
	 * @return
	 */
	@GetMapping("/toFind")
	public String ToFindPwd(){
		return "findPwd";
	}
	@RequestMapping("/FindPwd")
	public String FindPwd(){
		return null;
	}


}
