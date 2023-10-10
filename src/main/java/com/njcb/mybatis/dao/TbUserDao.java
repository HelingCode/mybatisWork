package com.njcb.mybatis.dao;

import com.njcb.mybatis.entity.TbUser;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface TbUserDao {

    public int insert(HashMap param);

    public int insertUser(TbUser tbUser);

    public HashMap searchUserInfo(int userId);

    public int updateUserInfo(HashMap param);

    public int deleteUserById(int id);

    List<TbUser> searchUserLike(String name);
}