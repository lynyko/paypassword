package com.paypassword.yko.paypassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    PasswordView lyPswText;
    KeyboardView lyKeyboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        setTitle("支付密码");
        lyPswText = (PasswordView)findViewById(R.id.ly_psw_text);
        lyKeyboard = (KeyboardView)findViewById(R.id.ly_keyboard);
        lyKeyboard.reset();
        lyKeyboard.setKeyboardListener(keyboardCallback);
    }

    KeyboardView.KeyboardCallback keyboardCallback = new KeyboardView.KeyboardCallback() {
        @Override
        public void keys(String keys) {
            lyPswText.setPassword(keys);
            if(keys.length() >= 6){
                Toast.makeText(MainActivity.this, "你输入的密码为" + keys, Toast.LENGTH_LONG).show();
            }
        }
    };
}
