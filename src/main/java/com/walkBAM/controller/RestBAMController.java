package com.walkBAM.controller;

import com.github.pagehelper.Page;
import com.walkBAM.pojo.Mark;
import com.walkBAM.pojo.User;
import com.walkBAM.service.*;
import com.walkBAM.util.CookieUtils;
import com.walkBAM.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
public class RestBAMController {

    @Autowired
    private UserService us;
    @Autowired
    private RootService rs;
    @Autowired
    private CertService cs;
    @Autowired
    private MarkService ms;
    @Autowired
    private SceneryService ss;
    @Autowired
    private StatisService sservice;

    @RequestMapping("/loginMsg.action")
    public Map<String, Object> loginMsg(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", CookieUtils.getCookie(request,"msg"));
        map.put("rembername",CookieUtils.getCookie(request,"rembername"));
        map.put("user",CookieUtils.getCookie(request,"user"));
        return map;
    }

    @RequestMapping("/byValue.action")
    public Map<String, Object> byValue(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("user", CookieUtils.getCookie(request,"user"));
        return map;
    }

    @RequestMapping("/modifyPwd.action")
    public Map<String, Object> modifyPwd(String pwd, HttpServletRequest request) {
        System.out.println("modifyPwd");
        System.out.println("密码："+pwd);
        Map<String, Object> map = new HashMap<>();
        us.modifyAdminPwd(pwd, request.getSession());
        map.put("res", pwd);
        return map;
    }

    @RequestMapping("/rootComBox.action")
    public List<Map<String, Object>> rootComBox(HttpSession session) {
        System.out.println("rootComBox...");
        List<Map<String, Object>> list = rs.findAllRoot();
        Map<String, Object> m = new HashMap<>();
        m.put("root_id", "");
        m.put("root_T", "请选择");
        list.add(0, m);
        for (Map<String, Object> map : list) {
            System.out.println(map.get("root_id") + "\t" + map.get("root_T"));
        }
        return list;
    }

    @RequestMapping("/certComBox.action")
    public List<Map<String, Object>> certComBox(HttpSession session) {
        System.out.println("certComBox...");
        List<Map<String, Object>> list = cs.findAllCert();
        Map<String, Object> m = new HashMap<>();
        m.put("certid", "");
        m.put("certT", "请选择");
        list.add(0, m);
        for (Map<String, Object> map : list) {
            System.out.println(map.get("certid") + "\t" + map.get("certT"));
        }
        return list;
    }

    @RequestMapping("/userFind.action")
    public Map<String, Object> userFind(Integer page, Integer rows, String keyword, String userRight, String certification) {
        System.out.println("userFind...");
        System.out.println(page + "\t" + rows + "\t" + keyword + "\t" + userRight + "\t" + certification);
        Page<Map<String, Object>> page1 = us.findAllUser(page, rows, keyword, userRight, certification);
        Map<String, Object> map = new HashMap<>();
        map.put("total", page1.getTotal());
        map.put("rows", page1);
        return map;
    }

    @RequestMapping("/addUser.action")
    public Map<String, Object> addUser(User user) {
        System.out.println("addUser...");
        System.out.println(user.getU_nickname() + "\t" + user.getU_root() + "\t" + user.getU_password() + "\t" + user.getU_idcard() + "\t" + user.getU_name() + "\t" + user.getU_phone() + "\t" + user.getU_cert());
        Map<String, Object> map = new HashMap<>();
        boolean res = us.addUser(user);
        System.out.println(res);
        if (res)
            map.put("msg", "新增用户成功");
        else
            map.put("msg", "新增用户失败");
        return map;
    }

