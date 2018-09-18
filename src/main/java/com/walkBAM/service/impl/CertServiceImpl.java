package com.walkBAM.service.impl;

import com.walkBAM.dao.CertDao;
import com.walkBAM.dao.RootDao;
import com.walkBAM.service.CertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
@Service
@Transactional
@AutoConfigureAfter({RootDao.class})
public class CertServiceImpl implements CertService {
    @Autowired
    private CertDao cd;

    @Override
    public List<Map<String, Object>> findAllCert() {
        return cd.selectAllCert();
    }
}
