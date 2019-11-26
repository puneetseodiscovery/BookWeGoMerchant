package com.merchant.bookwego.mainActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.merchant.bookwego.CustomerReviews.CustomerReviewsActivity;
import com.merchant.bookwego.R;
import com.merchant.bookwego.baseClass.BaseClass;
import com.merchant.bookwego.contactUsActivity.ContactsUsActivity;
import com.merchant.bookwego.historyActivity.HistoryActivity;
import com.merchant.bookwego.liveChatActivity.LiveChatActivity;
import com.merchant.bookwego.loginActivity.LoginActivity;
import com.merchant.bookwego.mainActivity.fragments.OrdersFragment;
import com.merchant.bookwego.mainActivity.fragments.ReservationsFragment;
import com.merchant.bookwego.profileActivity.ProfileActivity;
import com.merchant.bookwego.utills.Utility;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseClass implements View.OnClickListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;

    @BindView(R.id.menu)
    ImageView menu;

    @BindView(R.id.view_home)
    View view_home;

    @BindView(R.id.view_profile)
    View view_profile;

    @BindView(R.id.view_reviews)
    View view_reviews;

    @BindView(R.id.view_history)
    View view_history;

    @BindView(R.id.view_contactsus)
    View view_contactsus;

    @BindView(R.id.view_livechat)
    View view_livechat;

    @BindView(R.id.view_setting)
    View view_setting;

    @BindView(R.id.view_logout)
    View view_logout;

    @BindView(R.id.relative_home)
    RelativeLayout relative_home;

    @BindView(R.id.relative_profile)
    RelativeLayout relative_profile;

    @BindView(R.id.relative_reviews)
    RelativeLayout relative_reviews;

    @BindView(R.id.relative_history)
    RelativeLayout relative_history;

    @BindView(R.id.relative_contactsus)
    RelativeLayout relative_contactsus;

    @BindView(R.id.relative_livechat)
    RelativeLayout relative_livechat;

    @BindView(R.id.relative_setting)
    RelativeLayout relative_setting;

    @BindView(R.id.relative_logout)
    RelativeLayout relative_logout;

    @BindView(R.id.home)
    TextView home;

    @BindView(R.id.profile)
    TextView profile;

    @BindView(R.id.reviews)
    TextView reviews;

    @BindView(R.id.history)
    TextView history;

    @BindView(R.id.contactsus)
    TextView contactsus;

    @BindView(R.id.livechat)
    TextView livechat;

    @BindView(R.id.setting)
    TextView setting;

    @BindView(R.id.logout)
    TextView logout;

    @BindView(R.id.tv_useremail)
    TextView tv_useremail;

    @BindView(R.id.tv_username)
    TextView tv_username;

    TabLayout tabLayout;
    ViewPager viewPager;

    @BindView(R.id.title_bar)
    TextView title_bar;


    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        Initialization();
        EventListner();
    }


    private void Initialization() {
        title_bar.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

        profile.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
        reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
        history.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
        livechat.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
        contactsus.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
        setting.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
        logout.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));


        tv_useremail.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
        tv_username.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
        view_home.setVisibility(View.VISIBLE);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReservationsFragment(), "Reservations");
        adapter.addFragment(new OrdersFragment(), "Orders");
        viewPager.setAdapter(adapter);
    }

    private void EventListner() {

        menu.setOnClickListener(this);

        relative_home.setOnClickListener(this);
        relative_profile.setOnClickListener(this);
        relative_reviews.setOnClickListener(this);
        relative_history.setOnClickListener(this);
        relative_contactsus.setOnClickListener(this);
        relative_livechat.setOnClickListener(this);
        relative_setting.setOnClickListener(this);
        relative_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()) {

            case R.id.menu:

                openCloseDrawer();

                break;
            case R.id.relative_home:

                view_home.setVisibility(View.VISIBLE);
                view_profile.setVisibility(View.INVISIBLE);
                view_reviews.setVisibility(View.INVISIBLE);
                view_history.setVisibility(View.INVISIBLE);
                view_contactsus.setVisibility(View.INVISIBLE);
                view_livechat.setVisibility(View.INVISIBLE);
                view_setting.setVisibility(View.INVISIBLE);
                view_logout.setVisibility(View.INVISIBLE);


                home.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
                profile.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                history.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                livechat.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                contactsus.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                setting.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                logout.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));


                openCloseDrawer();

                break;
            case R.id.relative_profile:

                view_profile.setVisibility(View.VISIBLE);
                view_home.setVisibility(View.INVISIBLE);
                view_reviews.setVisibility(View.INVISIBLE);
                view_history.setVisibility(View.INVISIBLE);
                view_contactsus.setVisibility(View.INVISIBLE);
                view_livechat.setVisibility(View.INVISIBLE);
                view_setting.setVisibility(View.INVISIBLE);
                view_logout.setVisibility(View.INVISIBLE);

                profile.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
                home.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                history.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                livechat.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                contactsus.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                setting.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                logout.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));


                intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                break;

            case R.id.relative_reviews:

                view_reviews.setVisibility(View.VISIBLE);
                view_profile.setVisibility(View.INVISIBLE);
                view_home.setVisibility(View.INVISIBLE);
                view_history.setVisibility(View.INVISIBLE);
                view_contactsus.setVisibility(View.INVISIBLE);
                view_livechat.setVisibility(View.INVISIBLE);
                view_setting.setVisibility(View.INVISIBLE);
                view_logout.setVisibility(View.INVISIBLE);

                reviews.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
                home.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                profile.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                history.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                livechat.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                contactsus.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                setting.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                logout.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));


                intent = new Intent(MainActivity.this, CustomerReviewsActivity.class);
                startActivity(intent);


                break;
            case R.id.relative_history:

                view_history.setVisibility(View.VISIBLE);
                view_profile.setVisibility(View.INVISIBLE);
                view_home.setVisibility(View.INVISIBLE);
                view_reviews.setVisibility(View.INVISIBLE);
                view_contactsus.setVisibility(View.INVISIBLE);
                view_livechat.setVisibility(View.INVISIBLE);
                view_setting.setVisibility(View.INVISIBLE);
                view_logout.setVisibility(View.INVISIBLE);

                history.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
                home.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                profile.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                livechat.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                contactsus.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                setting.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                logout.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));


                intent = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intent);

                break;
            case R.id.relative_contactsus:

                view_contactsus.setVisibility(View.VISIBLE);
                view_profile.setVisibility(View.INVISIBLE);
                view_home.setVisibility(View.INVISIBLE);
                view_reviews.setVisibility(View.INVISIBLE);
                view_history.setVisibility(View.INVISIBLE);
                view_livechat.setVisibility(View.INVISIBLE);
                view_setting.setVisibility(View.INVISIBLE);
                view_logout.setVisibility(View.INVISIBLE);

                contactsus.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
                home.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                profile.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                history.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                livechat.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                setting.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                logout.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

                intent = new Intent(MainActivity.this, ContactsUsActivity.class);
                startActivity(intent);

                break;
            case R.id.relative_livechat:

                view_livechat.setVisibility(View.VISIBLE);
                view_profile.setVisibility(View.INVISIBLE);
                view_home.setVisibility(View.INVISIBLE);
                view_reviews.setVisibility(View.INVISIBLE);
                view_history.setVisibility(View.INVISIBLE);
                view_contactsus.setVisibility(View.INVISIBLE);
                view_setting.setVisibility(View.INVISIBLE);
                view_logout.setVisibility(View.INVISIBLE);

                livechat.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
                home.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                profile.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                history.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                contactsus.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                setting.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                logout.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

                intent = new Intent(MainActivity.this, LiveChatActivity.class);
                startActivity(intent);

                break;
            case R.id.relative_setting:

                view_setting.setVisibility(View.VISIBLE);
                view_profile.setVisibility(View.INVISIBLE);
                view_home.setVisibility(View.INVISIBLE);
                view_reviews.setVisibility(View.INVISIBLE);
                view_history.setVisibility(View.INVISIBLE);
                view_contactsus.setVisibility(View.INVISIBLE);
                view_livechat.setVisibility(View.INVISIBLE);
                view_logout.setVisibility(View.INVISIBLE);

                setting.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
                home.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                profile.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                history.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                livechat.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                contactsus.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                logout.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

                coomingSoonAlert();

                break;
            case R.id.relative_logout:

                view_logout.setVisibility(View.VISIBLE);
                view_profile.setVisibility(View.INVISIBLE);
                view_home.setVisibility(View.INVISIBLE);
                view_reviews.setVisibility(View.INVISIBLE);
                view_history.setVisibility(View.INVISIBLE);
                view_contactsus.setVisibility(View.INVISIBLE);
                view_livechat.setVisibility(View.INVISIBLE);
                view_setting.setVisibility(View.INVISIBLE);

                logout.setTypeface(Utility.typeFaceForProximaNovaSemiboldText(this));
                profile.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                reviews.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                history.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                livechat.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                contactsus.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                setting.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));
                home.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

                AlertLogoutDialog();

                break;
        }
    }

    private void coomingSoonAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Settings");
        builder.setMessage("Comming Soon !!!")
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    private void AlertLogoutDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("BookWeGo");
        builder.setMessage("Are you sure you want to Logout?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void openCloseDrawer() {

        if (drawer_layout.isDrawerOpen(Gravity.LEFT)) {
            drawer_layout.closeDrawer(Gravity.LEFT);

        } else {
            drawer_layout.openDrawer(Gravity.LEFT);
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }
}
