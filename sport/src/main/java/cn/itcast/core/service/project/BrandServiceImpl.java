package cn.itcast.core.service.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.common.page.Pagination;
import cn.itcast.core.bean.project.Brand;
import cn.itcast.core.dao.product.BrandDao;

/**
 * 品牌事务
 * @author fangyue
 *
 */
@Service
@Transactional  //事务
public class BrandServiceImpl implements BrandService{

	@Resource
	private BrandDao brandDao;
	
	@Transactional(readOnly=true)
	public Pagination getBrandListWithPage(Brand brand){
		//1.起始页  startRow=(pageNo-1)*pageSize
		//2.每页数
		//3.总记录数
		Pagination pagination =new Pagination(brand.getPageNo(),brand.getPageSize(),brandDao.getBrandCount(brand));
		//brand集合
		pagination.setList(brandDao.getBrandListWithPage(brand));
		
		return pagination;
	}

	@Override
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
		
	}

	@Override
	public void deleteBrandByKey(Integer id) {
		brandDao.deleteBrandByKey(id);
		
	}

	@Override
	public void deleteBrandByKeys(Integer[] ids) {
		brandDao.deleteBrandByKeys(ids);
		
	}

	@Override
	public void updateBrandByKey(Brand brand) {
		brandDao.updateBrandByKey(brand);
		
	}

	@Override
	public Brand getBrandByKey(Integer id) {
		return brandDao.getBrandByKey(id);
	}
}
