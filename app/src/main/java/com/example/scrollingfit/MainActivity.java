package com.example.scrollingfit;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private Button button;
    private TextView t1_TotalCal;

    private TextView t2_ConCal;
    private EditText e2_ConCal;

    private TextView t3_BurCal;
    private EditText e3_BurCal;

    private TextView t4_steps;
    private EditText e4_steps;

    private TextView t5_water;
    private EditText e5_water;
    //........................................................................................................................................


    //........................................................................................................................................
    BarChart CalBarChart;
    BarChart StepBarChart;
    BarChart WaterBarChart;
    //........................................................................................................................................
    BarData CalBarData;
    BarData StepBarData;
    BarData WaterBarData;
    //........................................................................................................................................
    BarDataSet CalBarDataSet;
    BarDataSet StepBarDataSet;
    BarDataSet WaterBarDataSet;
    //........................................................................................................................................
    ArrayList CalBarEntriesArrayList;
    ArrayList StepBarEntriesArrayList;
    ArrayList WaterBarEntriesArrayList;

    //........................................................................................................................................
    ArrayList <Integer> CalInputBarList = new ArrayList<Integer>();

    //........................................................................................................................................
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //........................................................................................................................................

        button = findViewById(R.id.button_input_box);

        t1_TotalCal = findViewById(R.id.change_cal_elem);

        t2_ConCal = findViewById(R.id.change_consm_elem);
        e2_ConCal = findViewById(R.id.consumed_head_input);

        t3_BurCal = findViewById(R.id.change_burnt_elem);
        e3_BurCal = findViewById(R.id.burnt_head_input);

        t4_steps = findViewById(R.id.change_step_elem);
        e4_steps = findViewById(R.id.steps_head_input);

        t5_water = findViewById(R.id.change_water_elem);
        e5_water = findViewById(R.id.water_head_input);
        //........................................................................................................................................
        getCalBarEntries();
        CalBarChart = findViewById(R.id.Calorie_chart);
        CalBarDataSet = new BarDataSet(CalBarEntriesArrayList, "Calorie Bar");
        CalBarData = new BarData(CalBarDataSet);
        CalBarChart.setData(CalBarData);
        CalBarDataSet.setValueTextColor(Color.rgb(255, 255, 255));
        CalBarDataSet.setColor(Color.rgb(0, 151, 167), Color.rgb(94, 193, 184));
        CalBarDataSet.setValueTextSize(16f);
        CalBarChart.getDescription().setEnabled(false);
        CalBarChart.setVisibleXRangeMaximum(7);
        //........................................................................................................................................
        StepBarChart = findViewById(R.id.Steps_chart);
        getStepBarEntries();
        StepBarDataSet = new BarDataSet(StepBarEntriesArrayList, "Steps Bar");
        StepBarData = new BarData(StepBarDataSet);
        StepBarChart.setData(StepBarData);
        StepBarData.setValueTextColor(Color.rgb(255, 255, 255));
        StepBarDataSet.setColor(Color.rgb(0, 151, 167), Color.rgb(94, 193, 184));
        StepBarDataSet.setValueTextSize(16f);
        StepBarChart.getDescription().setEnabled(false);
        StepBarChart.setVisibleXRangeMaximum(7);
        //........................................................................................................................................
        WaterBarChart = findViewById(R.id.Water_chart);
        getWaterBarEntries();
        WaterBarDataSet = new BarDataSet(WaterBarEntriesArrayList, "Steps Bar");
        WaterBarData = new BarData(WaterBarDataSet);
        WaterBarChart.setData(WaterBarData);
        WaterBarData.setValueTextColor(Color.rgb(255, 255, 255));
        WaterBarDataSet.setColor(Color.rgb(0, 151, 167), Color.rgb(94, 193, 184));
        WaterBarDataSet.setValueTextSize(16f);
        WaterBarChart.getDescription().setEnabled(false);
        WaterBarChart.setVisibleXRangeMaximum(7);
        //........................................................................................................................................

        button.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "LOL it works", Toast.LENGTH_SHORT).show();
//........................................................................................................................................
            String s2_ConCal = e2_ConCal.getText().toString();
            int i2_ConCal = Integer.parseInt(s2_ConCal);
            int set1_conCal = i2_ConCal;
            if (e2_ConCal.getText().toString().trim().length() > 0)
            {
                t2_ConCal.setText(String.valueOf(set1_conCal));
            }
//........................................................................................................................................
            String s3_BurCal = e3_BurCal.getText().toString();
            int i3_BurCal = Integer.parseInt(s3_BurCal);
            int set2_burCal = i3_BurCal;
            t3_BurCal.setText(String.valueOf(set2_burCal));
//........................................................................................................................................
            int TotalCal = set1_conCal - set2_burCal;
            if (e2_ConCal.getText().toString().trim().length() > 0 && e3_BurCal.getText().toString().trim().length() > 0)
            {
                t1_TotalCal.setText(String.valueOf(TotalCal));
            }
//........................................................................................................................................
            String s4_steps = e4_steps.getText().toString();
            int i4_steps = Integer.parseInt(s4_steps);
            int set3_steps = i4_steps;
            if (e3_BurCal.getText().toString().trim().length()>0)
            {
                t4_steps.setText(String.valueOf(set3_steps));
            }
//........................................................................................................................................
            String s5_water = e5_water.getText().toString();
            int i5_water = Integer.parseInt(s5_water);
            int set4_water = i5_water;
            if (e5_water.getText().toString().trim().length()>0)
            {
                t5_water.setText(String.valueOf(set4_water + "L"));
            }
        });}
//........................................................................................................................................

    public void getCalBarEntries()
    {
        CalBarEntriesArrayList = new ArrayList<>();
        int[] CalArr = {0,1,2,3,4,5,6,7,8,9};
        for (int i=0;i>=60;i++)
        {
            CalBarEntriesArrayList.add(new BarEntry(1,CalArr[i]));
        }
    }

    public void getStepBarEntries() {
        StepBarEntriesArrayList = new ArrayList<>();
        StepBarEntriesArrayList.add(new BarEntry(1f, 50));
        StepBarEntriesArrayList.add(new BarEntry(2f, 50));
        StepBarEntriesArrayList.add(new BarEntry(3f, 50));
        StepBarEntriesArrayList.add(new BarEntry(4f, 50));
        StepBarEntriesArrayList.add(new BarEntry(5f, 50));
        StepBarEntriesArrayList.add(new BarEntry(6f, 50));
        StepBarEntriesArrayList.add(new BarEntry(7f, 50));
        StepBarEntriesArrayList.add(new BarEntry(8f, 50));
        StepBarEntriesArrayList.add(new BarEntry(9f, 50));
        StepBarEntriesArrayList.add(new BarEntry(10f, 50));
    }

    public void getWaterBarEntries() {
        WaterBarEntriesArrayList = new ArrayList<>();
        WaterBarEntriesArrayList.add(new BarEntry(1f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(2f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(3f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(4f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(5f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(6f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(7f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(8f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(9f, 50));
        WaterBarEntriesArrayList.add(new BarEntry(10f, 50));
    }
}

