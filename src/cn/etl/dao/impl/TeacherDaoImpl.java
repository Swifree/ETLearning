package cn.etl.dao.impl;

import org.springframework.stereotype.Repository;

import cn.etl.dao.TeacherDao;
import cn.etl.entity.Teacher;
@Repository("teacherDaoImpl")
public class TeacherDaoImpl extends BaseDaoImpl<Teacher> implements TeacherDao{

}
