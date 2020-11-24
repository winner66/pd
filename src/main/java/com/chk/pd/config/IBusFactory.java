package com.chk.pd.config;

/**
 * 消息发布者接口
 */
public interface IBusFactory<T> {
    void SendCommand(T command);
}
