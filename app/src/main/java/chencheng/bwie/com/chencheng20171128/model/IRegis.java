package chencheng.bwie.com.chencheng20171128.model;

import chencheng.bwie.com.chencheng20171128.bean.BaseBean;
import chencheng.bwie.com.chencheng20171128.net.OnNetListener;

/**
 * Created by dell on 2017/11/28.
 */

public interface IRegis {
    public void regis(String phone, String paw, OnNetListener<BaseBean> onNetListener);
}
