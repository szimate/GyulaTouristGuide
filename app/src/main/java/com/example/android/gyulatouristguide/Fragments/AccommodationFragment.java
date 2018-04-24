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
public class AccommodationFragment extends Fragment {

    public AccommodationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_places, container, false);

        final ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(getString(R.string.accomodation_1), getString(R.string.url_1), R.drawable.icons8_bed_96));
        sights.add(new Sight(getString(R.string.accomodation_2), getString(R.string.url_2), R.drawable.icons8_bed_96));
        sights.add(new Sight(getString(R.string.accomodation_3), getString(R.string.url_3), R.drawable.icons8_bed_96));
        sights.add(new Sight(getString(R.string.accomodation_4), getString(R.string.url_4), R.drawable.icons8_bed_96));
        sights.add(new Sight(getString(R.string.accomodation_5), getString(R.string.url_5), R.drawable.icons8_bed_96));
        sights.add(new Sight(getString(R.string.accomodation_6), getString(R.string.url_6), R.drawable.icons8_bed_96));

        SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.blue);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setBackgroundResource(R.drawable.gyula);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                //  Get the Word object at the given position the user clicked
                Sight sight = sights.get(position);

                Uri web = Uri.parse(sight.getmAddress());
                Intent intent = new Intent(Intent.ACTION_VIEW, web);
                if (intent.resolveActivity(view.getContext().getPackageManager()) != null) {
                    view.getContext().startActivity(intent);
                }
            }
        });
        return rootView;
    }
}