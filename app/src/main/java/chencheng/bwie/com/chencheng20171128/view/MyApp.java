package chencheng.bwie.com.chencheng20171128.view;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by dell on 2017/11/28.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
