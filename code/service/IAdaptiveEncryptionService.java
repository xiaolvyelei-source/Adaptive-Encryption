package com.decsec.seclevel.service;

import com.decsec.seclevel.bean.AdaptiveEncryption;
import com.decsec.seclevel.bean.TimeDiffAdaptive;

import java.util.List;

public interface IAdaptiveEncryptionService {

    public boolean insertAdaptiveEncryption(AdaptiveEncryption adaptiveEncryption, List<TimeDiffAdaptive> timeDiffAdaptiveList);

   

}
