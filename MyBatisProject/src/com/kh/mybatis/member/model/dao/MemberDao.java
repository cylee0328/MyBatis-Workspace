package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public Member loginMember(SqlSession sqlSession, Member m) {
		
		// 조회해오는 메소드 selectOne : 조회해 올 데이ㅓ가 1개일 때 사용, 조회된 데이터가 없다면 null값을 반환
		// insert문을 실행할때는 insert.
		return sqlSession.selectOne("memberMapper.loginMember", m);
	
		
	}
	
	public int insertMember(SqlSession sqlSession, Member m) {
		
		
		/*
		 * sqlSession.sql문 종류에 맞는 메소드("매퍼파일의 namespace.해당sql문 안의 고유한 id", sql문을 완성시켜줄 객체)
		 */
		return sqlSession.insert("memberMapper.insertMember", m);
	}
}
