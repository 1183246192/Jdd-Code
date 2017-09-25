package com.oa.mapper;

import com.oa.pojo.Userpermission;
import com.oa.pojo.UserpermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserpermissionMapper {
    int countByExample(UserpermissionExample example);

    int deleteByExample(UserpermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Userpermission record);

    int insertSelective(Userpermission record);

    List<Userpermission> selectByExample(UserpermissionExample example);

    Userpermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Userpermission record, @Param("example") UserpermissionExample example);

    int updateByExample(@Param("record") Userpermission record, @Param("example") UserpermissionExample example);

    int updateByPrimaryKeySelective(Userpermission record);

    int updateByPrimaryKey(Userpermission record);
}