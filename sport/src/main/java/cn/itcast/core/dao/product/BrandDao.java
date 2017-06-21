package cn.itcast.core.dao.product;

import java.util.List;

import cn.itcast.core.bean.project.Brand;

/**
 * 品牌
 * @author fangyue
 *
 */
public interface BrandDao {
	//List集合
	public List<Brand> getBrandListWithPage(Brand brand);
	
	//查询总记录数
	public int getBrandCount(Brand brand);
	
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