    @RequestMapping("/modifyUser.action")
    public Map<String, Object> modifyUser(User user) {
        System.out.println("modifyUser...");
        System.out.println(user.getU_nickname() + "\t" + user.getU_root() + "\t" + user.getU_password() + "\t" + user.getU_idcard() + "\t" + user.getU_name() + "\t" + user.getU_phone() + "\t" + user.getU_cert());
        Map<String, Object> map = new HashMap<>();
        boolean res = us.modifyUser(user);
        System.out.println(res);
        if (res)
            map.put("msg", "修改用户成功");
        else
            map.put("msg", "修改用户失败");
        return map;
    }

    @RequestMapping("/destroyUser.action")
    public Map<String, Object> destroyUser(Integer id) {
        System.out.println("destroyUser...");
        System.out.println(id);
        Map<String, Object> map = new HashMap<>();
        Mark mark = ms.finMarkByUid(id);
        boolean scenRes = ss.destroyMarkScenery(mark.getM_id());
        boolean markRes = ms.destroyUserMark(id);
        boolean res = us.destroyUser(id);
        System.out.println(res);
        if (res)
            map.put("msg", "删除用户成功");
        else
            map.put("msg", "删除用户失败");
        return map;
    }

    @RequestMapping("/merchantFind.action")
    public Map<String, Object> merchantFind(Integer page, Integer rows, String keyword) {
        System.out.println("merchantFind...");
        System.out.println(page + "\t" + rows + "\t" + keyword);
        Page<Map<String, Object>> page1 = ms.findAllMark(page, rows, keyword, 1);
        Map<String, Object> map = new HashMap<>();
        map.put("total", page1.getTotal());
        map.put("rows", page1);
        return map;
    }


    @RequestMapping("/modifyMerchant.action")
    public Map<String, Object> modifyMerchant(Mark mark) {
        System.out.println("modifyMerchant...");
        System.out.println(mark.getM_id() + "\t" + mark.getM_address() + "\t" + mark.getM_phone() + "\t" + mark.getM_name());
        Map<String, Object> map = new HashMap<>();
        boolean res = ms.modifyMark(mark);
        System.out.println(res);
        if (res)
            map.put("msg", "修改商家成功");
        else
            map.put("msg", "修改商家失败");
        return map;
    }


    @RequestMapping("/destroyMerchant.action")
    public Map<String, Object> destroyMerchant(Integer id) {
        System.out.println("destroyMerchant...");
        System.out.println(id);
        Map<String, Object> map = new HashMap<>();
        ss.destroyMarkScenery(id);
        boolean res = ms.destroyMark(id);
        System.out.println(res);
        if (res)
            map.put("msg", "删除商家成功");
        else
            map.put("msg", "删除商家失败");
        return map;
    }


    @RequestMapping("/merchantAFind.action")
    public Map<String, Object> merchantAFind(Integer page, Integer rows, String keyword, Integer m_state) {
        System.out.println("merchantAFind...");
        System.out.println(page + "\t" + rows + "\t" + keyword);
        System.out.println("m_state:" + m_state);
        if (m_state == null)
            m_state = 0;
        Page<Map<String, Object>> page1 = ms.findAllMark(page, rows, keyword, m_state);
        Map<String, Object> map = new HashMap<>();
        map.put("total", page1.getTotal());
        map.put("rows", page1);
        return map;
    }

    @RequestMapping("/modifyAMerchant.action")
    public Map<String, Object> modifyAMerchant(Mark mark) {
        System.out.println("modifyAMerchant...");
        System.out.println(mark.getM_id() + "\t" + mark.getM_address() + "\t" + mark.getM_phone() + "\t" + mark.getM_name());
        Map<String, Object> map = new HashMap<>();
        boolean res = ms.modifyMark(mark);
        System.out.println(res);
        if (res)
            map.put("msg", "修改商家成功");
        else
            map.put("msg", "修改商家失败");
        return map;
    }


