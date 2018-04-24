package com.example.android.gyulatouristguide.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.gyulatouristguide.R;
import com.example.android.gyulatouristguide.Sight;
import com.example.android.gyulatouristguide.SightAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    private String geoBegin = "geo:0,0?q=";

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_places, container, false);

        final ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(getString(R.string.history_1), getString(R.string.open_4), getString(R.string.fee_8), getString(R.string.rec_loc1)));
        sights.add(new Sight(getString(R.string.history_2), getString(R.string.open_4), getString(R.string.fee_9), getString(R.string.rec_loc2)));
        sights.add(new Sight(getString(R.string.history_3), getString(R.string.open_5), getString(R.string.fee_10), getString(R.string.rec_loc3)));
        sights.add(new Sight(getString(R.string.history_4), getString(R.string.open_6), getString(R.string.fee_3), getString(R.string.rec_loc4)));
        sights.add(new Sight(getString(R.string.history_5), getString(R.string.open_1), getString(R.string.fee_1), getString(R.string.rec_loc5)));
        sights.add(new Sight(getString(R.string.history_6), getString(R.string.open_7), getString(R.string.fee_10), getString(R.string.rec_loc6)));

        SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.earth_brown);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setBackgroundResource(R.drawable.gyula_castle_fest);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //  Get the Word object at the given position the user clicked
                Sight sight = sights.get(position);

                String address = sight.getmAddress();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                address = Uri.encode(address);
                address = geoBegin + address;
                intent.setData(Uri.parse(address));
                if (intent.resolveActivity(view.getContext().getPackageManager()) != null) {
                    view.getContext().startActivity(intent);
                }
            }
        });

        return rootView;
    }

}
