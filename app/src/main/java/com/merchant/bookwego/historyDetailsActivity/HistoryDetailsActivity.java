package com.merchant.bookwego.historyDetailsActivity;

import android.content.Context;
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
import com.merchant.bookwego.historyDetailsActivity.adapter.HistoryListAdapter;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryDetailsActivity extends BaseClass implements View.OnClickListener {

    @BindView(R.id.img_back)
    ImageView img_back;

    @BindView(R.id.tv_ordername)
    TextView tv_ordername;

    @BindView(R.id.title_bar)
    TextView title_bar;


    @BindView(R.id.recyclerview_HistoryDetails)
    RecyclerView recyclerview_HistoryDetails;
    HistoryListAdapter historyListAdapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_details);

        context=HistoryDetailsActivity.this;

        ButterKnife.bind(this);
        Initialization();
        EventListner();
    }

    private void Initialization() {
        title_bar.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

        tv_ordername.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
        historyListAdapter = new HistoryListAdapter(this);
        recyclerview_HistoryDetails.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerview_HistoryDetails.setAdapter(historyListAdapter);

    }

    private void EventListner() {

        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
