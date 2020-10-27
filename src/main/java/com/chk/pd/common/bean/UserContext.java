package com.chk.pd.common.bean;

import com.chk.pd.common.vo.User;

public class UserContext {
    private static final ThreadLocal<User> holder = new ThreadLocal<>();

    public static void set(User user) {
        holder.set(user);
    }

    public static User get() {
        return holder.get();
    }

    public static void remove() {
        holder.remove();
    }
}
