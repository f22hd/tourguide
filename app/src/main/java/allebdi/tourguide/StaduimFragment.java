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


public class StaduimFragment extends Fragment {

    public StaduimFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_place, container, false);
        final ArrayList<Place> places = new ArrayList<>();

        String fahd[] = getResources().getStringArray(R.array.staduim_king_fahd);
        String abd[] = getResources().getStringArray(R.array.staduim_king_abdullah);
        String ksu[] = getResources().getStringArray(R.array.staduim_ksu);
        String faisal[] = getResources().getStringArray(R.array.staduim_prince_faisal);


        places.add(new Place(fahd[0], fahd[2], Float.valueOf(fahd[1]), R.drawable.fahd));
        places.add(new Place(abd[0], abd[2], Float.valueOf(abd[1]), R.drawable.abd));
        places.add(new Place(ksu[0], ksu[2], Float.valueOf(ksu[1]), R.drawable.ksu));
        places.add(new Place(faisal[0], faisal[2], Float.valueOf(faisal[1]), R.drawable.faisal));

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
