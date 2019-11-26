package com.merchant.bookwego.BookingReports;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.merchant.bookwego.BookingReports.BookingModelClass.BookingListModel;
import com.merchant.bookwego.BookingReports.adapters.BookingReportsAdapter;
import com.merchant.bookwego.CustomerReviews.adapters.CustomerReviewsAdapter;
import com.merchant.bookwego.R;
import com.merchant.bookwego.baseClass.BaseClass;
import com.merchant.bookwego.utills.Utility;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingReportsActivity extends BaseClass implements View.OnClickListener, OnChartGestureListener, OnChartValueSelectedListener {

    @BindView(R.id.img_back)
    ImageView img_back;

    @BindView(R.id.piechart)
    PieChart piechart;

    @BindView(R.id.linechart)
    LineChart linechart;

    @BindView(R.id.bookingReportList)
    RecyclerView bookingReportList;

    @BindView(R.id.tv_clickUnclik)
    TextView tv_clickUnclik;

    @BindView(R.id.layout_chart)
    RelativeLayout layout_chart;

    @BindView(R.id.layout_linechart)
    RelativeLayout layout_linechart;

    boolean onClick = false;

    List<BookingListModel> bookingListModelArrayList = new ArrayList<>();
    BookingListModel bookingListModel;
    BookingReportsAdapter bookingReportsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_reports);
        ButterKnife.bind(this);

        Initialization();
        EventListeners();
    }


    private void Initialization() {

        tv_clickUnclik.setTypeface(Utility.typeFaceForProximaNovaRegulerText(this));

        bookingReportsAdapter = new BookingReportsAdapter(this, bookingListModelArrayList, BookingReportsActivity.this);
        bookingReportList.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false));
        bookingReportList.setAdapter(bookingReportsAdapter);

        prepareCategoriesData();

        piechart.setUsePercentValues(true);

        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(8, 0));
        yvalues.add(new Entry(15, 1));
        yvalues.add(new Entry(12, 2));
        yvalues.add(new Entry(25, 3));

        PieDataSet dataSet = new PieDataSet(yvalues, "");

        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("Attended");
        xVals.add("Cancelled");
        xVals.add("Upcomming");
        xVals.add("No Show");


        PieData data = new PieData(xVals, dataSet);
        // In Percentage term
        data.setValueFormatter(new PercentFormatter());
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));
        piechart.setData(data);
        piechart.setDescription("");

        piechart.setDrawHoleEnabled(true);
        piechart.setTransparentCircleRadius(25f);
        piechart.setHoleRadius(25f);
        piechart.getLegend().setEnabled(false); // for hiding square on below graph
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);

        piechart.setOnChartValueSelectedListener(this);
        piechart.animateXY(2000, 2000);


        /*+++++++++++++++++++++++++++++++++++++++*/

        linechart.setOnChartGestureListener(this);
        linechart.setOnChartValueSelectedListener(this);
        linechart.setDrawGridBackground(false);

        // add data
        setData();

        // get the legend (only possible after setting data)
        Legend l = linechart.getLegend();

        // modify the legend ...
        // l.setPosition(Legend.LegendPosition.LEFT_OF_CHART);
        l.setForm(Legend.LegendForm.LINE);

        // no description text
        linechart.setDescription("");
        linechart.setNoDataTextDescription("You need to provide data for the chart.");

        // enable touch gestures
        linechart.setTouchEnabled(true);

        // enable scaling and dragging
        linechart.setDragEnabled(true);
        linechart.setScaleEnabled(true);
        // mChart.setScaleXEnabled(true);
        // mChart.setScaleYEnabled(true);

        LimitLine upper_limit = new LimitLine(60f, "Upper Limit");
        upper_limit.setLineWidth(4f);
        upper_limit.enableDashedLine(10f, 10f, 0f);
        upper_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        upper_limit.setTextSize(10f);

        LimitLine lower_limit = new LimitLine(-30f, "Lower Limit");
        lower_limit.setLineWidth(4f);
        lower_limit.enableDashedLine(10f, 10f, 0f);
        lower_limit.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
        lower_limit.setTextSize(10f);

        YAxis leftAxis = linechart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
      /*  leftAxis.addLimitLine(upper_limit);
        leftAxis.addLimitLine(lower_limit);*/
        leftAxis.setAxisMaxValue(60f);
        leftAxis.setAxisMinValue(0f);
        //leftAxis.setYOffset(20f);
        leftAxis.enableGridDashedLine(10f, 10f, 0f);
        leftAxis.setDrawZeroLine(false);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        linechart.getAxisRight().setEnabled(false);

        //mChart.getViewPortHandler().setMaximumScaleY(2f);
        //mChart.getViewPortHandler().setMaximumScaleX(2f);

        linechart.animateX(5000, Easing.EasingOption.EaseInOutQuart);

        //  dont forget to refresh the drawing
        linechart.invalidate();

    }

    private void EventListeners() {
        tv_clickUnclik.setOnClickListener(this);
        img_back.setOnClickListener(this);
    }

    private ArrayList<String> setXAxisValues() {
        ArrayList<String> xVals = new ArrayList<String>();
        xVals.add("Sun");
        xVals.add("Mon");
        xVals.add("Tue");
        xVals.add("Wed");
        xVals.add("Thur");
        xVals.add("Fri");
        xVals.add("Sat");
        return xVals;
    }

    private ArrayList<Entry> setYAxisValues() {
        ArrayList<Entry> yVals = new ArrayList<Entry>();
        yVals.add(new Entry(10, 0));
        yVals.add(new Entry(15, 1));
        yVals.add(new Entry(20f, 2));
        yVals.add(new Entry(35, 3));
        yVals.add(new Entry(45f, 4));

        return yVals;
    }

    private void setData() {

        ArrayList<String> xVals = setXAxisValues();

        ArrayList<Entry> yVals = setYAxisValues();

        LineDataSet set1;

        // create a dataset and give it a type
        set1 = new LineDataSet(yVals, "DataSet 1");

        set1.setFillAlpha(110);
        // set1.setFillColor(Color.RED);

        // set the line to be drawn like this "- - - - - -"
        //   set1.enableDashedLine(10f, 5f, 0f);
        // set1.enableDashedHighlightLine(10f, 5f, 0f);
        set1.setColor(Color.GREEN);
        set1.setCircleColor(Color.GREEN);
        set1.setLineWidth(1f);
        set1.setCircleRadius(3f);
        set1.setDrawCircleHole(false);
        set1.setValueTextSize(9f);
        set1.setDrawFilled(true);

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add(set1); // add the datasets

        // create a data object with the datasets
        LineData data = new LineData(xVals, dataSets);

        // set data
        linechart.setData(data);
    }


    private void prepareCategoriesData() {

        bookingListModel = new BookingListModel("1", "Today");

        bookingListModelArrayList.add(bookingListModel);

        bookingListModel = new BookingListModel("2", "This Week");
        bookingListModelArrayList.add(bookingListModel);

        bookingListModel = new BookingListModel("3", "Next Week");
        bookingListModelArrayList.add(bookingListModel);

        bookingListModel = new BookingListModel("4", "This Month");
        bookingListModelArrayList.add(bookingListModel);

        bookingListModel = new BookingListModel("5", "Customized Dates");
        bookingListModelArrayList.add(bookingListModel);

        bookingReportsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.img_back:
                finish();
                break;

            case R.id.tv_clickUnclik:
                if (onClick==false){
                    layout_chart.setVisibility(View.VISIBLE);
                    layout_linechart.setVisibility(View.GONE);
                    onClick=true;
                }else {
                    layout_chart.setVisibility(View.GONE);
                    layout_linechart.setVisibility(View.VISIBLE);
                    onClick=false;
                }
                break;
        }
    }


    @Override
    public void onChartGestureStart(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.i("Gesture", "START, x: " + me.getX() + ", y: " + me.getY());
    }

    @Override
    public void onChartGestureEnd(MotionEvent me, ChartTouchListener.ChartGesture lastPerformedGesture) {
        Log.i("Gesture", "END, lastGesture: " + lastPerformedGesture);

        // un-highlight values after the gesture is finished and no single-tap
        if (lastPerformedGesture != ChartTouchListener.ChartGesture.SINGLE_TAP)
            // or highlightTouch(null) for callback to onNothingSelected(...)
            linechart.highlightValues(null);
    }

    @Override
    public void onChartLongPressed(MotionEvent me) {
        Log.i("LongPress", "Chart longpressed.");
    }

    @Override
    public void onChartDoubleTapped(MotionEvent me) {
        Log.i("DoubleTap", "Chart double-tapped.");
    }

    @Override
    public void onChartSingleTapped(MotionEvent me) {
        Log.i("SingleTap", "Chart single-tapped.");
    }

    @Override
    public void onChartFling(MotionEvent me1, MotionEvent me2, float velocityX, float velocityY) {
        Log.i("Fling", "Chart flinged. VeloX: "
                + velocityX + ", VeloY: " + velocityY);
    }

    @Override
    public void onChartScale(MotionEvent me, float scaleX, float scaleY) {
        Log.i("Scale / Zoom", "ScaleX: " + scaleX + ", ScaleY: " + scaleY);
    }

    @Override
    public void onChartTranslate(MotionEvent me, float dX, float dY) {
        Log.i("Translate / Move", "dX: " + dX + ", dY: " + dY);
    }

    @Override
    public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getVal() + ", xIndex: " + e.getXIndex()
                        + ", DataSet index: " + dataSetIndex);


        Log.i("Entry selected", e.toString());
        Log.i("LOWHIGH", "low: " + linechart.getLowestVisibleXIndex()
                + ", high: " + linechart.getHighestVisibleXIndex());

        Log.i("MIN MAX", "xmin: " + linechart.getXChartMin()
                + ", xmax: " + linechart.getXChartMax()
                + ", ymin: " + linechart.getYChartMin()
                + ", ymax: " + linechart.getYChartMax());
    }

    @Override
    public void onNothingSelected() {

        Log.i("PieChart", "nothing selected");

    }

}
