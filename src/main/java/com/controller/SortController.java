package com.controller;

import com.entity.Sort;
import com.service.SortService;
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
public class SortController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	SortService sortService;
	@Autowired
	HttpServletRequest request;

	//列表管理页面
	@RequestMapping("sortlist")
	public String listSort(Model model) {
		String w="";
		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Sort> cs= sortService.list(w);

		for(int i=0;i<cs.size();i++) {
			Sort sort =(Sort)cs.get(i);
		}

		int index = 0;

		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<Sort> cs1 = cs.subList(fromIndex, toIndex);

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
		return "pages/sort/sortlist";
	}

	@RequestMapping("sortadd")
	public String addSort(Model model){
		return "pages/sort/sortadd";
	}

	//添加数据
	@RequestMapping("sortinsert")
	public String insertSort(Sort sort, Model model) {
		String forword=request.getParameter("forword");
		sortService.insert(sort);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//删除数据
	@RequestMapping("sortdel")
	public String deleteSort(Sort sort, Model model) {
		String forword=request.getParameter("forword");
		sortService.delete(sort);
		model.addAttribute("msg","删除成功");
 		model.addAttribute("path",forword);
		return "success";
	}

	//提取要修改的数据
	@RequestMapping("sortedit")
	public String editSort(Model model, Sort sort) {
		Sort c= sortService.get(sort.getId());
		model.addAttribute("c", c);
		return "pages/sort/sortedit";
	}

	//修改的数据
	@RequestMapping("sortupdate")
	public String updateSort(Sort sort, Model model) {
		String forword=request.getParameter("forword");
		sortService.update(sort);
		model.addAttribute("msg","操作成功");
 		model.addAttribute("path",forword);
		return "success";
	}

	//所有列表页
	@RequestMapping("sortAll")
	public String listSortAll(Model model) {
		String w="";
		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		List<Sort> cs= sortService.list(w);
		for(int i=0;i<cs.size();i++) {
			Sort sort =(Sort)cs.get(i);
		}

		int index=0;

		if(request.getParameter("index")==null) {
			index = 1;
		} else {
			index = Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<Sort> cs1 = cs.subList(fromIndex, toIndex);

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
		return "pages/sort/sortAll";
	}
}