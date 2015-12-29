package org.ibitu.service;

import java.util.List;

import org.ibitu.domain.Criteria;
import org.ibitu.domain.DBoardVO;

public interface DBoardService {
	
	public void regist(DBoardVO vo) throws Exception;
	
	public DBoardVO read(Integer bno) throws Exception;
	
	public void modify(DBoardVO vo) throws Exception;
	
	public void remove(Integer bno) throws Exception;
	
	public List<DBoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int listCntCriteria(Criteria cri) throws Exception;
}
