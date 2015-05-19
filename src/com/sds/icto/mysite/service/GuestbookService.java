package com.sds.icto.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.icto.mysite.domain.GuestbookDao;
import com.sds.icto.mysite.repository.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	GuestbookDao guestbookDao;

	public List<GuestbookVo> getGuestbookList() {
		return guestbookDao.fetchList();
	}

	public void insertMessage(GuestbookVo vo) {
		guestbookDao.insert(vo);
	}

	public void deleteUser(GuestbookVo vo) {
		guestbookDao.delete(vo);
	}

}
