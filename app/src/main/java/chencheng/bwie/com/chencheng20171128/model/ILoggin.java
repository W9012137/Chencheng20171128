package chencheng.bwie.com.chencheng20171128.model;

import chencheng.bwie.com.chencheng20171128.bean.LogBean;
import chencheng.bwie.com.chencheng20171128.net.OnNetListener;

/**
 * Created by dell on 2017/11/28.
 */

public interface ILoggin {
public void login(String phone, String paw, OnNetListener<LogBean> onNetListener);
}
