package com.walkBAM.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.walkBAM.dao.MarkDao;
import com.walkBAM.dao.UserDao;
import com.walkBAM.pojo.Mark;
import com.walkBAM.pojo.User;
import com.walkBAM.service.MarkService;
import com.walkBAM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
@Transactional
@AutoConfigureAfter({MarkDao.class})
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkDao markDao;
    @Override
    public Page<Map<String, Object>> findAllMark(Integer page,Integer rows, String search,Integer m_state) {

        PageHelper.startPage(page, rows);
        Page<Map<String, Object>> list = (Page<Map<String, Object>>) markDao.selectAllMark(search,m_state);
        System.out.println("findAllMark:...");
        for (Map<String,Object> m :list) {
            System.out.println(m.get("m_id")+"\t"+m.get("m_name"));
        }
        return list;
    }

    @Override
    public Mark finMarkByUid(Integer u_id) {
        return markDao.selectMarkByUid(u_id);
    }

    @Override
    public boolean modifyMark(Mark mark) {
        if (markDao.updateMark(mark)>0)
            return true;
        return false;
    }

    @Override
    public boolean modifyMarkAudit(Integer m_state, Integer m_id) {
        if (markDao.updateMarkAudit(m_state,m_id)>0)
            return true;
        return false;
    }

    @Override
    public boolean destroyMark(Integer m_id) {
        if (markDao.deleteMark(m_id)>0)
            return true;
        return false;
    }

    @Override
    public boolean destroyOrder(Integer m_id) {
        if (markDao.deleteOrder(m_id)>0)
            return true;
        return false;
    }

    @Override
    public boolean destroyUserMark(Integer m_uid) {
        if (markDao.deleteUserMark(m_uid)>0)
            return true;
        return false;
    }
}
