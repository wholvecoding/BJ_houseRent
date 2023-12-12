package controller;

import javax.servlet.http.HttpSession;

import Pojo.Userlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Pojo.User;
import service.UserService;
import service.UserlistService;

@Controller

public class UserController {

	@Autowired
	private UserService userService;



	@RequestMapping("/login")
	public String userList() throws Exception{
		
		
		return "admin/login1";
		
	}
	@RequestMapping("/logincheck")
	public String login(User user,Model model,HttpSession httpSession) throws Exception{
		
		User user1=userService.login(user);			//调用接口中的函数
		
		if(user1!=null){			//当数据库里面存在这个用户的时候
			httpSession.setAttribute("user", user1);
			if(user1.getType().equals("zuke")){		//根据不同的属性从而跳转到不同的页面
				return "zuke/main";
			}
			else{
				return "admin/main1";
			}
		}else{
			String error="error";
			model.addAttribute("error", error);
		return "admin/login1";
		}
	}

	@RequestMapping("/toindex")
	public String toindex(Model model,User user) throws Exception{
		User user1=userService.login(user);			//调用接口中的函数

		if(user1.getType().equals("zuke")){		//根据不同的属性从而跳转到不同的页面
			//model.addAttribute("mainPage", "index.jsp");
			return "zuke/main";
		}
		else{
			//model.addAttribute("mainPage", "index.jsp");
			return "admin/main1";
		}

		}


	@RequestMapping("/toregister")
	public String toRegister(){
	return "register";
	}

	@Autowired
	private UserlistService userlistService;
	@RequestMapping("/registration")
	public String Registration(Model model, HttpSession httpSession, User user,Userlist userlist) throws Exception {
		User user2=userService.login(user);


		//model.addAttribute(samecount);
		if (user2!=null) {		//当前有重复的名字
			String error="error";
			model.addAttribute("error",error);
			return "register";


		}

		else {		//没有名字重复了

			userService.registration(user);         //插入信息
			User insertuser=userService.selectByUser(user);



			int userid=insertuser.getId();
			userlist.setUser_id(userid);
			userlistService.insertuserlist(userlist);
			return "admin/login1";
		}

		}


}


