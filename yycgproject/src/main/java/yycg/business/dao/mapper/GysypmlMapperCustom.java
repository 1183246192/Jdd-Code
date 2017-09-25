package yycg.business.dao.mapper;

import java.util.List;


import yycg.business.pojo.po.Gysypml;
import yycg.business.pojo.vo.GysypmlCustom;
import yycg.business.pojo.vo.GysypmlQueryVo;

public interface GysypmlMapperCustom {
    
	//供货商药品目录查询列表
	public List<GysypmlCustom> findGysypmlList(GysypmlQueryVo gysypmlQueryVo) throws Exception;
	public int findGysypmlCount(GysypmlQueryVo gysypmlQueryVo) throws Exception;
	//供货商添加药品目录查询列表
	public List<GysypmlCustom> findAddGysypmlList(GysypmlQueryVo gysypmlQueryVo) throws Exception;
	public int findAddGysypmlCount(GysypmlQueryVo gysypmlQueryVo) throws Exception;
	
	//根据usergysid查询存在药品Id
	public List<Gysypml> findGysypmlByUsersysid(String usergysid) throws Exception;
}