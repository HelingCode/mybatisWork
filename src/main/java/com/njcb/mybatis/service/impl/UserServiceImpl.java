package com.njcb.mybatis.service.impl;


import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.njcb.mybatis.dao.TbUserDao;
import com.njcb.mybatis.entity.TbUser;
import com.njcb.mybatis.exception.EmosException;
import com.njcb.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private TbUserDao userDao;

    @Override
    public void insertUser(HashMap param) {
        //保存记录
        int row = userDao.insert(param);
    }

    @Override
    public HashMap searchUserInfo(int userId) {
        HashMap map = userDao.searchUserInfo(userId);
        return map;
    }

    @Override
    public List<TbUser> searchUserLike(String name) {
        List<TbUser> users = userDao.searchUserLike(name);
        return users;
    }

    @Override
    public int updateUserInfo(HashMap param) {
        //更新员工记录
        int rows = userDao.updateUserInfo(param);
        return rows;
    }

    @Override
    public void deleteUserById(int id) {
        int row = userDao.deleteUserById(id);
        if(row != 1){
            throw new EmosException("删除员工失败");

        }
    }


}
