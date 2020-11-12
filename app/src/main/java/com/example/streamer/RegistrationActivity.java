package com.example.streamer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity {

    private ImageView imgDatePicker;
    private TextView txtDate;
    int year, month, dayOfMonth;
    Calendar calendar;
    DatePickerDialog datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();
        initCalender();

    }

    private void initCalender(){

        imgDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePicker = new DatePickerDialog(RegistrationActivity.this,new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
                        txtDate.setText(day + "/" + (month + 1) + "/" + year);
                    }
                }, year, month, dayOfMonth);
                datePicker.show();
            }
        });

    }

    private void initView(){
        imgDatePicker = findViewById(R.id.datePicker);
        txtDate = findViewById(R.id.txtDate);
    }
}