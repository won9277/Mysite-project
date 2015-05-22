package com.sds.icto.mysite.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.mysite.domain.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public List<BoardVo> fetchList() {
		List<BoardVo> list = new ArrayList<BoardVo>();

		list = sqlMapClientTemplate.queryForList("board.list");

		return list;
	}

	public BoardVo getContent(Long no) {
		BoardVo boardVo2 = (BoardVo) sqlMapClientTemplate.queryForObject(
				"board.getContent", no);
		return boardVo2;
	}

	public void UpdateViewcnt(BoardVo vo) {

		sqlMapClientTemplate.update("board.updateViewcnt", vo);
	}

	public void Insert(BoardVo vo) {

		sqlMapClientTemplate.insert("board.insert", vo);
	}
	
	public void delete(BoardVo vo) {

		sqlMapClientTemplate.delete("board.delete", vo);
	}
	
	public void Update(BoardVo vo) {

		sqlMapClientTemplate.update("board.update", vo);
	}
}
