package chencheng.bwie.com.chencheng20171128.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import chencheng.bwie.com.chencheng20171128.bean.BaseBean;
import chencheng.bwie.com.chencheng20171128.net.Api;
import chencheng.bwie.com.chencheng20171128.net.HttpUtils;
import chencheng.bwie.com.chencheng20171128.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dell on 2017/11/28.
 */

public class RegisModel extends BaseModel implements IRegis  {
    @Override
    public void regis(String phone, String paw, final OnNetListener<BaseBean> onNetListener) {
        Map<String,String >map=new HashMap<>();
        map.put("mobile",phone);
        map.put("password",paw);
        HttpUtils.getHttpUtils().doPost(Api.REGIS, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                     String string=response.body().string();
                final BaseBean baseBean = new Gson().fromJson(string, BaseBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(baseBean);
                    }
                });
            }
        });
    }
}
