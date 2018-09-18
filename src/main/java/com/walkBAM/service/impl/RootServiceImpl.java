package com.walkBAM.service.impl;

import com.walkBAM.dao.RootDao;
import com.walkBAM.dao.UserDao;
import com.walkBAM.pojo.Root;
import com.walkBAM.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@AutoConfigureAfter({RootDao.class})
public class RootServiceImpl implements RootService {
    @Autowired
    private RootDao rd;

    @Override
    public List<Map<String,Object>> findAllRoot() {
        return rd.selectAllRoot();
    }
}
