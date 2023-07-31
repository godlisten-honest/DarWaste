package com.example.darwaste;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class Confirmation extends BottomSheetDialogFragment {
    TextView location, date, time, waste1, waste2, waste3, waste4, waste5, waste6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirmation, container, false);

        location = view.findViewById(R.id.conf_location);
        date = view.findViewById(R.id.conf_date);
        time = view.findViewById(R.id.conf_time);
        waste1 = view.findViewById(R.id.conf_wastetype1);
        waste2 = view.findViewById(R.id.conf_wastetype2);
        waste3 = view.findViewById(R.id.conf_wastetype3);
        waste4 = view.findViewById(R.id.conf_wastetype4);
        waste5 = view.findViewById(R.id.conf_wastetype5);
        waste6 = view.findViewById(R.id.conf_wastetype6);
        Button bt = view.findViewById(R.id.confirm_button);

        Bundle bundle = this.getArguments();
        if(bundle != null){
            date.setText(String.valueOf(bundle.getString("dt")));
            time.setText(String.valueOf(bundle.getString("tm")));
            waste1.setText(String.valueOf(bundle.getString("dom")));
            waste2.setText(String.valueOf(bundle.getString("med")));
            waste3.setText(String.valueOf(bundle.getString("recy")));
            waste4.setText(String.valueOf(bundle.getString("org")));
            waste5.setText(String.valueOf(bundle.getString("haz")));
            waste6.setText(String.valueOf(bundle.getString("elec")));
        }



        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment secondFrag = new Map();
                FragmentTransaction fn = getActivity().getSupportFragmentManager().beginTransaction();
                fn.replace(R.id.home_frame,secondFrag)
                            .setReorderingAllowed(true)
                            .addToBackStack(null)
                            .commit();

                Toast.makeText(getActivity(),"Sending Successful",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        return view;
    }
}