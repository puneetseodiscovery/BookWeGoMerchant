package com.merchant.bookwego.historyActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.bookwego.R;
import com.merchant.bookwego.baseClass.BaseClass;
import com.merchant.bookwego.historyActivity.adapters.HistoryAdapter;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryActivity extends BaseClass implements View.OnClickListener {

    @BindView(R.id.img_back)
    ImageView img_back;

    @BindView(R.id.recyclerview_History)
    RecyclerView recyclerview_History;

    HistoryAdapter historyAdapter;

    @BindView(R.id.title_bar)
    TextView title_bar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ButterKnife.bind(this);
        Initialization();
        EventListner();
    }

        private void Initialization () {
            title_bar.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
            historyAdapter = new HistoryAdapter(this);
            recyclerview_History.setLayoutManager(new LinearLayoutManager(this,
                    LinearLayoutManager.VERTICAL, false));
            recyclerview_History.setAdapter(historyAdapter);

        }

        private void EventListner () {

            img_back.setOnClickListener(this);
        }

        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.img_back:
                    finish();
                    break;
            }
}
}
