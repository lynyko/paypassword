package com.paypassword.yko.paypassword;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Yko on 2016/12/12.
 */

public class KeyboardView extends FrameLayout {
    Context mContext;
    StringBuilder sb = new StringBuilder();
    KeyboardCallback callback;
    public KeyboardView(Context context) {
        this(context, null);
    }

    public KeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_psw_keyboard, null);
        view.findViewById(R.id.tv_0).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_1).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_2).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_3).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_4).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_5).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_6).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_7).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_8).setOnClickListener(numClickListener);
        view.findViewById(R.id.tv_9).setOnClickListener(numClickListener);
        view.findViewById(R.id.ly_back).setOnClickListener(delClickListener);
        addView(view);
    }

    public void setKeyboardListener(KeyboardCallback callback){
        this.callback = callback;
    }

    public void reset(){
        if(sb.length() > 0) {
            sb.delete(0, sb.length());
        }
        if(callback != null){
            callback.keys(sb.toString());
        }
    }

    OnClickListener numClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String num = ((Button)v).getText().toString();
            if(sb.length() < 6) {
                sb.append(num);
            }
            if(callback != null){
                callback.keys(sb.toString());
            }
        }
    };

    OnClickListener delClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if(sb.length() > 0){
                sb.deleteCharAt(sb.length()-1);
            }
            if(callback != null){
                callback.keys(sb.toString());
            }
        }
    };

    public interface KeyboardCallback{
        void keys(String keys);
    }
}
