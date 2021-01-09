package com.tjetc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tjetc.domain.User;

@Controller
public class Mycontroller {
	@RequestMapping("/go")
	public ModelAndView print() {
		ModelAndView mv = new ModelAndView();
		Map<String, String> map = new HashMap<>();
		map.put("uname", "admin");
		map.put("pwd", "123456");
		mv.addAllObjects(map);
		// mv.addObject("msg", "我来自springmvc");//==>request.setattitbute();
		mv.setViewName("index");
		return mv;

	}

	@GetMapping("/go1")
	public String print1() {
		System.out.println("我被调用了1");
		return "index";
	}

	@RequestMapping("/go2")
	public void print2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		System.out.println(uname);
		request.setAttribute("uname", uname);
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	@RequestMapping("/go4")
	public String print4(String uname, String pwd ,HttpServletRequest request) throws ServletException, IOException {
		System.out.println(uname);
		System.out.println(pwd);
		request.setAttribute("uname", uname);
		request.setAttribute("pwd", pwd);
		return "index";
	}

	@RequestMapping("/go3")
	public String print3(User user) throws ServletException, IOException {
		System.out.println(user.getPwd());
		System.out.println(user.getUname());
		return "index";
	}
	@RequestMapping("/go5")
	public @ResponseBody Map<String, Object> print5() throws ServletException, IOException {
		 Integer[] salesVolume = {10,100,20,56,35,80};  
 		/*营业额*/  
 		double[] bussinessVolume = {10*10,100*8.5,20*9.5,56*9,35*9.5,80*9};  
 		/*横轴, 月份数据*/  
 		String[] months = {"1","2","3","4","5","6"};
 		Map<String, Object> map = new  HashMap<String, Object>();
 		map.put("salesVolume", salesVolume);
 		map.put("bussinessVolume", bussinessVolume);
 		map.put("months", months);
		return map;
	}
	@RequestMapping("/go6")
	public String print6(HttpServletRequest request) throws ServletException, IOException {
		User user   = new User();
		user.setUname("admin");
		user.setPwd("123456");
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			list.add(user);
		}
		request.setAttribute("list", list);
		return "index";
	}
	@RequestMapping("/go7")
	public String print7(String uname,Integer age,MultipartFile headimage) throws ServletException, IOException {
		System.out.println(uname);
		System.out.println(age);
		System.out.println(headimage.getOriginalFilename());
		System.out.println(headimage.getSize());
		System.out.println(headimage.getName());
		String oldfilename = headimage.getOriginalFilename();
		if(headimage!=null&&oldfilename.length()>0&&oldfilename!=null){
			String pic_path="E:\\";
			String newfilename = UUID.randomUUID()+oldfilename.substring(oldfilename.lastIndexOf("."));
		    File file = new File(pic_path,newfilename);
		    headimage.transferTo(file);
		}
		return "index";
	}
}
