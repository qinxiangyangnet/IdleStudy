package com.yueyang.tt.lambada;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-06-17 10:36
 **/
@Data
public class BaseParam implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8687047529983859417L;

    /**
     * 应用id
     */
    private Long appId;
    /**
     * 客户端包路径
     */
    private String packageStr;

}