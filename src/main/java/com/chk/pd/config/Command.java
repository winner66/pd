package com.chk.pd.config;

import org.joda.time.DateTime;

import java.sql.Date;

/**
 * 消息基类
 */
public class Command  implements ICommand{
    private Long id;
//   时间戳
    private Long  time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time.getTime();
    }

    public Command(Long id, Long time) {
        this.id = id;
        this.time = time;
    }
}
