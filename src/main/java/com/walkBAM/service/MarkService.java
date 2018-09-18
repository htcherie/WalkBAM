package com.walkBAM.service;

import com.github.pagehelper.Page;
import com.walkBAM.pojo.Mark;

import java.util.Map;

public interface MarkService {

    public Page<Map<String, Object>> findAllMark(Integer page, Integer rows, String search, Integer m_state);

    public Mark finMarkByUid(Integer u_id);

    public boolean modifyMark(Mark mark);

    public boolean modifyMarkAudit(Integer m_state, Integer m_id);

    public boolean destroyMark(Integer m_id);

    public boolean destroyOrder(Integer m_id);

    public boolean destroyUserMark(Integer m_uid);

}
