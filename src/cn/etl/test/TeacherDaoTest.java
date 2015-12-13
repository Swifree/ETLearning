package cn.etl.test;

import javax.annotation.Resource;




import org.junit.Test;

import cn.etl.dao.TeacherDao;
import cn.etl.entity.Teacher;

public class TeacherDaoTest extends JUnitDaoBase{
	@Resource(name="teacherDaoImpl") 
    private TeacherDao teacherDao; 
	@Test
    public void updateTest()
    {
    	Teacher t=teacherDao.load(1);
    	System.out.println(t.getPassword());
    	t.setPassword("1");
    	teacherDao.update(t);
    }
}
