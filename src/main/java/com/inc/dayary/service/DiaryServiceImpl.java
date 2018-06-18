package com.inc.dayary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inc.dayary.dao.DiaryDao;
import com.inc.dayary.vo.Diary;

@Service
public class DiaryServiceImpl implements DiaryService{
	
	@Autowired
	private DiaryDao diaryDao;
	
	@Override
	public List<Diary> list() {
		
		return diaryDao.getList();
	}

}