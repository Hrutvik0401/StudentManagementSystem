package com.hrutvik;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hrutvik.Dao.LoginDao;
import com.hrutvik.model.Student;

@Controller
public class LoginController {
	
	LoginDao dao = new LoginDao();
	
	@RequestMapping("/login")
	public ModelAndView LoginUser(HttpServletRequest req, HttpServletResponse res) {
		
		String uname = req.getParameter("u");
		String pass = req.getParameter("p");
		
		String result = dao.Validate(uname, pass);
		
		ModelAndView mv = new ModelAndView();
		
		if (result.equals("Success")) {
			List<Student> studets = dao.GetStudents();
			mv.addObject("studlist", studets);
			mv.setViewName("home.jsp");
		}else {
			mv.addObject("msg", "Invalid credentials, Plese login again!!!");
			mv.setViewName("index.jsp");
		}
	
		return mv;
	}
	
	@RequestMapping("/register")
	public ModelAndView UserRegistration(Student student) {
		ModelAndView mv = new ModelAndView();
		
		if (student != null) {
			dao.UserRegitration(student);
			mv.setViewName("index.jsp");
		}else {
			mv.setViewName("Registration.jsp");
		}
		return mv;
   }
	
	@RequestMapping("/updateform")
	public ModelAndView GetStudById(int SId){
		ModelAndView mv = new ModelAndView();
		
		Student student = dao.getStudentById(SId);
		mv.addObject("student", student);
		mv.setViewName("updateform.jsp");
		return mv;
	}
	
	@RequestMapping("/updateStudent")
	public ModelAndView UpdateStudent(Student student){
		ModelAndView mv = new ModelAndView();
		if(student != null) {
		dao.UpdateStudent(student);
		List<Student> studets = dao.GetStudents();
		mv.addObject("studlist", studets);
		mv.setViewName("home.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/deleteStudent")
	public ModelAndView DeleteStudentById(int SId){
		ModelAndView mv = new ModelAndView();
		
		dao.DeleteStudentById(SId);
		List<Student> studets = dao.GetStudents();
		mv.addObject("studlist", studets);
		mv.setViewName("home.jsp");
		
		return mv;
	}
	
}

