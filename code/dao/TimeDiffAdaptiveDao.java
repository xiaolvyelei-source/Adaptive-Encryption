package com.decsec.seclevel.dao;

import com.decsec.seclevel.bean.TimeDiff;
import com.decsec.seclevel.bean.TimeDiffAdaptive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface TimeDiffAdaptiveDao {

    public boolean insertTimeDiffAdaptive(TimeDiffAdaptive timeDiffAdaptive);

    public List<TimeDiffAdaptive> getAllTimeDiffAdaptive(int id);
}
