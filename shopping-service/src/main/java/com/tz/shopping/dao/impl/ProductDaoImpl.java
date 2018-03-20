package com.tz.shopping.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tz.shopping.dao.ProductDao;
import com.tz.shopping.entity.Product;

/**
 * 商品的Dao实现类
 * @author YT
 *
 */
@Repository("productDao")
@Transactional
public class ProductDaoImpl  extends BaseDaoImpl<Product> implements ProductDao{
	
	final String selecthql = "select p.pid,p.image,p.isHot,"
            + "p.marketPrice,p.pdate,p.pdesc,p.pname,p.shopPrice ";

	@Override
	public Integer countProduct() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product";
        return count(hql);
	}

	@Override
	public List<Product> findAll(Integer page) {
		// TODO Auto-generated method stub
		String hql = "from Product";
        int rows = 6;
        int page1 = page;
        return find(hql, page1, rows);
	}

	@Override
	public List<Product> findHot() {
		// TODO Auto-generated method stub
		String hql = "from Product p where p.isHot = 1 ";
        hql += "order by p.pdate desc";
        int rows = 10;
        return find(hql, 1, rows);
	}

	@Override
	public List<Product> findNew() {
		// TODO Auto-generated method stub
		String hql = "from Product p ";
        hql += "order by p.pdate desc";
        int rows = 10;
        return find(hql, 1, rows);
	}

	@Override
	public List<Product> findByCategoryId(Integer cid, Integer page) {
		// TODO Auto-generated method stub
		String hql = selecthql + " from Product p, Categorys c, CategorySecond cs ";
		hql += " where p.categorySecond.csId=cs.csId and cs.category.cid=c.cid and c.cid= ?";
		return Query(cid, page, hql);
	}
	
	private List<Product> Query(Integer csid, Integer page, String hql){
		int rows = 12;
		Query query = this.getCurrentSession().createQuery(hql);
		query.setParameter(0, csid);
		List list = query.setFirstResult((page - 1)* rows).setMaxResults(rows).list();
		List<Product> products = new ArrayList<Product>();
		Iterator iter = list.iterator();
        while (iter.hasNext()) {
            Object[] obj = (Object[]) iter.next();
            Product product = new Product();
            int pid = (Integer) obj[0];
            product.setPid(pid);
            product.setImage((String) obj[1]);
            product.setIsHot((Integer) obj[2]);
            product.setMarketPrice((Float) obj[3]);
            product.setPdate((Date) obj[4]);
            product.setPdesc((String) obj[5]);
            product.setPname((String) obj[6]);
            product.setShopPrice((Float) obj[7]);

            products.add(product);
        }
		return products;
	}

	@Override
	public Integer CountPageProductFromCategory(Integer cid) {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Product p, Categorys c, CategorySecond cs ";
        hql += "where p.categorySecond.csId = cs.csId and cs.category.cid = c.cid and c.cid = ?";
        return count(hql, cid);
	}

}
