package allebdi.tourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class PlaceFragment extends Fragment {

    public PlaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        final ArrayList<Place> places = new ArrayList<>();

        String art[] = getResources().getStringArray(R.array.cafe_art);
        String bateel[] = getResources().getStringArray(R.array.cafe_bateel);
        String capio[] = getResources().getStringArray(R.array.cafe_capio);
        String notro[] = getResources().getStringArray(R.array.cafe_notro);

        places.add(new Place(art[0], art[2], Float.valueOf(art[1]), R.drawable.artcafee));
        places.add(new Place(bateel[0], bateel[2], Float.valueOf(bateel[1]), R.drawable.cafebateel));
        places.add(new Place(capio[0], capio[2], Float.valueOf(capio[1]), R.drawable.capio));
        places.add(new Place(notro[0], notro[2], Float.valueOf(notro[1]), R.drawable.notro));

        ListView listView = rootView.findViewById(R.id.listview);
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity().getBaseContext(), places);
        listView.setAdapter(placeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Place selectedPlace = places.get(position);

                Intent i = new Intent(getContext(), PlaceDetailsActivity.class);
                i.putExtra("selectedPlace", selectedPlace);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        });

        return rootView;
    }


}
