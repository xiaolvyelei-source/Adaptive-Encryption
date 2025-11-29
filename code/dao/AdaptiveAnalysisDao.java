package com.decsec.seclevel.dao;

import com.decsec.seclevel.bean.AdaptiveAnalysis;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdaptiveAnalysisDao {

    public boolean insertAdaptiveAnalysis(AdaptiveAnalysis adaptiveAnalysis);


}
