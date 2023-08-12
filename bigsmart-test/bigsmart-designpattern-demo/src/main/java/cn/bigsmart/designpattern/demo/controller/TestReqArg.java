package cn.bigsmart.designpattern.demo.controller;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author cjj
 * @date 2023/8/12 11:22
 * @description
 **/
@Data
public class TestReqArg {
    @NotNull(message = "id不能为空")
    private Integer id;
    private String name;
}
