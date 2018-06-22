package com.inc.dayary.service;

import javax.validation.Valid;

import com.inc.dayary.vo.Member;

public interface MemberService {

	void add(@Valid Member member);

	Member getOne(String id);

	boolean emailDupCheck(String email);

	String sendCertifyEmail(String email);


}
