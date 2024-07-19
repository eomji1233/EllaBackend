package com.ella.notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ella.common.SqlSessionTemplate;
import com.ella.notice.model.dao.NoticeDAO;
import com.ella.notice.model.vo.Notice;

public class NoticeService {
	
	private SqlSession conn;
	private NoticeDAO nDao;
	
	public NoticeService() {
		conn = SqlSessionTemplate.getSqlSession();
		nDao = new NoticeDAO();
	}

	public int insertNotice(Notice notice) {
		int result = nDao.insertNotice(conn, notice);
		return result;
	}

	public List<Notice> selectAllNotice() {
		List<Notice>nList = nDao.selectAllNotice(conn);
		return nList;
	}

	public int deleteNotice(int noticeNo) {
		int result = nDao.deleteNotice(conn, noticeNo);
		return result;
	}
	
	public Notice selectOneByNo(int noticeNo) {
		Notice notice = nDao.seletOne(conn, noticeNo);
		return notice;
	}

	public int updateNotice(Notice notice) {
		int result = nDao.updateNotice(conn, notice);
		return result;
	}


}
