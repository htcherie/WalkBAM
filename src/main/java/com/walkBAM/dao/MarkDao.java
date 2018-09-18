package com.walkBAM.dao;

import com.walkBAM.pojo.Mark;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MarkDao {
    public List<Map<String,Object>> selectAllMark(@Param("search") String search,@Param("m_state") Integer m_state);

    public Mark selectMarkByUid(@Param("u_id") Integer u_id);

    public int updateMark(@Param("mark") Mark mark);

    public int updateMarkAudit(@Param("m_state") Integer m_state,@Param("m_id") Integer m_id);

    public int deleteMark(@Param("m_id") Integer m_id);

    public int deleteUserMark(@Param("m_uid") Integer m_uid);
}
