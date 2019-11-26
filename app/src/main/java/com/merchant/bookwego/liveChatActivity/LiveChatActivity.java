package com.merchant.bookwego.liveChatActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.bookwego.R;
import com.merchant.bookwego.baseClass.BaseClass;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LiveChatActivity extends BaseClass implements View.OnClickListener {

    @BindView(R.id.img_back)
    ImageView img_back;

    @BindView(R.id.title_bar)
    TextView title_bar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_chat);

        ButterKnife.bind(this);
        Initialization();
        EventListner();

    }


    private void Initialization() {
        title_bar.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

    }

    private void EventListner() {

        img_back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {

            case R.id.img_back:

                Animation animation01 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_click);
                img_back.startAnimation(animation01);
                finish();
                overridePendingTransition(R.anim.main_faidin, R.anim.main_faidout);
                break;

        }

    }

}
