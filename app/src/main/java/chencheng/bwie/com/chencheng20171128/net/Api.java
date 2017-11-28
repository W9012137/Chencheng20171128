package chencheng.bwie.com.chencheng20171128.net;

/**
 * Created by dell on 2017/11/28.
 */

public interface Api {
    public static final boolean isonlin=false;
    public static final String DEV="http://120.27.23.105";
    public static final String WOR="";
    public static final String HOST= isonlin?DEV:WOR;
    public static final String LOGIN=HOST+"user/login";//登录
    public static final String REGIS=HOST+"user/reg";//注册
}
