package yycg.business.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yycg.business.pojo.po.SysSeq;
import yycg.business.pojo.po.SysSeqExample;

public interface SysSeqMapper {
    int countByExample(SysSeqExample example);

    int deleteByExample(SysSeqExample example);

    int deleteByPrimaryKey(Integer bm);

    int insert(SysSeq record);

    int insertSelective(SysSeq record);

    List<SysSeq> selectByExample(SysSeqExample example);

    SysSeq selectByPrimaryKey(Integer bm);

    int updateByExampleSelective(@Param("record") SysSeq record, @Param("example") SysSeqExample example);

    int updateByExample(@Param("record") SysSeq record, @Param("example") SysSeqExample example);

    int updateByPrimaryKeySelective(SysSeq record);

    int updateByPrimaryKey(SysSeq record);
}