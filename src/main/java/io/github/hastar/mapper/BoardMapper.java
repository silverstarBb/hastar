package io.github.hastar.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import io.github.hastar.VO.PostVO;

@Mapper
public interface BoardMapper {
	public List<PostVO> getAllData();
	public PostVO getOneData(String no);
	public int setNewData(PostVO pv);
	public PostVO selectNewData(PostVO pv);
}