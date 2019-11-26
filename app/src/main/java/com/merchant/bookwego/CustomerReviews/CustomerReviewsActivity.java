package com.merchant.bookwego.CustomerReviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.merchant.bookwego.CustomerReviews.adapters.CustomerReviewsAdapter;
import com.merchant.bookwego.R;
import com.merchant.bookwego.baseClass.BaseClass;
import com.merchant.bookwego.historyActivity.adapters.HistoryAdapter;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerReviewsActivity extends BaseClass implements View.OnClickListener {

    @BindView(R.id.img_back)
    ImageView img_back;

    @BindView(R.id.title_bar)
    TextView title_bar;


    @BindView(R.id.recyclerview_customerReviews)
    RecyclerView recyclerview_customerReviews;

    CustomerReviewsAdapter customerReviewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_reviews);

        ButterKnife.bind(this);
        Initialization();
        EventListner();
    }

    private void Initialization () {
        title_bar.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

        customerReviewsAdapter = new CustomerReviewsAdapter(this);
        recyclerview_customerReviews.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        recyclerview_customerReviews.setAdapter(customerReviewsAdapter);

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
