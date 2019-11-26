package com.merchant.bookwego.mainActivity.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.merchant.bookwego.BookingReports.BookingReportsActivity;
import com.merchant.bookwego.R;
import com.merchant.bookwego.historyDetailsActivity.HistoryDetailsActivity;
import com.merchant.bookwego.mainActivity.fragments.adapters.OrderAdapter;
import com.merchant.bookwego.mainActivity.fragments.adapters.ReservationsBookingsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReservationsFragment extends Fragment implements View.OnClickListener {

    Context context;

    @BindView(R.id.recyclerview_booking_status)
    RecyclerView recyclerview_booking_status;

    @BindView(R.id.tv_reports)
    TextView tv_reports;

    ReservationsBookingsAdapter reservationsBookingsAdapter;

    public ReservationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reservations, container, false);
        ButterKnife.bind(this, view);
        context = this.getContext();
        Initialization();
        EventListner();
        return view;

    }


    private void Initialization() {

        reservationsBookingsAdapter = new ReservationsBookingsAdapter(getActivity());
        recyclerview_booking_status.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerview_booking_status.setAdapter(reservationsBookingsAdapter);
    }

    private void EventListner() {
        tv_reports.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_reports:
                Intent intent = new Intent(getActivity(), BookingReportsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
