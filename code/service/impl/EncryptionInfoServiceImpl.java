package com.decsec.seclevel.service.impl;

import com.decsec.seclevel.bean.EncryptionInfo;
import com.decsec.seclevel.bean.TimeDiff;
import com.decsec.seclevel.dao.EncryptionInfoDao;
import com.decsec.seclevel.dao.TimeDiffDao;
import com.decsec.seclevel.service.IEncryptionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class EncryptionInfoServiceImpl implements IEncryptionInfoService {

    @Autowired
    private EncryptionInfoDao encryptionInfoDao;

    @Autowired
    private TimeDiffDao timeDiffDao;


    @Override
    public boolean insertEncryptionInfo(EncryptionInfo encryptionInfo, List<TimeDiff> timeDiffList) {
        encryptionInfo.setEnterTime(new Date());
        encryptionInfoDao.insertEncryptionInfo(encryptionInfo);

        for (TimeDiff timeDiff: timeDiffList) {

            timeDiff.setEncryptionId(encryptionInfo.getId());

            timeDiffDao.insertTimeDiff(timeDiff);

        }



        return true;
    }
}
