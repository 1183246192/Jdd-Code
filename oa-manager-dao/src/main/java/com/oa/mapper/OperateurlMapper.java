package com.oa.mapper;

import com.oa.pojo.Operateurl;
import com.oa.pojo.OperateurlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperateurlMapper {
    int countByExample(OperateurlExample example);

    int deleteByExample(OperateurlExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Operateurl record);

    int insertSelective(Operateurl record);

    List<Operateurl> selectByExample(OperateurlExample example);

    Operateurl selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Operateurl record, @Param("example") OperateurlExample example);

    int updateByExample(@Param("record") Operateurl record, @Param("example") OperateurlExample example);

    int updateByPrimaryKeySelective(Operateurl record);

    int updateByPrimaryKey(Operateurl record);
}