package com.walkBAM.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.walkBAM.dao.RootDao;
import com.walkBAM.dao.SceneryDao;
import com.walkBAM.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
@AutoConfigureAfter({SceneryDao.class})
class SceneryServiceImpl implements SceneryService {
    @Autowired
    private SceneryDao sdao;

    @Override
    public boolean destroyScenery(Integer s_id) {
        if(sdao.deleteScenery(s_id)>0)
            return true;
        return false;
    }

    @Override
    public boolean destroyMarkScenery(Integer m_id) {
        if(sdao.deleteMarkScenery(m_id)>0)
            return true;
        return false;
    }

    @Override
    public boolean modifyScenery(Integer s_id, Integer s_state) {
        if(sdao.updateScenery(s_id,s_state)>0)
            return true;
        return false;
    }

    @Override
    public Page<Map<String, Object>> findScenery(Integer page,Integer rows, String search, Integer s_state) {
        System.out.println("findScenery...");
        PageHelper.startPage(page, rows);
        Page<Map<String, Object>> list = (Page<Map<String, Object>>) sdao.selectAllScenery(search,s_state);
        for (Map<String,Object> m :list) {
            System.out.println(m.get("s_id")+"\t"+m.get("m_name"));
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> findSceneryById(Integer s_id) {
        List<Map<String, Object>> list = sdao.selectSceneryById(s_id);
        System.out.println("findSceneryById...");
        for (Map<String,Object> map :list) {
            System.out.println(map.get("s_id")+"\t"+map.get("s_title"));
        }
        return list;
    }
}
