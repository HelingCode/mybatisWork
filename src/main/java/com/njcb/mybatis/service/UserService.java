package com.njcb.mybatis.service;

import com.njcb.mybatis.entity.TbUser;

import java.util.HashMap;
import java.util.List;

public interface UserService {

    /**
     * 添加新员工
     * @param param
     */
    public void insertUser(HashMap param);

    /**
     * 查询员工基本信息
     * @param userId
     * @return
     */
    public HashMap searchUserInfo(int userId);

    /**
     * 模糊查询员工信息
     * @param name
     * @return
     */
    public List<TbUser> searchUserLike(String name);

    /**
     * 更新用户信息
     * @param param
     * @return
     */
    public int updateUserInfo(HashMap param);

    /**
     * 删除用户
     * @param id
     */
    public void deleteUserById(int id);

}
