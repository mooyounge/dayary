package com.inc.dayary.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inc.dayary.vo.Member;

@Repository
public class MemberDao {
	@Autowired
	SqlSession sqlSession;

	public void add(Member member) {
		sqlSession.insert("member.insert",member);
	}

	public Member getOne(String id) {
		return sqlSession.selectOne("member.getOne",id);
	}

	public Member getfindOneByEmail(String email) {
		return sqlSession.selectOne("member.findOneByEmail",email);
	}
}
