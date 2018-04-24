package com.example.android.gyulatouristguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link SightAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Sight} objects.
 */
public class SightAdapter extends ArrayAdapter<Sight> {

    // Resource ID for the background color for this list of sights
    private int mColorResourceId;

    /**
     * Create a new {@link SightAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param sights          sights is the list of {@link Sight}s to be displayed.
     * @param colorResourceId colorResourceId is the resource ID for the background color for this list of sights
     */
    public SightAdapter(Context context, ArrayList<Sight> sights, int colorResourceId) {
        super(context, 0, sights);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Get the {@link Sight} object located at this position in the list
        Sight currentSight = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID name.
        TextView nameTextView = listItemView.findViewById(R.id.name);
        // Get the name from the currentSight object and set this text on the name TextView
        nameTextView.setText(currentSight.getmName());

        View textContainer = listItemView.findViewById(R.id.container_outer);
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID info.
        TextView infoTextView = listItemView.findViewById(R.id.info);

        // Get the info from the currentSight object and set this text on the info TextView
        infoTextView.setText(currentSight.getmInfo());

        if (!currentSight.hasInfo()) {
            ImageView imageView = listItemView.findViewById(R.id.move);
            imageView.setImageResource(R.drawable.ic_open_in_browser);
        }

        // Find the TextView in the list_item.xml layout with the ID open.
        TextView openTextView = listItemView.findViewById(R.id.open);
        // Get the open from the currentSight object and set this text on the open TextView
        openTextView.setText(currentSight.getmOpen());

        // Find the ImageView in the list_item.xml layout with the ID image_cover.
        ImageView imageView = listItemView.findViewById(R.id.image_cover);
        // Check if an image is provided for this sight or not
        if (currentSight.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentSight.getmImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView
            imageView.setVisibility(View.GONE);
        }
        // Return the whole list item layout (containing 3 TextViews) so that ot can be shown in the ListView
        return listItemView;
    }
}
