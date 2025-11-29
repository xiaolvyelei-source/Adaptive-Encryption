package com.decsec.seclevel.service.impl;

import com.alibaba.druid.support.json.JSONUtils;
import com.decsec.seclevel.bean.AdaptiveAnalysis;
import com.decsec.seclevel.bean.AdaptiveEncryption;
import com.decsec.seclevel.bean.TimeDiffAdaptive;
import com.decsec.seclevel.dao.AdaptiveAnalysisDao;
import com.decsec.seclevel.dao.AdaptiveEncryptionDao;
import com.decsec.seclevel.dao.TimeDiffAdaptiveDao;
import com.decsec.seclevel.dao.TimeDiffDao;
import com.decsec.seclevel.service.IAdaptiveEncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.*;

@Service
public class AdaptiveEncryptionServiceImpl implements IAdaptiveEncryptionService {

    @Autowired
    private AdaptiveEncryptionDao adaptiveEncryptionDao;

    @Autowired
    private TimeDiffAdaptiveDao timeDiffAdaptiveDao;

    @Autowired
    private AdaptiveAnalysisDao adaptiveAnalysisDao;


    @Override
    public boolean insertAdaptiveEncryption(AdaptiveEncryption adaptiveEncryption, List<TimeDiffAdaptive> timeDiffAdaptiveList) {

        adaptiveEncryption.setEnterTime(new Date());

        adaptiveEncryptionDao.insertAdaptiveEncryption(adaptiveEncryption);

        for (TimeDiffAdaptive timeDiffAdaptive : timeDiffAdaptiveList) {

            timeDiffAdaptive.setAdaptiveEncryptionId(adaptiveEncryption.getId());
            timeDiffAdaptiveDao.insertTimeDiffAdaptive(timeDiffAdaptive);
        }

        return true;
    }

   

   


}
