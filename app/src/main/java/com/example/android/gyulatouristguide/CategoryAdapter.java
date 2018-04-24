package com.example.android.gyulatouristguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.gyulatouristguide.Fragments.AccommodationFragment;
import com.example.android.gyulatouristguide.Fragments.FoodsFragment;
import com.example.android.gyulatouristguide.Fragments.HistoryFragment;
import com.example.android.gyulatouristguide.Fragments.HomeFragment;
import com.example.android.gyulatouristguide.Fragments.RecreationFragment;

public class CategoryAdapter extends FragmentPagerAdapter {

    //Context of the app
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HomeFragment();
        } else if (position == 1) {
            return new RecreationFragment();
        } else if (position == 2) {
            return new FoodsFragment();
        } else if (position == 3) {
            return new HistoryFragment();
        } else {
            return new AccommodationFragment();
        }
    }

    // Return the total number of pages
    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.home);
        } else if (position == 1) {
            return mContext.getString(R.string.recreation);
        } else if (position == 2) {
            return mContext.getString(R.string.food);
        } else if (position == 3) {
            return mContext.getString(R.string.history);
        } else {
            return mContext.getString(R.string.accommodation);
        }
    }
}
