package com.merchant.bookwego.loginActivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.merchant.bookwego.R;
import com.merchant.bookwego.baseClass.BaseClass;
import com.merchant.bookwego.baseClass.ConnectivityReceiver;
import com.merchant.bookwego.baseClass.MyApp;
import com.merchant.bookwego.forgotPasswordActivity.ForgotPasswordActivity;
import com.merchant.bookwego.mainActivity.MainActivity;
import com.merchant.bookwego.privacyPolicyActivity.PrivacyPolicyActivity;
import com.merchant.bookwego.registerActivity.RegisterActivity;
import com.merchant.bookwego.termConditionActivity.TermConditionActivity;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseClass implements View.OnClickListener {

    @BindView(R.id.edit_usereamil)
    EditText edit_usereamil;

    @BindView(R.id.edit_userpassword)
    EditText edit_userpassword;

    @BindView(R.id.tv_register)
    TextView tv_register;

    @BindView(R.id.tv_term_condition)
    TextView tv_term_condition;

    @BindView(R.id.tv_privacy_policy)
    TextView tv_privacy_policy;

    @BindView(R.id.tv_forgotpassword)
    TextView tv_forgotpassword;

    @BindView(R.id.btn_login)
    TextView btn_login;

    @BindView(R.id.signUp)
    TextView signUp;

    @BindView(R.id.title_bar)
    TextView title_bar;

    @BindView(R.id.progress)
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        Initialization(); // findviewBy Id
        EventListner();
    }


    private void Initialization() {

        title_bar.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

    }

    private void EventListner() {


        tv_register.setOnClickListener(this);
        tv_forgotpassword.setOnClickListener(this);
        tv_term_condition.setOnClickListener(this);
        tv_privacy_policy.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {

            case R.id.tv_register:

                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                overridePendingTransition(0, R.anim.splash_faidout);

                break;

            case R.id.tv_forgotpassword:
                intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                overridePendingTransition(0, R.anim.splash_faidout);


                break;

            case R.id.tv_privacy_policy:
                intent = new Intent(LoginActivity.this, PrivacyPolicyActivity.class);
                startActivity(intent);
                overridePendingTransition(0, R.anim.splash_faidout);


                break;


            case R.id.tv_term_condition:
                intent = new Intent(LoginActivity.this, TermConditionActivity.class);
                startActivity(intent);
                overridePendingTransition(0, R.anim.splash_faidout);


                break;

            case R.id.btn_login:

                //progress.setVisibility(View.VISIBLE);

                if (Utility.checkConnection()){

                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, R.anim.splash_faidout);

                }else {
                    Toast.makeText(this, "Connection failed,Please check your internet connection.", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
