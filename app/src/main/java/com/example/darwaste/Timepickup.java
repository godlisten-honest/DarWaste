package com.example.darwaste;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Calendar;

public class Timepickup extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timepickup, container, false);
        setHasOptionsMenu(true);

        getActivity().setTitle("Time Pickup");

        EditText timeedit = view.findViewById(R.id.timepickup_time);
        EditText dateedit = view.findViewById(R.id.timepickup_date);
        Button timebtn = view.findViewById(R.id.timepickup_button);

        dateedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int Year, int Month, int Day) {
                        dateedit.setText( Day + "/" + Month + "/" + Year);
                    }
                },year,month,day);{
                    datePickerDialog.setTitle("Select Date");
                    datePickerDialog.show();
                }
            }
        });

        timeedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog;
                timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Minute) {
                        timeedit.setText( Hour + ":" + Minute);
                    }
                },hour,minute,true);
                {
                    timePickerDialog.setTitle("Select Time");
                    timePickerDialog.show();
                }
            }
        });

        timebtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Fragment secondFrag = new Wastetype();
                Fragment fr = new Confirmation();
                String tm = timeedit.getText().toString();
                String dt = dateedit.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("tm",tm);
                bundle.putString("dt",dt);
//                getParentFragmentManager().setFragmentResult("req",bundle);
                fr.setArguments(bundle);

                FragmentTransaction fn = getActivity().getSupportFragmentManager().beginTransaction();
                fn.replace(R.id.cardmap,secondFrag)
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();

//                dismiss();
            }
        });

        return view;
    }
}