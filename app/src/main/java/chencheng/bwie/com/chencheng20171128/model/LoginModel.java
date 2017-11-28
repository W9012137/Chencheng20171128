package chencheng.bwie.com.chencheng20171128.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import chencheng.bwie.com.chencheng20171128.bean.LogBean;
import chencheng.bwie.com.chencheng20171128.net.Api;
import chencheng.bwie.com.chencheng20171128.net.HttpUtils;
import chencheng.bwie.com.chencheng20171128.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dell on 2017/11/28.
 */

public class LoginModel extends BaseModel implements ILoggin {
    @Override
    public void login(String phone, String paw, final OnNetListener<LogBean> onNetListener) {
        Map<String,String> map=new HashMap<>();
        map.put("mobile",phone);
        map.put("password",paw);
        HttpUtils.getHttpUtils().doPost(Api.LOGIN, map, new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailure(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                        String string=response.body().string();
                final LogBean logBean = new Gson().fromJson(string, LogBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(logBean);
                    }
                });
            }
        });
    }
}
