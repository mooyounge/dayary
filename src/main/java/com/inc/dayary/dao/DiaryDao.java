package com.inc.dayary.dao;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inc.dayary.vo.Diary;

@Repository
public class DiaryDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<Diary> getList() {
		return sqlSession.selectList("diary.list");
	}

	public void add(@Valid Diary diary) {
		sqlSession.insert("diary.insert",diary);
	}

	public List<Diary> getList(String id) {
		return sqlSession.selectList("diary.list",id);
	}
	
}
