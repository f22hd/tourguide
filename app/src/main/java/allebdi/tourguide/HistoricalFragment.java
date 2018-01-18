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


public class HistoricalFragment extends Fragment {

    public HistoricalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        final ArrayList<Place> places = new ArrayList<>();

        String his1[] = getResources().getStringArray(R.array.his_1);
        String his2[] = getResources().getStringArray(R.array.his_2);
        String his3[] = getResources().getStringArray(R.array.his_3);
        String his4[] = getResources().getStringArray(R.array.his_4);

        places.add(new Place(his1[0], his1[2], Float.valueOf(his1[1]), R.drawable.hist3));
        places.add(new Place(his2[0], his2[2], Float.valueOf(his2[1]), R.drawable.hist1));
        places.add(new Place(his3[0], his3[2], Float.valueOf(his3[1]), R.drawable.hist));
        places.add(new Place(his4[0], his4[2], Float.valueOf(his4[1]), R.drawable.dir));

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
