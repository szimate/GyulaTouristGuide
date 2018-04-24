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
public class RecreationFragment extends Fragment {

    private String geoBegin = "geo:0,0?q=";

    public RecreationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_places, container, false);

        final ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(getString(R.string.event_1), getString(R.string.date_1), getString(R.string.fee_1), getString(R.string.rec_loc1)));
        sights.add(new Sight(getString(R.string.event_2), getString(R.string.date_2), getString(R.string.fee_2), getString(R.string.rec_loc1)));
        sights.add(new Sight(getString(R.string.event_3), getString(R.string.date_3), getString(R.string.fee_3), getString(R.string.rec_loc23)));
        sights.add(new Sight(getString(R.string.event_4), getString(R.string.date_4), getString(R.string.fee_3), getString(R.string.rec_loc1)));
        sights.add(new Sight(getString(R.string.event_5), getString(R.string.date_5), getString(R.string.fee_3), getString(R.string.rec_loc1)));
        sights.add(new Sight(getString(R.string.recreation_1), getString(R.string.open_1), getString(R.string.fee_4), getString(R.string.rec_loc18)));
        sights.add(new Sight(getString(R.string.recreation_2), getString(R.string.open_2), getString(R.string.fee_7), getString(R.string.rec_loc19)));
        sights.add(new Sight(getString(R.string.recreation_3), getString(R.string.open_3), getString(R.string.fee_5), getString(R.string.rec_loc20)));
        sights.add(new Sight(getString(R.string.recreation_4), getString(R.string.open_16), getString(R.string.fee_11), getString(R.string.rec_loc21)));
        sights.add(new Sight(getString(R.string.recreation_5), getString(R.string.open_4), getString(R.string.fee_6), getString(R.string.rec_loc22)));

        SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.something_green);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setBackgroundResource(R.drawable.gyula);

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
