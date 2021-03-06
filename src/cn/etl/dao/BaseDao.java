package cn.etl.dao;

import java.io.Serializable;
import java.util.List;

import cn.etl.util.PageBean;


public interface BaseDao<T> {

	public abstract T load(Serializable id);

	public abstract List<T> loadAll();

	public abstract boolean save(T entity);

	public abstract boolean remove(T entity);
	public abstract boolean remove(Serializable id);
	public abstract boolean update(T entity);

	public abstract List<T> find(String hql);

	public abstract List<T> find(String hql, Object... params);
	public abstract Class<T> getEntityClass();
	public abstract int getCount(String hql);
	PageBean<T> getPage(int pageIndex);
    PageBean<T> getPage(String hql,int pageIndex);
	public abstract PageBean<T> getPage(int pageIndex,int pageSize);
    public abstract PageBean<T> getPage(final String hql,int pageIndex,int pageSize);
    
	public abstract T get(Serializable id);
	public boolean saveOrUpdate(T entity);
	
}