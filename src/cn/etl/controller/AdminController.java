package cn.etl.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.etl.entity.Admin;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController<Admin>{
	
}
