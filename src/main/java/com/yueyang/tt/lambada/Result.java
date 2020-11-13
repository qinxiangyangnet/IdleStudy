package com.yueyang.tt.lambada;

import lombok.Data;

/**
 * @program: IdleStudy
 * @description:
 * @author: qinxiangyang
 * @create: 2020-06-17 10:08
 **/
@Data
public class Result {

    /**
     * 推送渠道
     */
    private int channel;

    /**
     * 渠道返回消息id
     */
    private String msgId;

    /**
     * 渠道返回错误信息
     */
    private String message;

}