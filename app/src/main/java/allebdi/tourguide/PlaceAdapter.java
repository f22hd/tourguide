package allebdi.tourguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fahd on 1/14/18.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {
    Context mContext;
    private ArrayList<Place> placeList;

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
        this.placeList = places;
        this.mContext = context;
    }


    @Override
    public int getCount() {
        return placeList.size();
    }

    @Override
    public Place getItem(int position) {
        return placeList.get(position);
    }

    @Override
    public boolean isEmpty() {
        return placeList.isEmpty();
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final View listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);

        final Place place = getItem(position);

        ImageView image = listItem.findViewById(R.id.picture);
        TextView name = listItem.findViewById(R.id.name);
        RatingBar ratingBar = listItem.findViewById(R.id.rating_bar);

        name.setText(place.getName());
        image.setImageResource(place.getPicturePath());
        ratingBar.setRating(place.getRating());

         return listItem;
    }


}
