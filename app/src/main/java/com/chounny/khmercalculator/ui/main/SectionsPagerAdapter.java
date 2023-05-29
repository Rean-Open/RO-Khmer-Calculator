package com.chounny.khmercalculator.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.chounny.khmercalculator.FruitMeasureFragment;
import com.chounny.khmercalculator.LengthMeasureFragment;
import com.chounny.khmercalculator.R;
import com.chounny.khmercalculator.VolumeMeasureFragment;
import com.chounny.khmercalculator.WeighMeasureFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FruitMeasureFragment();
                break;
            case 1:
                fragment = new VolumeMeasureFragment();
                break;
            case 2:
                fragment = new WeighMeasureFragment();
                break;
            case 3:
                fragment = new LengthMeasureFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 4;
    }
}