package com.decsec.seclevel.dao;

import com.decsec.seclevel.bean.AdaptiveEncryption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdaptiveEncryptionDao {


    public boolean insertAdaptiveEncryption(AdaptiveEncryption adaptiveEncryption);

    public List<AdaptiveEncryption> getAllAdaptiveEncryption(Map<String,Object> queryMap);
}
