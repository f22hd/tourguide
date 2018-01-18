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


public class RestuarantFragment extends Fragment {

    public RestuarantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        final ArrayList<Place> places = new ArrayList<>();

        String rest[] = getResources().getStringArray(R.array.resturant_sultan);
        String indian[] = getResources().getStringArray(R.array.resturant_indian);
        String kampai[] = getResources().getStringArray(R.array.resturant_Kampai);
        String hamza[] = getResources().getStringArray(R.array.resturant_hamza);

        places.add(new Place(rest[0], String.valueOf(rest[2]), Float.valueOf(rest[1]), R.drawable.sultan));
        places.add(new Place(indian[0], indian[2], Float.valueOf(indian[1]), R.drawable.indiansummer));
        places.add(new Place(kampai[0], kampai[2], Float.valueOf(kampai[1]), R.drawable.caption));
        places.add(new Place(hamza[0], hamza[2], Float.valueOf(hamza[1]), R.drawable.seafood));

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
