package com.zlikun.spring.profile;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 18:55
 */
public class ProfileBean {

    private String message ;

    public ProfileBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
