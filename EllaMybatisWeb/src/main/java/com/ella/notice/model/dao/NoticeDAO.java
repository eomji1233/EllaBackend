package com.ella.notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ella.notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession conn, Notice notice) {
		int result = conn.insert("NoticeMapper.insertNotice", notice);
		return result;
	}

	public List<Notice> selectAllNotice(SqlSession conn) {
		List<Notice>nList = conn.selectList("NoticeMapper.selectList");
		return nList;
	}

	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	public Notice seletOne(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOne", noticeNo);
		return notice;
	}

	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}
}
