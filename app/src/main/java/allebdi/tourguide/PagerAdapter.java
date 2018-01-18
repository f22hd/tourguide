package allebdi.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by fahd on 1/17/18.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numTabs = 3;
    final int RESTURANT = 0 ;
    final int CAFE = 1 ;
    final int STADIUM = 2 ;
    final int HISTORICAL = 3 ;

    public PagerAdapter(FragmentManager fragmentManager, int numTabs) {
        super(fragmentManager);
        this.numTabs = numTabs;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case RESTURANT:
                return  new RestuarantFragment();
            case CAFE:
                return new PlaceFragment();

            case STADIUM:
                return new StaduimFragment();
            case HISTORICAL:
                return new HistoricalFragment();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return this.numTabs;
    }
}
