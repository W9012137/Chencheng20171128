package chencheng.bwie.com.chencheng20171128.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import chencheng.bwie.com.chencheng20171128.R;

/**
 * Created by dell on 2017/11/28.
 */

public class Other extends AppCompatActivity implements View.OnClickListener {
    /**
     * 请输入手机号
     */
    private EditText mPhone;
    /**
     * 请输入密码
     */
    private EditText mPaw;
    /**
     * 立即注册
     */
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regis);
        initView();
    }

    private void initView() {
        mPhone = (EditText) findViewById(R.id.phone);
        mPaw = (EditText) findViewById(R.id.paw);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                break;
        }
    }
}
