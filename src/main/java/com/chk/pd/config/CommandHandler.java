package com.chk.pd.config;

/**
 * 消息处理基类
 */
public   abstract class CommandHandler<T> implements  ICommandHandler<T> {
    public abstract void  CommandHandle(T t);
}
