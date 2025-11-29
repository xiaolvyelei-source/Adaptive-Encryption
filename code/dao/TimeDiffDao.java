package com.decsec.seclevel.dao;

import com.decsec.seclevel.bean.TimeDiff;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeDiffDao {

    public boolean insertTimeDiff(TimeDiff timeDiff);

}
