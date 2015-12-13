package cn.etl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.etl.dao.AdminDao;
import cn.etl.entity.Admin;
@Repository("adminDaoImpl")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{

}
