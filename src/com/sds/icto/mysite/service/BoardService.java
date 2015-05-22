package com.sds.icto.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.domain.BoardVo;
import com.sds.icto.mysite.repository.BoardDao;

@Service
public class BoardService {

	@Autowired
	BoardDao boardDao;

	public List<BoardVo> list(){
		List<BoardVo> list = boardDao.fetchList();
		return list;
	}
	
	public BoardVo BoardContent(Long no) {
		BoardVo boardVo2 = boardDao.getContent(no);
		return boardVo2;
	}
	
	public void boardUpdateViewcnt(BoardVo vo){
		boardDao.UpdateViewcnt(vo);
	}

	public void boardInsert(BoardVo vo){
		boardDao.Insert(vo);
	}
	
	public void boardDelete(BoardVo vo){
		boardDao.delete(vo);
	}
	
	public void boardUpdate(BoardVo vo){
		boardDao.Update(vo);
	}
}
