package com.yueyang.tt.lambada;

import java.util.List;

public class PushResult {

    /**
     * 返回错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 推送详细结果
     */
    private List<ChannelResult> details;

    private PushResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ChannelResult> getDetails() {
        return details;
    }

    public void setDetails(List<ChannelResult> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "PushResult [code=" + code + ", message=" + message + ", details=" + details + "]";
    }

    public static class ChannelResult {

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

        public ChannelResult(int channel) {
            this.channel = channel;
        }

        public int getChannel() {
            return channel;
        }

        public void setChannel(int channel) {
            this.channel = channel;
        }

        public String getMsgId() {
            return msgId;
        }

        public void setMsgId(String msgId) {
            this.msgId = msgId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "ChannelResult [channel=" + channel + ", msgId=" + msgId + ", message=" + message + "]";
        }

    }

}
