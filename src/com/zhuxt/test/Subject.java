package com.zhuxt.test;

/**
 * Created by Administrator on 2015/11/15.
 */
public interface Subject {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

}
