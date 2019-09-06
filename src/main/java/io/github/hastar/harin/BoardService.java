package io.github.hastar.harin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.hastar.VO.PostVO;
import io.github.hastar.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper bm;
	
	public List<PostVO> getAllData(){
		return bm.getAllData();
	}
	
	public PostVO getOneData(String no) {
		return bm.getOneData(no);
	}
	
	public int setNewData(PostVO pv, HttpSession session) {
		//차후 수정
		//session.setAttribute("name", "HahaHoho");
		pv.setName(session.getAttribute("name").toString());
		int result = bm.setNewData(pv);
		if(result>0) {
			PostVO pvs =bm.selectNewData(pv);
			return Integer.parseInt(pvs.getNo());
		}
		return -1;
	}
	
	public List<HashMap<String,Object>> getFileData(String no){
		List<HashMap<String,Object>> resultList = bm.getFileData(no);
		System.out.println("RESULT LIST = "+resultList.toString());
		return resultList;
	}
}
