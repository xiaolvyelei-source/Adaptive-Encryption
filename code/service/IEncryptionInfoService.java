package com.decsec.seclevel.service;

import com.decsec.seclevel.bean.EncryptionInfo;
import com.decsec.seclevel.bean.TimeDiff;

import java.util.List;

public interface IEncryptionInfoService {

    public boolean insertEncryptionInfo(EncryptionInfo encryptionInfo, List<TimeDiff> timeDiffList);

}
