package com.inc.dayary.service;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inc.dayary.vo.Tag;

@Repository
public class TagDao {

	@Autowired
	SqlSession sqlSession;
	
	public void add(Tag tag) {
		sqlSession.insert("tag.insert",tag);
	}
}
