package com.inc.dayary.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.inc.dayary.dao.MemberDao;
import com.inc.dayary.vo.Member;

@Service
public class MemberviceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JavaMailSender JavaMailSender;

	@Override
	public void add(Member member) {
		memberDao.add(member);
	}

	@Override
	public Member getOne(String id) {
		return memberDao.getOne(id);
	}

	@Override
	public boolean emailDupCheck(String email) {
		Member member = memberDao.getfindOneByEmail(email);
		return member!=null;
	}

	@Override
	public String sendCertifyEmail(String email) {
		String from = "khh971228@gmail.com";
		String subject = "Dayary 이메일 인증";
		String code = makeCode();
		String content = "인증코드 : "+code;
		
		try {
			MimeMessage msg = JavaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(msg,true,"utf-8");
			helper.setFrom(from);
			helper.setTo(email);
			helper.setSubject(subject);
			helper.setText(content);
			JavaMailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return code;
	}
	
	public String makeCode() {
		StringBuffer realCode = new StringBuffer();
		for(int i =0;i<4;i++) {
			realCode.append((int)(Math.random() *10));
		}
		return realCode.toString();
	}
}
