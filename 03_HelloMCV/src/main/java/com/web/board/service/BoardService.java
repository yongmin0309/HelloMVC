package com.web.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.web.board.dao.BoardDao;
import com.web.board.dto.Board;
import static com.web.common.SessionTemplate.getSession;
public class BoardService {
	private BoardDao dao = new BoardDao();
	
	public List<Board> selectBoardList(){
		SqlSession session = getSession();
		List<Board> result = dao.selectBoardList(session);
		session.close();
		return result;
	}
}
