package com.merchant.bookwego.CustomerReviews.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;
import com.merchant.bookwego.R;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomerReviewsAdapter extends RecyclerView.Adapter<CustomerReviewsAdapter.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;
    boolean onClick = false;


    public CustomerReviewsAdapter(Context context) {

        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.layout_reviews, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.tv_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onClick == false) {
                    holder.layout_replay.setVisibility(View.VISIBLE);
                    onClick = true;
                } else {
                    holder.layout_replay.setVisibility(View.GONE);
                    onClick = false;
                }


            }
        });
    }

    @Override
    public int getItemCount() {

        return 5;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_replay)
        TextView tv_replay;

        @BindView(R.id.tv_ownerName)
        TextView tv_ownerName;

        @BindView(R.id.tv_userName)
        TextView tv_userName;

        @BindView(R.id.tv_reviews)
        TextView tv_reviews;

        @BindView(R.id.tv_ownerReviews)
        TextView tv_ownerReviews;

        @BindView(R.id.tv_time)
        TextView tv_time;

        @BindView(R.id.tv_times)
        TextView tv_times;

        @BindView(R.id.layout_replay)
        RelativeLayout layout_replay;


        public RecyclerViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);

            tv_replay.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));

            tv_ownerReviews.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_ownerName.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_userName.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(context));
            tv_time.setTypeface(Utility.typeFaceForProximaNovaRegulerText(context));
            tv_times.setTypeface(Utility.typeFaceForProximaNovaRegulerText(context));


        }
    }


}
