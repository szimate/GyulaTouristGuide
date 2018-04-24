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
public class FoodsFragment extends Fragment {

    private String geoBegin = "geo:0,0?q=";

    public FoodsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.list_places, container, false);

        final ArrayList<Sight> sights = new ArrayList<>();
        sights.add(new Sight(getString(R.string.food_1), getString(R.string.open_7), getString(R.string.type_1), getString(R.string.rec_loc7), R.drawable.icons8_ok_hand_96));
        sights.add(new Sight(getString(R.string.food_2), getString(R.string.open_8), getString(R.string.type_2), getString(R.string.rec_loc8), R.drawable.icons8_hamburger_96));
        sights.add(new Sight(getString(R.string.food_3), getString(R.string.open_15), getString(R.string.type_3), getString(R.string.rec_loc9), R.drawable.icons8_fish_food_96));
        sights.add(new Sight(getString(R.string.food_4), getString(R.string.open_9), getString(R.string.type_1), getString(R.string.rec_loc10), R.drawable.icons8_ok_hand_96));
        sights.add(new Sight(getString(R.string.food_5), getString(R.string.open_9), getString(R.string.type_2), getString(R.string.rec_loc11), R.drawable.icons8_pizza_96));
        sights.add(new Sight(getString(R.string.food_6), getString(R.string.open_9), getString(R.string.type_3), getString(R.string.rec_loc12), R.drawable.icons8_dining_room_96));
        sights.add(new Sight(getString(R.string.food_7), getString(R.string.open_11), getString(R.string.type_1), getString(R.string.rec_loc13), R.drawable.icons8_ok_hand_96));
        sights.add(new Sight(getString(R.string.cafe_1), getString(R.string.open_12), getString(R.string.type_4), getString(R.string.rec_loc14), R.drawable.icons8_cafe_96));
        sights.add(new Sight(getString(R.string.cafe_2), getString(R.string.open_13), getString(R.string.type_5), getString(R.string.rec_loc15), R.drawable.icons8_cafe_96));
        sights.add(new Sight(getString(R.string.cafe_3), getString(R.string.open_14), getString(R.string.type_6), getString(R.string.rec_loc16), R.drawable.icons8_ice_cream_sundae_96));
        sights.add(new Sight(getString(R.string.cafe_4), getString(R.string.open_15), getString(R.string.type_6), getString(R.string.rec_loc17), R.drawable.icons8_ice_cream_sundae_96));

        SightAdapter adapter = new SightAdapter(getActivity(), sights, R.color.aoi);

        ListView listView = rootView.findViewById(R.id.list);
        listView.setBackgroundResource(R.drawable.gyula_sausage);

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
