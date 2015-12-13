package cn.etl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.etl.entity.Teacher;

@Controller
@RequestMapping("/teacher")
public class TeacherController extends BaseController<Teacher>{
	
}
