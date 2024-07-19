package com.ella.spring.member.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ella.spring.member.domain.MemberVO;
import com.ella.spring.member.service.MemberService;
import com.ella.spring.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired // 의존성 주입!!!!!!!!!!
	private MemberStore mStore; // 다 갖다쓰니까 전역변수로 선언
	@Autowired
	private SqlSession session; // 다 갖다쓰니까 전역변수로 선언

	@Override
	public int insertMember(MemberVO member) {
		int result = mStore.insertMember(session, member);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO checkMemberLogin(MemberVO member) {
		MemberVO result = mStore.checkMemberLogin(session, member);
		return result;
	}

	@Override
	public MemberVO selectOneById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

}
