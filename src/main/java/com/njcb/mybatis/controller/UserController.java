package com.njcb.mybatis.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.njcb.mybatis.common.R;
import com.njcb.mybatis.controller.form.DeleteUserByIdForm;
import com.njcb.mybatis.controller.form.InsertUserForm;
import com.njcb.mybatis.controller.form.SearchUserInfoForm;
import com.njcb.mybatis.controller.form.UpdateUserInfoForm;
import com.njcb.mybatis.entity.TbUser;
import com.njcb.mybatis.exception.EmosException;
import com.njcb.mybatis.service.UserService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/insertUser")
    public R insertUser(@RequestBody InsertUserForm form){
        HashMap param = new HashMap();
        param.put("name", form.getName());
        param.put("sex", form.getSex());
        param.put("tel", form.getTel());
        param.put("email", form.getEmail());
        param.put("hiredate", form.getHiredate());
        param.put("deptName", form.getDeptName());
        param.put("status", form.getStatus());
        param.put("createTime", new Date());

        param.put("root",false);


        userService.insertUser(param);
        return R.ok().put("result","success");
    }

    @PostMapping("/searchUserLike")
    public R searchUserLike(@Valid @RequestBody SearchUserInfoForm form){
        List<TbUser> list = userService.searchUserLike(form.getName());
        return R.ok().put("result",list);
    }

    @PostMapping("/searchUserSelfInfo")
    public R searchUserSelfInfo(@RequestParam("userId") Integer userId){
        HashMap map = userService.searchUserInfo(userId);
        return R.ok().put("result",map);
    }

    @PostMapping("/updateUserInfo")
    public R updateUserInfo(@RequestBody UpdateUserInfoForm form){
        boolean root = false;

        HashMap param = new HashMap();
        param.put("name", form.getName());
        param.put("sex", form.getSex());
        param.put("deptName", form.getDeptName());
        param.put("tel", form.getTel());
        param.put("email", form.getEmail());
        param.put("hiredate", form.getHiredate());
        param.put("status", form.getStatus());
        param.put("userId", form.getUserId());
        param.put("root", root);

        int rows = userService.updateUserInfo(param);
        return R.ok().put("result", rows);
    }

    @PostMapping("/deleteUserById")
    public R deleteUserById(@Valid @RequestBody DeleteUserByIdForm form){
        userService.deleteUserById(form.getId());
        return R.ok().put("result","success");
    }



}
