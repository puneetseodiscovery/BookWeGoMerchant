package com.merchant.bookwego.registerActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.merchant.bookwego.R;
import com.merchant.bookwego.baseClass.BaseClass;
import com.merchant.bookwego.loginActivity.LoginActivity;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends BaseClass implements View.OnClickListener {

    @BindView(R.id.btn_next)
    Button btn_next;

    @BindView(R.id.edit_firstName)
    EditText edit_firstName;

    @BindView(R.id.edit_lastName)
    EditText edit_lastName;

    @BindView(R.id.edit_email)
    EditText edit_email;

    @BindView(R.id.edit_phone)
    EditText edit_phone;

    @BindView(R.id.edit_ageorbithdate)
    EditText edit_ageorbithdate;

    @BindView(R.id.edit_gender)
    EditText edit_gender;

    @BindView(R.id.edit_address)
    EditText edit_address;

    @BindView(R.id.edit_citizinship)
    EditText edit_citizinship;

    @BindView(R.id.title_bar)
    TextView title_bar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        ButterKnife.bind(this);

        Initialization();
        EventListner();
    }


    private void Initialization() {

        title_bar.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
    }

    private void EventListner() {
        btn_next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_next:

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                overridePendingTransition(0, R.anim.splash_faidout);

                break;
        }

    }
}
