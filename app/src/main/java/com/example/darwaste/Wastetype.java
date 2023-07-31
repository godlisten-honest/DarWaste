package com.example.darwaste;

import android.graphics.Color;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Wastetype extends Fragment {

    GridLayout gridLayout;
    CheckBox domestic, medical, recyclable, organic, hazardous, electronic;
    TextView txtdom, txtmed, txtrecy, txtorg, txthaz, txtelec;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wastetype, container, false);
        setHasOptionsMenu(true);

        getActivity().setTitle("Waste Categories");

        gridLayout = view.findViewById(R.id.wastetype_grid);

        domestic = view.findViewById(R.id.check_domestic);
        medical = view.findViewById(R.id.check_medical);
        recyclable = view.findViewById(R.id.check_recyclable);
        organic = view.findViewById(R.id.check_organic);
        hazardous = view.findViewById(R.id.check_hazardous);
        electronic = view.findViewById(R.id.check_electronic);

        txtdom = view.findViewById(R.id.text_domestic);
        txtmed = view.findViewById(R.id.text_medical);
        txtrecy = view.findViewById(R.id.text_recyclable);
        txtorg = view.findViewById(R.id.text_organic);
        txthaz = view.findViewById(R.id.text_hazardous);
        txtelec = view.findViewById(R.id.text_electronic);

        Button wastetypebtn = view.findViewById(R.id.wastetype_button);


//        setSingleEvent(gridLayout);
//        setToggleEvent(gridLayout);

        wastetypebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment conf = new Confirmation();
                Bundle bundle = new Bundle();
                String msg="";

                if(domestic.isChecked()){
                    String dom = txtdom.getText().toString();
                    bundle.putString("dom",dom);
                    conf.setArguments(bundle);
                    msg = msg + " Domestic ";
                }

                if(medical.isChecked()){
                    String med = txtmed.getText().toString();
                    bundle.putString("med",med);
                    conf.setArguments(bundle);
                    msg = msg + " Medical ";
                }

                if(recyclable.isChecked()){
                    String recy = txtrecy.getText().toString();
                    bundle.putString("recy",recy);
                    conf.setArguments(bundle);
                    msg = msg + " Recyclable ";
                }

                if(organic.isChecked()){
                    String org = txtorg.getText().toString();
                    bundle.putString("org",org);
                    conf.setArguments(bundle);
                    msg = msg + " Organic ";
                }

                if(hazardous.isChecked()){
                    String haz = txthaz.getText().toString();
                    bundle.putString("haz",haz);
                    conf.setArguments(bundle);
                    msg = msg + " Hazardous ";
                }

                if(electronic.isChecked()){
                    String elec = txtelec.getText().toString();
                    bundle.putString("elec",elec);
                    conf.setArguments(bundle);
                    msg = msg + " Electronic ";
                }
                else
                {
//                    Fragment secondFrag = new Confirmation();
//                    FragmentTransaction fn = getActivity().getSupportFragmentManager().beginTransaction();
//                    fn.replace(R.id.Wastetype_container,secondFrag)
//                            .setReorderingAllowed(true)
//                            .addToBackStack(null)
//                            .commit();

                    Confirmation bottomSheet = new Confirmation();
                    bottomSheet.show(getActivity().getSupportFragmentManager(),
                        "ModalBottomSheet");

                }

                Toast.makeText(getActivity(),msg + "are selected",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void setToggleEvent(GridLayout gridLayout) {
        for(int i =0;i<gridLayout.getChildCount();i++){
            CardView cardView = (CardView)gridLayout.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(cardView.getCardBackgroundColor().getDefaultColor() == -1){
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(getActivity(),"Stated: True",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(getActivity(),"Stated: False",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout gridLayout) {
        for(int i =0;i<gridLayout.getChildCount();i++){
            CardView cardView = (CardView)gridLayout.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(),"Clicked",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}