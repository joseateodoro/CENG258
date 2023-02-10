package jose.teodoro.n01384776.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import jose.teodoro.n01384776.Canvas.JoseFragment;
import jose.teodoro.n01384776.Animation.N01384776Fragment;
import jose.teodoro.n01384776.R;
import jose.teodoro.n01384776.Call.TeodoroFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.jose_tab, R.string.teodoro_tab, R.string.number_tab};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        /*
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(position + 1);

         */
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new JoseFragment();
                break;
            case 1:
                fragment = new TeodoroFragment();
                break;
            case 2:
                fragment = new N01384776Fragment();
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
        // Show 2 total pages.
        return 3;
    }
}