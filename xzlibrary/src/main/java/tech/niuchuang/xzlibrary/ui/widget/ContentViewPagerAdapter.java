package tech.niuchuang.xzlibrary.ui.widget;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class ContentViewPagerAdapter extends FragmentPagerAdapter {
    public ContentViewPagerAdapter(FragmentManager fm,
                                   ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    private ArrayList<Fragment> fragments;

    public ContentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments == null) {
            return null;
        }
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if (fragments == null) {
            return 0;
        }
        return fragments.size();
    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//    }
}
