package com.poseidon.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.poseidon.web.service.NoticeService;

@Controller
public class NoticeController {
	//필요한거? model + map+ service+ DAO + Mapper 

	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/notice")
	public String notice(Model model) {
		
		List<Map<String, Object>> list = noticeService.list();
		model.addAttribute("list", list);
		noticeService.list();
		
		
		return "notice";
	}
	
	
	
}
