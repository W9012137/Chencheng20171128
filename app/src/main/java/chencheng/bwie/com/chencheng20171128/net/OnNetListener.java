package chencheng.bwie.com.chencheng20171128.net;

/**
 * Created by dell on 2017/11/28.
 */

public interface OnNetListener<T> {
    //成功
    public void onSuccess(T t);
    //失败
    public void onFailure(Exception e);
}
