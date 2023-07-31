package com.example.darwaste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Home home = new Home();
        Calendarr calendarr = new Calendarr();
        Map map = new Map();
        Info info = new Info();
        Settings settings= new Settings();

        MeowBottomNavigation meowBottomNavigation = findViewById(R.id.bottomNavigation);
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_calendar));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_map));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_info));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.ic_settings));

        meowBottomNavigation.show(1,true);
        replace(new Home());

        meowBottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>(){
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        replace(new Home());
                        break;

                    case 2:
                        replace(new Calendarr());
                        break;

                    case 3:
                        replace(new Map());
                        break;

                    case 4:
                        replace(new Info());
                        break;

                    case 5:
                        replace(new Settings());
                        break;
                }
                return null;
            }
        });
    }

    private void replace(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.home_frame,fragment);
        transaction.commit();
    }
}