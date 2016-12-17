package com.paypassword.yko.paypassword;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yko on 2016/12/12.
 */

public class PasswordView extends FrameLayout {
    Context mContext;
    LinearLayout mView;
    private String password = "";
    List<ImageView> pswViewList = new ArrayList<>();

    public PasswordView(Context context) {
        this(context, null);
    }

    public PasswordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    private void initView(){
        mView = (LinearLayout)LayoutInflater.from(mContext).inflate(R.layout.layout_pay_psw, null);
        LinearLayout lyContainer = (LinearLayout)mView.findViewById(R.id.ly_container);
        for(int i = 0; i < lyContainer.getChildCount(); i++){
            View v = lyContainer.getChildAt(i);
            if(v instanceof ImageView){
                pswViewList.add((ImageView)v);
            }
        }
        addView(mView);
    }

    public void setPassword(String psw){
        for(int i = 0; i < pswViewList.size(); i++){
            ImageView iv = pswViewList.get(i);
            if(i >= psw.length()){
                iv.setVisibility(INVISIBLE);
            } else {
                iv.setVisibility(VISIBLE);
            }
        }
    }
}
