package com.njcb.mybatis.controller.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SearchUserInfoForm {

    private Integer userId;

    private String name;
}