    @RequestMapping("/destroyAMerchant.action")
    public Map<String, Object> destroyAMerchant(Integer id) {
        System.out.println("destroyAMerchant...");
        System.out.println(id);
        Map<String, Object> map = new HashMap<>();
        boolean scenRes = ss.destroyMarkScenery(id);
        boolean MarkRes = ms.destroyMark(id);
        if (scenRes == true && MarkRes == true)
            map.put("msg", "删除商家成功");
        else
            map.put("msg", "删除商家失败");
        return map;
    }

    @RequestMapping("/auditMerchantSuccess.action")
    public String auditMerchantSuccess(int id) {
        System.out.println(id);
        String res = "Failure";
        if (ms.modifyMarkAudit(1, id))
            res = "Success";
        String json = "[{\"audit\":\"" + res + "\"}]";
        System.out.println(json);
        return json;
    }

    @RequestMapping("/auditMerchantFailure.action")
    public String auditMerchantFailure(int id) {
        System.out.println(id);
        String res = "Failure";
        if (ms.modifyMarkAudit(2, id))
            res = "Success";
        String json = "[{\"audit\":\"" + res + "\"}]";
        System.out.println(json);
        return json;
    }

    @RequestMapping("/destroyMerch.action")
    public String destroyMerch(int id) {
        String res = "Failure";
        if (ms.destroyMark(id))
            res = "Success";
        String json = "[{\"audit\":\"" + res + "\"}]";
        return json;
    }

    @RequestMapping("/sceneryFind.action")
    public Map<String, Object> sceneryFind(Integer page, Integer rows, String keyword, Integer s_state) {
        System.out.println("sceneryFind...");
        System.out.println(page + "\t" + rows + "\t" + keyword + "\t" + s_state);
        if (s_state == null)
            s_state = 0;
        Page<Map<String, Object>> page1 = ss.findScenery(page, rows, keyword, s_state);
        Map<String, Object> map = new HashMap<>();
        map.put("total", page1.getTotal());
        map.put("rows", page1);
        return map;
    }

    @RequestMapping("/sceneryFindById.action")
    public Map<String, Object> sceneryFindById(Integer s_id) {
        System.out.println("sceneryFindById...");
        List<Map<String, Object>> list = ss.findSceneryById(s_id);
        System.out.println(list.get(0).get("s_img"));
        List<String> lb = FileUtil.getFiles((String) list.get(0).get("s_img") + "/lb");
        List<String> xq = FileUtil.getFiles((String) list.get(0).get("s_img") + "/xq");
        Map<String, Object> map = new HashMap<>();
        map.put("rows", list);
        map.put("lb", lb);
        map.put("xq", xq);
        return map;
    }

    @RequestMapping("/sceneryModify.action")
    public Map<String, Object> sceneryModify(Integer id, Integer s_state) {
        System.out.println("sceneryModify...");
        System.out.println(id + "\t" + s_state);
        ss.modifyScenery(id, s_state);
        return null;
    }


    @RequestMapping("/destroyScen.action")
    public Map<String, Object> destroyScen(Integer id) {
        System.out.println("destroyScen...");
        System.out.println(id);
        Map<String, Object> map = new HashMap<>();
        boolean res = ss.destroyScenery(id);
        System.out.println(res);
        if (res)
            map.put("msg", "删除景点成功");
        else
            map.put("msg", "删除景点失败");
        return map;
    }

    @RequestMapping("/dashboard.action")
    public Map<String, Object> dashboard() {
        Map<String, Object> map = new HashMap<>();
        map.put("weeks", sservice.findWeeks());

        map.put("weeksOrder", sservice.findOrders());
        map.put("weeksTotal", sservice.findTotal());
        return map;
    }

    @RequestMapping("/dashboard1.action")
    public Map<String, Object> dashboard1() {
        Map<String, Object> map = new HashMap<>();
        map.put("pending", sservice.findPending());
        map.put("todayOrder", sservice.findOrders(new Date(), 0));
        map.put("yesterdayOrder", sservice.findOrders(new Date(), -1));
        map.put("todayTotal", sservice.findTotal(new Date(), -1));
        return map;
    }
}
