package com.merchant.bookwego.mainActivity.fragments.adapters;

import android.content.Context;
import android.graphics.Color;
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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;
    boolean onClick=false;


    public OrderAdapter(Context context) {

        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.layout_orders, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.layout_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onClick== false){
                    holder.layout_statusGone.setVisibility(View.VISIBLE);
                    onClick=true;
                }else {
                    holder.layout_statusGone.setVisibility(View.GONE);
                    onClick=false;
                }


            }
        });
    }

    @Override
    public int getItemCount() {

        return 5;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_ordername)
        TextView tv_ordername;

        @BindView(R.id.tv_orderdate)
        TextView tv_orderdate;

        @BindView(R.id.tv_thali_name)
        TextView tv_thali_name;

        @BindView(R.id.tv_thali_price)
        TextView tv_thali_price;

        @BindView(R.id.status)
        TextView status;

        @BindView(R.id.layout_status)
        RelativeLayout layout_status;

        @BindView(R.id.layout_statusGone)
        RelativeLayout layout_statusGone;

        @BindView(R.id.tv_additional_info)
        JustifiedTextView tv_additional_info;



        public RecyclerViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);

            tv_ordername.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            status.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_orderdate.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_thali_name.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_thali_price.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));
            tv_additional_info.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));


        }
    }


}
