package com.merchant.bookwego.BookingReports.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.merchant.bookwego.BookingReports.BookingModelClass.BookingListModel;
import com.merchant.bookwego.BookingReports.BookingReportsActivity;
import com.merchant.bookwego.R;
import com.merchant.bookwego.historyDetailsActivity.HistoryDetailsActivity;
import com.merchant.bookwego.utills.Utility;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingReportsAdapter extends RecyclerView.Adapter<BookingReportsAdapter.RecyclerViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<BookingListModel> bookingListModelArrayList;
    BookingReportsActivity bookingReportsActivity;

    public BookingReportsAdapter(Context context, List<BookingListModel> bookingListModelArrayList, BookingReportsActivity bookingReportsActivity) {

        this.context = context;
        this.bookingListModelArrayList = bookingListModelArrayList;
        this.bookingReportsActivity = bookingReportsActivity;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflater.inflate(R.layout.layout_bookingreport_list, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

        holder.tv_bookingPeriod.setText(bookingListModelArrayList.get(position).getNane());

        if (bookingListModelArrayList.get(position).getSelectedVaule().equals("1")) {

            holder.tv_bookingPeriod.setTextColor(context.getResources().getColor(R.color.colorTextWhite));
            holder.layout_background.setBackground(context.getResources().getDrawable(R.drawable.green_bg));
        } else {
            holder.tv_bookingPeriod.setTextColor(context.getResources().getColor(R.color.colorTextDarkGrey));
            //holder.layout_background.setBackground(context.getResources().getDrawable(R.drawable.transprnt_bg));
            holder.layout_background.setBackgroundResource(android.R.color.transparent);

        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < bookingListModelArrayList.size(); i++) {

                    bookingListModelArrayList.get(i).setSelectedVaule("0");
                }

                bookingListModelArrayList.get(position).setSelectedVaule("1");
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {

        return bookingListModelArrayList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_bookingPeriod)
        TextView tv_bookingPeriod;

        @BindView(R.id.layout_background)
        RelativeLayout layout_background;


        public RecyclerViewHolder(View view) {
            super(view);

            ButterKnife.bind(this, view);

            tv_bookingPeriod.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(context));

        }
    }

}
