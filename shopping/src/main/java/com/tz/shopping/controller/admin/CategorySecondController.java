package com.tz.shopping.controller.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tz.shopping.entity.CategorySecond;
import com.tz.shopping.entity.Categorys;
import com.tz.shopping.service.CategorySecondService;
import com.tz.shopping.service.CategorysService;

/**
 * 商品二级类目管理 restful风格
 * 
 * @author YT
 *
 */
@Controller
public class CategorySecondController {

	@Autowired
	private CategorySecondService categorySecondService;

	@Autowired
	private CategorysService categorysService;

	/**
	 * 二级类目列表
	 * 
	 */
	@RequestMapping(value = "/listCategorySecond/{page}", method = RequestMethod.GET)
	public String listCategorySecond(@PathVariable("page") Integer page, Map<String, Object> map) {
		List<CategorySecond> categorySeconds = categorySecondService.listCategorySecond(page);
		for(CategorySecond cs : categorySeconds){
        	System.out.println("====" + cs.getCsName());
        }
		
		int totalPage = categorySecondService.countCategoryPage();
		map.put("categorySeconds", categorySeconds);
		map.put("curPage", page);
		map.put("totalPage", totalPage);
		return "admin/categorysecond/list";
	}

	/**
	 * 跳转到添加二级分类的界面
	 */
	@RequestMapping(value = "/gotoAddCategorySecond")
	public String gotoAddCategorySecond(Map<String, Object> map) {
		List<Categorys> categorys = categorysService.findAll();
		for(Categorys cs : categorys){
        	System.out.println("====" + cs.getCname());
        }
		map.put("categorys", categorys);
		return "admin/categorysecond/add";
	}
	
	/**
	 * 添加二级分类
	 */
	@RequestMapping(value = "/addCategorySecond", method = RequestMethod.POST)
    public ModelAndView addCategorySecond(@RequestParam("csname") String csname, @RequestParam("cid") Integer cid) {
		
		System.out.println("===" + csname);
		System.out.println("==" + cid);
        //查找一级分类对象
        Categorys category = categorysService.findCategory(cid);
        //创建二级分类对象
        CategorySecond categorySecond = new CategorySecond();
        //设置一级分类和二级分类的关联关系
        categorySecond.setCategory(category);
        categorySecond.setCsName(csname);
        //保存对象
        categorySecondService.addCategorySecond(categorySecond);
        ModelAndView modelAndView = new ModelAndView("redirect:listCategorySecond/1");
        return modelAndView;
    }
	
	/**
	 * 跳转到修改二级分类界面
	 */
	@RequestMapping(value = "/gotoEditCategorySecond/{csid}")
    public String gotoEditCategorySecond(@PathVariable("csid") Integer csid,
                                         Map<String, Object> map) {
        System.out.println("===" + csid);
        //查找对应的二级分类
        CategorySecond categorySecond = categorySecondService.findCategorySecond(csid);
        map.put("categorySecond", categorySecond);
        //查找所有一级分类
        List<Categorys> categorys = categorysService.findAll();
        map.put("categorys", categorys);
        return "admin/categorysecond/edit";
    }
	
	/**
	 * 更新二级分类
	 */
	@RequestMapping(value = "/updateCategorySecond", method = RequestMethod.POST)
    public ModelAndView updateCategorySecond(@RequestParam("csid") Integer csid, @RequestParam("csname") String csname,
                                             @RequestParam("cid") Integer cid) {
        Categorys category = categorysService.findCategory(cid);
        CategorySecond categorySecond = categorySecondService.findCategorySecond(csid);
        categorySecond.setCategory(category);
        categorySecond.setCsName(csname);
        categorySecondService.updateCategorySecond(categorySecond);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategorySecond/1");
        return modelAndView;
    }
	
	/**
	 * 删除二级分类
	 */
	@RequestMapping(value = "/deleteCategorySecond/{csid}/{page}")
    public ModelAndView deleteCategorySecond(@PathVariable("csid") Integer csid, @PathVariable("page") Integer page) {
		categorySecondService.deleteCategorySecond(csid);
        ModelAndView modelAndView = new ModelAndView("redirect:/listCategorySecond/" + page);
        return modelAndView;
    }


}
