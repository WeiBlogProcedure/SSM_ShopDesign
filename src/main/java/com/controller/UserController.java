package com.controller;

import com.entity.Store;
import com.entity.User;
import com.service.StoreService;
import com.service.UserService;
import com.util.Pagesize;
import com.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class UserController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	UserService userService;
	@Autowired
    StoreService storeService;
	@Autowired
	HttpServletRequest request;

	//列表管理页面
	@RequestMapping("userlist")
	public String listUser(Model model) {
		String w="";

		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		if (!"".equals(request.getParameter("position")) && request.getParameter("position") !=null)
			w=w+ " and position like '%"+request.getParameter("position")+"%'";

		if (!"".equals(request.getParameter("store")) && request.getParameter("store") !=null)
			w=w+ " and store  = "+request.getParameter("store")+"";

		if (!"".equals(request.getParameter("telephone")) && request.getParameter("telephone") !=null)
			w=w+ " and telephone like '%"+request.getParameter("telephone")+"%'";

		if (!"".equals(request.getParameter("limits")) && request.getParameter("limits") !=null)
			w=w+ " and limits like '%"+request.getParameter("limits")+"%'";

		List<User> cs= userService.list(w);

		for(int i=0;i<cs.size();i++) {
			User user=(User)cs.get(i);
			user.setStorefk(storeService.get(user.getStore()));
		}

		List<Store> store = storeService.list("");

		// 放入转发参数
		model.addAttribute("store", store);//此处可能出错

		int index = 0;
		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index=Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<User> cs1 = cs.subList(fromIndex, toIndex);
		Pagination p = new Pagination();//创建 分页对象
		p.setIndex(index);//设置页数
		p.setPageSize(Pagesize.size);
		p.setTotle(cs.size());//设置总共的条数
		p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		return "pages/user/userlist";
	}

	@RequestMapping("useradd")
	public String adduser(Model model) {
		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);//此处可能出错
		return "pages/user/useradd";
	}

	//添加数据
	@RequestMapping("userinsert")
	public String insertUser(User user,Model model) {
		String forword=request.getParameter("forword");
		userService.insert(user);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//删除数据
	@RequestMapping("userdel")
	public String deleteUser(User user,Model model) {
		String forword=request.getParameter("forword");
		userService.delete(user);
		model.addAttribute("msg","删除成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//提取要修改的数据
	@RequestMapping("useredit")
	public String editUser(Model model,User user) {
		User c= userService.get(user.getId());
		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);//此处可能出错
		model.addAttribute("c", c);
		return "pages/user/useredit";
	}

	//修改的数据
	@RequestMapping("userupdate")
	public String updateUser(User user,Model model) {
		String forword=request.getParameter("forword");
		userService.update(user);
		model.addAttribute("msg","操作成功");
 		model.addAttribute("path",forword);
		return "success";
	}

	//所有列表页
	@RequestMapping("userAll")
	public String listUserAll(Model model) {
		String w="";
		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w = w + " and name like '%" + request.getParameter("name") + "%'";

		if (!"".equals(request.getParameter("position")) && request.getParameter("position") !=null)
			w = w + " and position like '%" + request.getParameter("position") + "%'";

		if (!"".equals(request.getParameter("store")) && request.getParameter("store") !=null)
			w = w + " and store  = " + request.getParameter("store") + "";

		if (!"".equals(request.getParameter("telephone")) && request.getParameter("telephone") !=null)
			w = w + " and telephone like '%" + request.getParameter("telephone") + "%'";

		if (!"".equals(request.getParameter("limits")) && request.getParameter("limits") !=null)
			w = w + " and limits like '%" + request.getParameter("limits") + "%'";

		List<User> cs= userService.list(w);

		for(int i=0;i<cs.size();i++) {
			User user=(User)cs.get(i);
			user.setStorefk(storeService.get(user.getStore()));
		}

		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);//store

		int index=0;

		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<User> cs1 = cs.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//创建 分页对象
		p.setIndex(index);//设置页数
		p.setPageSize(Pagesize.size);
		p.setTotle(cs.size());//设置总共的条数
		p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		return "pages/user/userAll";
	}

	//注册
	@RequestMapping("userreg")
	public String insertreg(User user,Model model) {
		String forword=request.getParameter("forword");
		String w=" and username='"+request.getParameter("username")+"'";
		List<User> cs= userService.list(w);

		if (cs.size()>0) {
			model.addAttribute("msg","用户名重复!请重试");
			model.addAttribute("path",forword);
		} else {
			userService.insert(user);
			model.addAttribute("msg","成功");
			model.addAttribute("path",forword);
		}
		return "success";
	}

	//修改个人资料
	@RequestMapping("userinfo")
	public String editUserinfo(Model model,User user) {
		User c= userService.get(user.getId());
		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);
		model.addAttribute("c", c);
		return "pages/user/userinfo";
	}

	//保存修改个人资料数据
	@RequestMapping("userinfosave")
	public String Userinfosave(User user,Model model) {
		String forword=request.getParameter("forword");
		userService.update(user);
		model.addAttribute("msg","修改成功");
		model.addAttribute("path",forword);
		return "success";
	}
}