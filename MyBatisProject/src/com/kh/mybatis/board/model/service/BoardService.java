package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.template.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardService {
	
	private BoardDao boardDao = new BoardDao();
	
	public int selectListCount() {
		SqlSession sqlSession = getSqlSession();
		
		int listCount = boardDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}
	
	public ArrayList<Board> selectList(PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao.selectList(sqlSession, pi);
		
		sqlSession.close();
		
		return list;
	}
	
	public int increaseCount(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		int result = new BoardDao().increaseCount(sqlSession, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}
	
	public Board selectBoard(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		
		Board b = new BoardDao().selectBoard(sqlSession, boardNo);
		
		sqlSession.close();
		
		return b;
	}
	
	public ArrayList<Reply> selectReplyList(int boardNo) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Reply> list = boardDao.selectReplyList(sqlSession , boardNo);
		
		sqlSession.close();
		
		return list;
	}
	
	
	public int selectSearchCount(HashMap<String, String> Map) {
		SqlSession sqlSession = getSqlSession();
		
		int searchCount = new BoardDao().selectSearchCount(sqlSession, Map);
		
		sqlSession.close();

		return searchCount;
	}
	
	public ArrayList<Board> selectSearchList(HashMap<String, String> Map, PageInfo pi) {
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = new BoardDao().selectSearchList(sqlSession, Map, pi);
		
		sqlSession.close();
		
		return list;
	}
}
