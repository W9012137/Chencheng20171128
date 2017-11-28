package chencheng.bwie.com.chencheng20171128.persenter;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import chencheng.bwie.com.chencheng20171128.bean.LogBean;
import chencheng.bwie.com.chencheng20171128.model.ILoggin;
import chencheng.bwie.com.chencheng20171128.model.IRegis;
import chencheng.bwie.com.chencheng20171128.model.LoginModel;
import chencheng.bwie.com.chencheng20171128.model.RegisModel;
import chencheng.bwie.com.chencheng20171128.net.OnNetListener;
import chencheng.bwie.com.chencheng20171128.view.IMActivity;

/**
 * Created by dell on 2017/11/28.
 */

public class MainPresnetre {
    private IMActivity iMainActivity;
    private final ILoggin iLoginModel;
    private final IRegis iRegisterModel;


    public MainPresnetre(IMActivity  iMainActivity) {
        this.iMainActivity = iMainActivity;
        iLoginModel = new LoginModel();
        iRegisterModel = new RegisModel();
    }


    public void login() {
        String account = iMainActivity.getphone();
        String pwd = iMainActivity.getpaw();
        //判断账号密码是否正确
        if (checkAccount(account) && checkPwd(pwd)) {
            //去调用model，进行登陆
            iLoginModel.login(account, pwd, new OnNetListener<LogBean>() {
                @Override
                public void onSuccess(LogBean loginBean) {
                    //保存登陆成功后的数据，可以保存到SP,也可以保存到数据库
                    iMainActivity.Show(loginBean.getMsg());
                    //跳转到分类界面

                }


                @Override
                public void onFailure(Exception e) {


                }
            });
        }


    }


    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iMainActivity.Show("请输入密码");
            return false;
        }


        if (pwd.length() != 6) {
            iMainActivity.Show("请输入6位密码");
            return false;
        }
        return true;
    }
    /**
     * 验证手机号是否正确
     *
     * @param account
     */
    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            //给用户提示，输入的账号不能为空
            iMainActivity.Show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iMainActivity.Show("请输入正确的手机号");
            return false;
        }
        return true;
    }
    /*
 判断是否是手机号
  */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }





}