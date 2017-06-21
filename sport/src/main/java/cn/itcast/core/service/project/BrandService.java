package cn.itcast.core.service.project;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.project.Brand;

public interface BrandService {

	public Pagination getBrandListWithPage(Brand brand);
	
	//添加品牌
	public void addBrand(Brand brand);
	
	//删除
	public void deleteBrandByKey(Integer id);
	
	//批量删除
	public void deleteBrandByKeys(Integer[] ids);//List<integer> ids
	
	//修改
	public void updateBrandByKey(Brand brand);
	
	//品牌返回一个
	public Brand getBrandByKey(Integer id);
	
}
