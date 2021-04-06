package com.controller;

import com.entity.Product;
import com.entity.Sort;
import com.service.ProductService;
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
public class ProductController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	ProductService productService;
	@Autowired
	SortService sortService;
	@Autowired
	HttpServletRequest request;

	//列表管理页面
	@RequestMapping("productlist")
	public String listProduct(Model model) {
		String w="";

		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		if (!"".equals(request.getParameter("number")) && request.getParameter("number") !=null)
			w=w+ " and number like '%"+request.getParameter("number")+"%'";

		if (!"".equals(request.getParameter("sort")) && request.getParameter("sort") !=null)
			w=w+ " and sort  = '"+request.getParameter("sort")+"'";

		if (!"".equals(request.getParameter("price")) && request.getParameter("price") !=null)
			w=w+ " and price like '%"+request.getParameter("price")+"%'";

		if (!"".equals(request.getParameter("nums")) && request.getParameter("nums") !=null)
			w=w+ " and nums like '%"+request.getParameter("nums")+"%'";

		List<Product> cs= productService.list(w);

		for(int i=0;i<cs.size();i++) {
			Product product=(Product)cs.get(i);
		}

		List<Sort> sort= sortService.list("");
		// 放入转发参数
		model.addAttribute("sort", sort);

		int index=0;

		if(request.getParameter("index")==null) {
			index=1;
		} else {
			index=Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<Product> cs1 = cs.subList(fromIndex, toIndex);

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
		return "pages/product/productlist";
	}

	@RequestMapping("productadd")
	public String addproduct(Model model) {
		List<Sort> sort= sortService.list("");
		// 放入转发参数
		model.addAttribute("sort", sort);
		return "pages/product/productadd";
	}

	//添加数据
	@RequestMapping("productinsert")
	public String insertProduct(Product product,Model model) {
		String forword=request.getParameter("forword");
		productService.insert(product);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//删除数据
	@RequestMapping("productdel")
	public String deleteProduct(Product product,Model model) {
		String forword=request.getParameter("forword");
		productService.delete(product);
		model.addAttribute("msg","删除成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//提取要修改的数据
	@RequestMapping("productedit")
	public String editProduct(Model model,Product product) {
		Product c= productService.get(product.getId());
		List<Sort> sort= sortService.list("");
		// 放入转发参数
		model.addAttribute("sort", sort);
		model.addAttribute("c", c);
		return "pages/product/productedit";
	}

	//修改的数据
	@RequestMapping("productupdate")
	public String updateProduct(Product product,Model model) {
		String forword=request.getParameter("forword");
		productService.update(product);
		model.addAttribute("msg","操作成功");
		model.addAttribute("path",forword);
		return "success";
	}

	//所有列表页
	@RequestMapping("productAll")
	public String listProductAll(Model model) {
		String w="";

		if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
			w=w+ " and name like '%"+request.getParameter("name")+"%'";

		if (!"".equals(request.getParameter("number")) && request.getParameter("number") !=null)
			w=w+ " and number like '%"+request.getParameter("number")+"%'";

		if (!"".equals(request.getParameter("sort")) && request.getParameter("sort") !=null)
			w=w+ " and sort  = '"+request.getParameter("sort")+"'";

		if (!"".equals(request.getParameter("price")) && request.getParameter("price") !=null)
			w=w+ " and price like '%"+request.getParameter("price")+"%'";

		if (!"".equals(request.getParameter("nums")) && request.getParameter("nums") !=null)
			w=w+ " and nums like '%"+request.getParameter("nums")+"%'";

		List<Product> cs= productService.list(w);

		for(int i=0;i<cs.size();i++) {
			Product product=(Product)cs.get(i);
		}

		List<Sort> sort= sortService.list("");
		// 放入转发参数
		model.addAttribute("sort", sort);

		int index=0;

		if(request.getParameter("index")==null) {
			index=1;
		} else {
			index=Integer.parseInt(request.getParameter("index"));
		}

		int fromIndex = (index - 1) * Pagesize.size;
		int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		List<Product> cs1 = cs.subList(fromIndex, toIndex);

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
		return "pages/product/productAll";
	}
}