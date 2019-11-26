package com.merchant.bookwego.historyDetailsActivity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.merchant.bookwego.R;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;


    public HistoryListAdapter(Context context) {

        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.layout_history_details, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {

        return 5;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_date)
        TextView tv_date;

        @BindView(R.id.tv_total_rating)
        TextView tv_total_rating;

        @BindView(R.id.tv_username_U)
        TextView tv_username_U;

        @BindView(R.id.tv_code_U)
        TextView tv_code_U;

        @BindView(R.id.tv_upcomming_U)
        TextView tv_upcomming_U;

        @BindView(R.id.tv_username_C)
        TextView tv_username_C;

        @BindView(R.id.tv_code_C)
        TextView tv_code_C;

        @BindView(R.id.tv_upcomming_C)
        TextView tv_upcomming_C;

        @BindView(R.id.tv_orderdate_U)
        TextView tv_orderdate_U;

        @BindView(R.id.tv_starttime_U)
        TextView tv_starttime_U;

        @BindView(R.id.tv_orderdate_C)
        TextView tv_orderdate_C;

        @BindView(R.id.tv_starttime_C)
        TextView tv_starttime_C;

        public RecyclerViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);

            tv_date.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_total_rating.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_username_U.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_code_U.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_date.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_upcomming_U.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_username_C.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_code_C.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_upcomming_C.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));

            tv_orderdate_U.setTypeface(Utility.typeFaceForProximaNovaRegulerText(context));
            tv_starttime_U.setTypeface(Utility.typeFaceForProximaNovaRegulerText(context));
            tv_orderdate_C.setTypeface(Utility.typeFaceForProximaNovaRegulerText(context));
            tv_starttime_C.setTypeface(Utility.typeFaceForProximaNovaRegulerText(context));

        }
    }


}
