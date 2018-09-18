package com.walkBAM.dao;

import com.walkBAM.pojo.Scenery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SceneryDao {

    public List<Map<String,Object>> selectAllScenery(@Param("search") String search,@Param("s_state") Integer s_state);

    public List<Map<String,Object>> selectSceneryById(@Param("s_id") Integer s_id);

    public Scenery selectSceneryByMid(@Param("m_id") Integer m_id);

    public int updateScenery(@Param("s_id") Integer s_id,@Param("s_state") Integer s_state);

    public int deleteScenery(@Param("s_id") Integer s_id);

    public int deleteMarkScenery(@Param("m_id") Integer m_id);
}
