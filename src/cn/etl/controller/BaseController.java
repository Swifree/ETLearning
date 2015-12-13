package cn.etl.controller;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import cn.etl.dao.BaseDao;

public  class BaseController<T>{
	private Class<T> entityClass;
	public BaseController(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext(); 
		//加载对应的Dao实现类的bean @Resource的name必须是常量所以不能使用@Resource注解注入
		baseDao=(BaseDao<T>) wac.getBean(firstLetterToLowerCase(entityClass.getSimpleName())+"DaoImpl");
		
	}
	public Class<T> getEntityClass() {
		return entityClass;
	}
	 //把类名的首字母变为小写，因为我的标识符使用小驼峰法，类命名使用大驼峰法
	private String firstLetterToLowerCase(String s) 
	{
		char[] charArray=s.toCharArray();
		if(charArray[0]<97) charArray[0]+='a'-'A';
		return String.valueOf(charArray);
	}
	
	
	 
	private BaseDao<T> baseDao;
	
	//列出所有记录 ,返回页面
	@RequestMapping("/list")
	public ModelAndView list(String view){
		List<T> list=baseDao.loadAll();
		ModelAndView mav=new ModelAndView(view);
		mav.addObject("list", list);
		return mav;
	}
	
	//列出所有记录 ,返回json串
	@RequestMapping("/listRJson")
	public @ResponseBody List<T> listByJson()
	{
		List<T> list=baseDao.loadAll();
		return list;
	}
	@RequestMapping("/add")
	public ModelAndView add(T entity,String view)
	{
		String msg="添加成功";
		if(!baseDao.save(entity))
			msg="添加失败";
		ModelAndView mav=new ModelAndView(view);
		mav.addObject("msg",msg);
		return mav;
	}
	@RequestMapping("/addRMsg")
	public void addRMsg(T entity,HttpServletResponse res) throws IOException
	{
		String msg="添加成功";
		if(!baseDao.save(entity))
			msg="添加失败";
		res.getWriter().println(msg);
	}
	@RequestMapping("/delete")
	public ModelAndView delete(Serializable[] ids,String view)
	{
		if(ids!=null)
			for(Serializable id:ids)
				baseDao.remove(id);
		ModelAndView mav=new ModelAndView(view);
		return mav;
	}
	
	
	
}