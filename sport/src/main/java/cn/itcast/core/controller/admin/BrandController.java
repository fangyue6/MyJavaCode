package cn.itcast.core.controller.admin;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.project.Brand;
import cn.itcast.core.service.project.BrandService;

/**
 * 品牌
 * 
 * @author fangyue
 *
 */
@Controller
public class BrandController {

	@Autowired
	private BrandService brandService;

	// 品牌列表页面
	@RequestMapping(value = "/brand/list.do")
	public String list(String name, Integer isDisplay, Integer pageNo,ModelMap model) {
		
		//参数
		StringBuilder params=new StringBuilder();
		
		Brand brand = new Brand();
		// 判断传递来的名称是否为NUll并且还要判断是否为空串
		if (StringUtils.isNotBlank(name)) {
			brand.setName(name);
			params.append("name=").append(name);
		}
		//是  不是
		if(null!=isDisplay){
			brand.setIsDisplay(isDisplay);
			params.append("&isDisplay=").append(isDisplay);
		}else{
			brand.setIsDisplay(1);
			params.append("&isDisplay=").append(1);
		}

		
		
		//页号   //如果页号为空，  或者小于1  置为1
		brand.setPageNo(Pagination.cpn(pageNo));
		
		//每一页数
		brand.setPageSize(5);
		
		//分页对象
		Pagination pagination = brandService.getBrandListWithPage(brand);
		
		//分页展示   /brand/list.do?name=哈他&isDisplay=1&pageNo=2
		pagination.pageView("/brand/list.do", params.toString());
		
		model.addAttribute("pagination", pagination);//request  ,response
		model.addAttribute("isDisplay", isDisplay);//request  ,response
		model.addAttribute("name", name);//request  ,response
		return "brand/list";
	}
	
	//跳转品牌添加页面
	@RequestMapping(value="/brand/toAdd.do")
	public String toAdd(){
		return "/brand/add";
	}
	
	//添加品牌
	@RequestMapping(value="/brand/add.do")
	public String add(Brand brand){
		//添加开始
		brandService.addBrand(brand);
		return "redirect:/brand/list.do";
	}
	
	//删除一个品牌
	@RequestMapping(value="/brand/delete.do")
	public String delete(Integer id,String name,Integer isDisplay,ModelMap model){
		//删除
		brandService.deleteBrandByKey(id);
		
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(null!=isDisplay){
			model.addAttribute("isDisplay", isDisplay);
		}
		
		return "redirect:/brand/list.do";
	}
	//删除多个品牌
	@RequestMapping(value="/brand/deletes.do")
	public String deletes(Integer[] ids,String name,Integer isDisplay,ModelMap model){
		//删除
		brandService.deleteBrandByKeys(ids);
		
		if(StringUtils.isNotBlank(name)){
			model.addAttribute("name", name);
		}
		if(null!=isDisplay){
			model.addAttribute("isDisplay", isDisplay);
		}
		
		return "redirect:/brand/list.do";
	}
	
	//跳转修改页面
	@RequestMapping(value="/brand/toEdit.do")
	public String toEdit(Integer id,ModelMap model){
		Brand brand = brandService.getBrandByKey(id);
		
		model.addAttribute("brand", brand);
		return "brand/edit";
	}
	
	//跳转修改页面
	@RequestMapping(value="/brand/edit.do")
	public String edit(Brand brand,ModelMap model){
		brandService.updateBrandByKey(brand);

		return "redirect:/brand/list.do";
	}

	
}
