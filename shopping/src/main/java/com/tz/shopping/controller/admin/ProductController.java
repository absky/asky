package com.tz.shopping.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tz.common.utils.StringTools;
import com.tz.shopping.entity.CategorySecond;
import com.tz.shopping.entity.Product;
import com.tz.shopping.service.CategorySecondService;
import com.tz.shopping.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategorySecondService categorySecondService;
	
	/**
	 * 分页显示商品
	 * @return
	 */
	@RequestMapping(value="/listProduct/{page}")
	public String listProduct(@PathVariable("page") Integer page, Map<String, Object> map){
		//分页查询商品
		List<Product> productPage = productService.listProduct(page);
		//商品的页数
		Integer totalPage = productService.countProductPage();
		
		map.put("products", productPage);
		map.put("curPage", page);
		map.put("totalPage", totalPage);
		return "admin/product/list";
	}
	
	/**
	 * 跳转到添加商品的页面 
	 */
	@RequestMapping(value="/gotoAddProduct")
	public ModelAndView gotoAddProduct(){
		ModelAndView mv = new ModelAndView("admin/product/add");
		//查询所有二级分类的集合
		List<CategorySecond> categotySeconds = categorySecondService.listCategorySecond();
		mv.addObject("categotySeconds", categotySeconds);
		return mv;
	}
	
	/**
	 * 上传，新增商品
	 */
	@RequestMapping(value="/addProduct", method=RequestMethod.POST)
	public ModelAndView addProduct(Product product, 
			@RequestParam("upload") MultipartFile upload, Integer csid, HttpServletRequest request){
		//获取文件的保存路径
		ServletContext servletContext = request.getSession().getServletContext();
		String path = servletContext.getRealPath("/product/3");
		//获取上传文件的名称
		String fileName = upload.getOriginalFilename();
		System.out.println("====" + fileName);
		//得到上传文件的扩展名
		String suffix = fileName.substring(fileName.lastIndexOf("."));
		//为了防止上传同名文件，需要给上传文件重新命名
		String tempFileName = StringTools.getUUID().toString() + suffix;
		
		try {
			FileUtils.writeByteArrayToFile(new File(path, tempFileName), upload.getBytes() );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//设置文件的路径
		product.setImage("product/3/" + tempFileName);
		
		product.setPdate(new Date());
	//二级类目
		CategorySecond categorySecond = categorySecondService.findCategorySecond(csid);
		product.setCategorySecond(categorySecond);
		
		//保存商品
		productService.saveProduct(product);
		
		ModelAndView mv = new ModelAndView("redirect:/listProduct/1");
		return mv;
	}
	
	/**
	 * 跳 转到修改商品
	 */
	@RequestMapping(value="/gotoEditProduct/{pid}")
	public String editProduct(@PathVariable("pid") Integer pid, Map<String, Object> map){
		Product product = productService.getProduct(pid);
		
		List<CategorySecond> categotySeconds = categorySecondService.listCategorySecond();
		for(CategorySecond cs : categotySeconds){
			System.out.println("==" + cs.getCsName());
		}
		
		map.put("categorySeconds", categotySeconds);
		map.put("product", product);
		return "admin/product/edit";
	}
	
	/**
	 * 修改商品
	 */
	@RequestMapping(value="/updateProduct", method=RequestMethod.POST)
	public ModelAndView updateProduct(Product product, 
			@RequestParam("upload") MultipartFile upload, Integer csid, HttpServletRequest request){
		//获取文件的保存路径
		ServletContext servletContext = request.getSession().getServletContext();
		
		//获取上传文件的名称
		String fileName = upload.getOriginalFilename();
		System.out.println("====" + fileName);

		//查询旧的商品
		Product op = productService.getProduct(product.getPid());
		
		//获取本来的文件的名称  product/3/9dcb000b04cd4ae0ad3d64a42707a7b1.jpg
		String oldFileName = "";
		if("".equals(op.getImage())){
			int begin = op.getImage().lastIndexOf("/");
			oldFileName = op.getImage().substring(begin+1, op.getImage().length());
		}
		
		if( !"".equals(fileName) && fileName != oldFileName){
			String path = servletContext.getRealPath("/product/3");
			
			//得到上传文件的扩展名
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			//为了防止上传同名文件，需要给上传文件重新命名
			String tempFileName = StringTools.getUUID().toString() + suffix;
			
			try {
				FileUtils.writeByteArrayToFile(new File(path, tempFileName), upload.getBytes() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//设置文件的路径
			product.setImage("product/3/" + tempFileName);
			
			product.setPdate(new Date());
		}else{
			product.setImage(op.getImage());
			product.setPdate(new Date());
		}
	//二级类目
		CategorySecond categorySecond = categorySecondService.findCategorySecond(csid);
		product.setCategorySecond(categorySecond);
		
		//保存商品
		productService.updateProduct(product);
		
		ModelAndView mv = new ModelAndView("redirect:/listProduct/1");
		return mv;
	}
	
	
	/**
	 * 删除商品
	 */
	@RequestMapping(value="/deleteProduct/{pid}/{page}")
	public ModelAndView deleteProduct(@PathVariable("pid") Integer pid,
			@PathVariable("page") Integer page, HttpServletRequest request){
		// 获取商品对象
		Product product = productService.getProduct(pid);
		
		//获取文件的目录
		String path = request.getSession().getServletContext().getRealPath("/" + product.getImage());
		
		File file = new File(path);
		file.delete();
		
		productService.deleteProduct(product);

		ModelAndView mv = new ModelAndView("redirect:/listProduct/" + page);
		return mv;
	}
	
	

}
