package com.sds.icto.mysite.repository;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.sds.icto.mysite.domain.GuestbookVo;
		
@Repository
public class GuestbookDao {
	
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;
	
	public void insert(GuestbookVo vo) {
		sqlMapClientTemplate.insert("guestbook.insert",vo);
	}
	
	public void delete(GuestbookVo vo) {
		sqlMapClientTemplate.delete("guestbook.delete",vo);
	}

	public List<GuestbookVo> fetchList() {
		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		
		list = sqlMapClientTemplate.queryForList("guestbook.list");
		
		return list;
	}
}
