package com.qiju.game.car.event;

import com.google.common.eventbus.Subscribe;

/**
 * @Date : 13:50 2019-09-07
 * @Author : qintingyin
 * @Version : 1.0
 */
public class NotionalListener {
    public static NotionalListener instance = new NotionalListener();
    private NotionalListener(){}
    @Subscribe
    public void listener(String s){
        System.out.println("------"+s);
    }
}
