package com.poseidon.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poseidon.web.dao.NoticeDAO;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;

	public List<Map<String, Object>> list() {

		return noticeDAO.list();
	}
}