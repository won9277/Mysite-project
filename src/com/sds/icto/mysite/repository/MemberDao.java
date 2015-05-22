package com.sds.icto.mysite.repository;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.sds.icto.Exception.MemberDaoException;
import com.sds.icto.mysite.domain.MemberVo;

@Repository
public class MemberDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public MemberVo get(MemberVo vo) {
		MemberVo memberVo = null;
				memberVo = (MemberVo) sqlMapClientTemplate.queryForObject(
					"member.getMember", vo);
		return memberVo;
	}

	public void insert(MemberVo vo) {
		sqlMapClientTemplate.insert("member.insert", vo);
	}
}
