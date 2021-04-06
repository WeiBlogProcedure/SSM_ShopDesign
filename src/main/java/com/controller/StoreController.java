package com.controller;

import com.entity.Store;
import com.service.StoreService;
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
public class StoreController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	StoreService storeService;
	@Autowired
	HttpServletRequest request;
	
	//列表管理页面
	@RequestMapping("storelist")
	public String listStore(Model model) { 
		String w="";
		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null) 
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		if (!"".equals(request.getParameter("address")) && request.getParameter("address") !=null)
			w=w+ " and address like '%"+request.getParameter("address")+"%'";

		if (!"".equals(request.getParameter("telephone")) && request.getParameter("telephone") !=null)
			w=w+ " and telephone like '%"+request.getParameter("telephone")+"%'";

		if (!"".equals(request.getParameter("tname")) && request.getParameter("tname") !=null)
			w=w+ " and tname like '%"+request.getParameter("tname")+"%'";

		List<Store> cs = storeService.list(w);

		for(int i = 0;i < cs.size();i++) {
			Store store =(Store)cs.get(i); 
		}
		
		int index = 0;

		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<Store> cs1 = cs.subList(fromIndex, toIndex);

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
		
		return "pages/store/storelist";
	}

	@RequestMapping("storeadd")
	public String addstore(Model model) {
		return "pages/store/storeadd";
	}

	//添加数据
	@RequestMapping("storeinsert")
	public String insertStore(Store store, Model model) {
		String forword=request.getParameter("forword");
		storeService.insert(store);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//删除数据
	@RequestMapping("storedel")
	public String deleteStore(Store store, Model model) {
		String forword = request.getParameter("forword");
		storeService.delete(store);
		model.addAttribute("msg","删除成功");
 		model.addAttribute("path",forword);
		return "success";
	}

	//提取要修改的数据
	@RequestMapping("storeedit")
	public String editStore(Model model, Store store) {
		Store c= storeService.get(store.getId());
		model.addAttribute("c", c);
		return "pages/store/storeedit";
	}

	//修改的数据
	@RequestMapping("storeupdate")
	public String updateStore(Store store, Model model) {
		String forword=request.getParameter("forword");
		storeService.update(store);
		model.addAttribute("msg","操作成功");
 		model.addAttribute("path",forword);
		return "success";
	}

	//所有列表页
	@RequestMapping("storeAll")
	public String listStoreAll(Model model) {
		String w="";

		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		if (!"".equals(request.getParameter("address")) && request.getParameter("address") !=null)
			w=w+ " and address like '%"+request.getParameter("address")+"%'";

		if (!"".equals(request.getParameter("telephone")) && request.getParameter("telephone") !=null)
			w=w+ " and telephone like '%"+request.getParameter("telephone")+"%'";

		if (!"".equals(request.getParameter("tname")) && request.getParameter("tname") !=null)
			w=w+ " and tname like '%"+request.getParameter("tname")+"%'";

		List<Store> cs= storeService.list(w);

		for(int i=0;i<cs.size();i++) {
			Store store =(Store)cs.get(i);
		}
		int index=0;

		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<Store> cs1 = cs.subList(fromIndex, toIndex);

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
		return "pages/store/storeAll";
	}
}