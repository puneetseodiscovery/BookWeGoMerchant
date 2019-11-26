package com.merchant.bookwego.mainActivity.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merchant.bookwego.R;
import com.merchant.bookwego.mainActivity.fragments.adapters.OrderAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrdersFragment extends Fragment {

    Context context;

    @BindView(R.id.recyclerview_Orders)
    RecyclerView recyclerview_Orders;

    OrderAdapter orderAdapter;

    public OrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        ButterKnife.bind(this, view);
        context = this.getContext();

        Initialization();
        EventListner();
        return view;
    }

    private void Initialization() {

        orderAdapter = new OrderAdapter(getActivity());
        recyclerview_Orders.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerview_Orders.setAdapter(orderAdapter);


    }

    private void EventListner() {

    }

}
