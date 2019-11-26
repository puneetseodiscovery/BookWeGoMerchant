package com.merchant.bookwego.mainActivity.fragments.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;
import com.merchant.bookwego.R;
import com.merchant.bookwego.utills.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReservationsBookingsAdapter extends RecyclerView.Adapter<ReservationsBookingsAdapter.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;
    boolean onClick = false;
    boolean onClickName = false;


    public ReservationsBookingsAdapter(Context context) {

        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.layout_reservation_list, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
        holder.img_edit_pax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onClick== false){
                    holder.relative_table.setVisibility(View.VISIBLE);
                    holder.img_edit_pax.setImageResource(R.drawable.ic_done);
                    onClick=true;
                }else {
                    holder.relative_table.setVisibility(View.GONE);
                    holder.img_edit_pax.setImageResource(R.drawable.ic_mode_edit);
                    onClick=false;
                }


            }
        });

        holder.img_edit_userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onClickName== false){
                    holder.tv_username_U.setEnabled(true);
                    holder.img_edit_userName.setImageResource(R.drawable.ic_done);
                    onClickName=true;
                }else {
                    holder.tv_username_U.setEnabled(false);
                    holder.img_edit_userName.setImageResource(R.drawable.ic_mode_edit);
                    onClickName=false;
                }


            }
        });

    }

    @Override
    public int getItemCount() {

        return 5;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_username_U)
        EditText tv_username_U;

        @BindView(R.id.img_edit_userName)
        ImageView img_edit_userName;

        @BindView(R.id.img_edit_pax)
        ImageView img_edit_pax;

        @BindView(R.id.relative_table)
        RelativeLayout relative_table;

        public RecyclerViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);
            tv_username_U.setEnabled(false);
        }
    }


}
