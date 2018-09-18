package com.walkBAM.service;

import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface SceneryService {
    public boolean destroyScenery(Integer s_id);

    public boolean destroyMarkScenery(Integer m_id);

    public boolean modifyScenery(Integer s_id,Integer s_state);

    public Page<Map<String,Object>> findScenery(Integer page,Integer rows, String search, Integer s_state);

    public List<Map<String,Object>> findSceneryById(Integer s_id);
}
