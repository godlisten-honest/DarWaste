package com.example.darwaste;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final List<Fragment> fragments = new ArrayList<>();
    private final List<String> fragmentTitle = new ArrayList<>();

    // array for tab labels
//    private String[] labels = new String[]{"ViewPager1", "ViewPager2",};

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public void add(Fragment fragment, String title) {
        fragments.add(fragment);
        fragmentTitle.add(title);
    }

    // return fragments at every position
    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        switch (position) {
//            case 0:
//                return new ViewPage1(); // calls fragment
//            case 1:
//                return new ViewPage2(); // chats fragment
//        }
//        return new ViewPage1(); //chats fragment
        return fragments.get(position);
    }

    // return total number of tabs in our case we have 3
    @Override
    public int getItemCount() {
        return fragments.size();
    }

    @Nullable
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}
