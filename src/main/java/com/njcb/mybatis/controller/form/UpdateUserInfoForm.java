package com.njcb.mybatis.controller.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UpdateUserInfoForm {
    @NotNull
    private Integer userId;

    @NotBlank
    private String name;

    @NotBlank
    private String sex;

    @NotBlank
    private String deptName;

    @NotBlank
    private String tel;

    @NotBlank
    private String email;

    @NotBlank
    private String hiredate;


    @Range(min = 1, max = 2)
    private int status;
}
