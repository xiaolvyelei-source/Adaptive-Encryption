package com.decsec.seclevel.dao;

import com.decsec.seclevel.bean.EncryptionInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EncryptionInfoDao {

    public boolean insertEncryptionInfo(EncryptionInfo encryptionInfo);


}
