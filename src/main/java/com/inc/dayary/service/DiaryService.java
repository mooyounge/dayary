package com.inc.dayary.service;

import java.util.List;

import javax.validation.Valid;

import com.inc.dayary.vo.Diary;

public interface DiaryService {
	public List<Diary> list();

	public void add(@Valid Diary diary);
}
