package com.controller;

import com.entity.ReturnGoods;
import com.entity.Sort;
import com.entity.Store;
import com.service.ReturnGoodsService;
import com.service.SortService;
import com.service.StoreService;
import com.util.Pagesize;
import com.util.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class ReturnGoodsController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	ReturnGoodsService returnGoodsService;
	@Autowired
	SortService sortService;
	@Autowired
	StoreService storeService;
	@Autowired
	HttpServletRequest request;

	//个人列表页
	@RequestMapping("returngoodsmy")
	public String listReturnGoodsMy(Model model) {
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";

		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		if (!"".equals(request.getParameter("sort")) && request.getParameter("sort") !=null)
			w=w+ " and sort  = '"+request.getParameter("sort")+"'";

		if (!"".equals(request.getParameter("store")) && request.getParameter("store") !=null)
			w=w+ " and store  = "+request.getParameter("store")+"";

		if (!"".equals(request.getParameter("nums")) && request.getParameter("nums") !=null)
			w=w+ " and nums like '%"+request.getParameter("nums")+"%'";

		if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
			w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

		if (!"".equals(request.getParameter("state")) && request.getParameter("state") !=null)
			w=w+ " and state like '%"+request.getParameter("state")+"%'";

		List<ReturnGoods> cs= returnGoodsService.list(w);

		for(int i=0;i<cs.size();i++) {
			ReturnGoods returnGoods =(ReturnGoods)cs.get(i);
			returnGoods.setStorefk(storeService.get(returnGoods.getStore()));
		}

		List<Sort> sort = sortService.list("");
		// 放入转发参数
		model.addAttribute("sort", sort);
		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);
		int index = 0;

		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<ReturnGoods> cs1 = cs.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//创建 分页对象
		p.setIndex(index);//设置页数
		p.setPageSize(Pagesize.size);
		p.setTotle(cs.size());//设置总共的条数
		p.setData(cs1);//设置数据

		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);
		return "pages/returngoods/returngoodsmy";
	}

	//列表管理页面
	@RequestMapping("returngoodslist")
	public String listReturnGoods(Model model) {
		String w="";

		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		if (!"".equals(request.getParameter("sort")) && request.getParameter("sort") !=null)
			w=w+ " and sort  = '"+request.getParameter("sort")+"'";

		if (!"".equals(request.getParameter("store")) && request.getParameter("store") !=null)
			w=w+ " and store  = "+request.getParameter("store")+"";

		if (!"".equals(request.getParameter("nums")) && request.getParameter("nums") !=null)
			w=w+ " and nums like '%"+request.getParameter("nums")+"%'";

		if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
			w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

		if (!"".equals(request.getParameter("state")) && request.getParameter("state") !=null)
			w=w+ " and state like '%"+request.getParameter("state")+"%'";

		List<ReturnGoods> cs= returnGoodsService.list(w);

		for(int i=0;i<cs.size();i++) {
			ReturnGoods returnGoods =(ReturnGoods)cs.get(i);
			returnGoods.setStorefk(storeService.get(returnGoods.getStore()));
		}

		List<Sort> sort = sortService.list("");
		// 放入转发参数
		model.addAttribute("sort", sort);
		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);

		int index = 0;

		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<ReturnGoods> cs1 = cs.subList(fromIndex, toIndex);

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

		return "pages/returngoods/returngoodslist";
	}

	@RequestMapping("returngoodsadd")
	public String addreturnGoods(Model model) {
	List<Sort> sort = sortService.list("");
		// 放入转发参数
		model.addAttribute("sort", sort);
		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);
		return "pages/returngoods/returngoodsadd";
	}

	//添加数据
	@RequestMapping("returngoodsinsert")
	public String insertReturnGoods(ReturnGoods returnGoods, Model model) {
		String forword=request.getParameter("forword");
		returnGoodsService.insert(returnGoods);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//删除数据
	@RequestMapping("returngoodsdel")
	public String deleteReturnGoods(ReturnGoods returnGoods, Model model) {
		String forword=request.getParameter("forword");
		returnGoodsService.delete(returnGoods);
		model.addAttribute("msg","删除成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//提取要修改的数据
	@RequestMapping("returngoodsedit")
	public String editReturnGoods(Model model, ReturnGoods returnGoods) {
		ReturnGoods c= returnGoodsService.get(returnGoods.getId());
		List<Sort> sort = sortService.list("");
		// 放入转发参数
		model.addAttribute("sort", sort);
		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);

		model.addAttribute("c", c);
		return "pages/returngoods/returngoodsedit";
	}

	//修改的数据
	@RequestMapping("returngoodsupdate")
	public String updateReturnGoods(ReturnGoods returnGoods, Model model) {
		String forword=request.getParameter("forword");
		returnGoodsService.update(returnGoods);
		model.addAttribute("msg","操作成功");
 		model.addAttribute("path",forword);
		return "success";
	}

	//所有列表页
	@RequestMapping("returngoodsAll")
	public String listReturnGoodsAll(Model model) {
		String w="";

		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		if (!"".equals(request.getParameter("sort")) && request.getParameter("sort") !=null)
			w=w+ " and sort  = '"+request.getParameter("sort")+"'";

		if (!"".equals(request.getParameter("store")) && request.getParameter("store") !=null)
			w=w+ " and store  = "+request.getParameter("store")+"";

		if (!"".equals(request.getParameter("nums")) && request.getParameter("nums") !=null)
			w=w+ " and nums like '%"+request.getParameter("nums")+"%'";

		if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
			w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

		if (!"".equals(request.getParameter("state")) && request.getParameter("state") !=null)
			w=w+ " and state like '%"+request.getParameter("state")+"%'";

		List<ReturnGoods> cs= returnGoodsService.list(w);

		for(int i=0;i<cs.size();i++) {
			ReturnGoods returnGoods =(ReturnGoods)cs.get(i);
			returnGoods.setStorefk(storeService.get(returnGoods.getStore()));
		}

		List<Sort> sort = sortService.list("");
		// 放入转发参数
		model.addAttribute("sore", sort);
		List<Store> store = storeService.list("");
		// 放入转发参数
		model.addAttribute("store", store);

		int index = 0;

		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<ReturnGoods> cs1 = cs.subList(fromIndex, toIndex);

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
		return "pages/returngoods/returngoodsAll";
	}
}