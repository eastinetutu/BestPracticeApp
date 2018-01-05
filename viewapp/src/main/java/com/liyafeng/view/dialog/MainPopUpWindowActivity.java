package com.liyafeng.view.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import com.liyafeng.view.R;

public class MainPopUpWindowActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Button
     */
    private Button mButton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pop_up_window);
        initView();


    }

    private void initView() {
        mButton7 = (Button) findViewById(R.id.button7);
        mButton7.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button7:

                final PopupWindow popupWindow = new PopupWindow(this);
                View view = LayoutInflater.from(this).inflate(R.layout.popup, null);
                popupWindow.setContentView(view);

                popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
                popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

                popupWindow.setOutsideTouchable(true);
                popupWindow.setTouchable(true);

//                popupWindow.setAnimationStyle(R.style.);

                popupWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#88000000")));
//                popupWindow.showAsDropDown(mButton7, 0, -mButton7.getHeight());//在view下方

                //如果是0,0的话，默认是在这个view（anchor锚）的左下角作为起始点
                //Gravity.RIGHT代表在view的右下角开始 这个是api19开始支持


                //这种显示方式如果是和view无关，里面只是为了获得token
                popupWindow.showAtLocation(mButton7,Gravity.CENTER,100,0);
                //这个x y的位置是先计算重力所在的位置，然后再以那个位置为左上角，x,y是相对位置


                break;
        }
    }
}