package com.example.darwaste;

//import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
//import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.format.DateFormat;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;


import java.util.Calendar;
import java.util.List;

public class Calendarr extends Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    TextView textView, txtsave;
    Button button, save;
    int day, month, year, hour, minute,second;
    int myday, myMonth, myYear, myHour, myMinute;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_calendar, container, false);
        setHasOptionsMenu(true);

        getActivity().setTitle("Histories");

        textView = view.findViewById(R.id.textPick);
        button = view.findViewById(R.id.btnPick);

//        lc = view.findViewById(R.id.lc);
//        Bundle bundle = this.getArguments();
//        if(bundle != null){
//            txtsave.setText(String.valueOf(bundle.getString("date_time")));
//        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getFragmentManager();
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                        Calendarr.this,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show(fm, "Datepickerdialog");
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        FragmentManager fm = getActivity().getFragmentManager();
        DatePickerDialog datePickerDialog = (DatePickerDialog) fm.findFragmentByTag("Datepickerdialog");
        TimePickerDialog timePickerDialog = (TimePickerDialog) fm.findFragmentByTag("Timepickerdialog");
        if(datePickerDialog != null) datePickerDialog.setOnDateSetListener(this);
        if(timePickerDialog != null) timePickerDialog.setOnTimeSetListener(this);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int month, int day) {
        FragmentManager fm = getActivity().getFragmentManager();
        myYear = year;
        myday = day;
        myMonth = month;
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
//        int second = c.get(Calendar.SECOND);
        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(Calendarr.this, hour, minute,DateFormat.is24HourFormat(getActivity()));
        timePickerDialog.show(fm,"Timepickerdialog");
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hour, int minute, int second) {
        String date = "Your next time for pickup is: \n "+myday+"/"+myMonth+"/"+myYear+"  "+hour+":"+minute;
        String test = "We test here";
        textView.setText(date);
//        Fragment fr = new Calendarr();
//        Bundle bundle = new Bundle();
//        String date_time = textView.getText().toString();
//        bundle.putString("date_time",date_time);
//        fr.setArguments(bundle);
    }

}