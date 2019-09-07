package com.qiju.game.car.event;

import com.google.common.eventbus.EventBus;

/**
 * @Date : 13:47 2019-09-07
 * @Author : qintingyin
 * @Version : 1.0
 */
public class EventTest {
    private EventBus eventBus = new EventBus();

    public void register(){
        eventBus.register(NotionalListener.instance);
    }

    public void unRegister(){
        eventBus.unregister(NotionalListener.instance);
    }

    public void post(String s){
        eventBus.post(s);
    }

    public static void main(String[] args) {
        EventTest et = new EventTest();
        et.register();
        et.post("003435");
        et.unRegister();
        et.post("0908");
    }
}
