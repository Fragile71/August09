package com.poseidon.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@GetMapping("/login.sik")
	public String index() {
		return "login";
	}

	@Autowired
	LoginService loginService;

	@PostMapping("/login.sik")
	public String login(@RequestParam Map<String, String> map, HttpSession session) {
		System.out.println(map);
		Map<String, Object> result = loginService.login(map);
		// {m_name=윤승현, count=1}
		int count = Integer.parseInt(result.get("count").toString());
		if (count == 1) {
			session.setAttribute("mid", map.get("id"));
			session.setAttribute("mname", result.get("m_name"));
System.out.println("결과:"+ session.getAttribute("mname"));
     			


			return "redirect:/";
		} else {

			// 다시 로그인으로 가기
			return "login";
		}

	}

@GetMapping("/logout.sik")
public String logout(HttpSession session) {
	if(session.getAttribute("mid") != null) {
		session.removeAttribute("mid");
		
	}
	if(session.getAttribute("mname") != null) {
		
		session.removeAttribute("mname");
	}
	//다른
    session.invalidate();
	return "redirect:/";
	
	
	
}
//20230818 요구사항 확인
//@PathVariable 사용법
@GetMapping("/myInfo@{id}")
public String myinfo(@PathVariable("id")String id, HttpSession session, Model model) {
	System.out.println("jsp가 보내준 값:" + id);
	System.out.println(id.equals(session.getAttribute("mid")));
	//회원가입할때 개인정보 수정할때 암호 암호화 하기
    Map<String,Object> myInfo =loginService.myInfo(id);
	
    model.addAttribute("myInfo", myInfo);
	return "myInfo";
	
}









}
