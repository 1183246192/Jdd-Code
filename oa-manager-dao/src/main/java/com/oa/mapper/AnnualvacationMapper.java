package com.oa.mapper;

import com.oa.pojo.Annualvacation;
import com.oa.pojo.AnnualvacationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnnualvacationMapper {
    int countByExample(AnnualvacationExample example);

    int deleteByExample(AnnualvacationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Annualvacation record);

    int insertSelective(Annualvacation record);

    List<Annualvacation> selectByExample(AnnualvacationExample example);

    Annualvacation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Annualvacation record, @Param("example") AnnualvacationExample example);

    int updateByExample(@Param("record") Annualvacation record, @Param("example") AnnualvacationExample example);

    int updateByPrimaryKeySelective(Annualvacation record);

    int updateByPrimaryKey(Annualvacation record);
}