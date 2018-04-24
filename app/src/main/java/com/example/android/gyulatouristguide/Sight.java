package com.example.android.gyulatouristguide;

public class Sight {

    // String resource ID for the name of the sight
    private String mName;
    // String resource ID for open hours of the sight
    private String mOpen;
    // String resource ID for season of the sight
    private String mInfo;
    // String resource ID for address of the sight
    private String mAddress;
    // Image resource ID for the sight
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    // Constant value that represents no image provided for this sight
    private static final int NO_IMAGE_PROVIDED = -1;


    /**
     * Create a new Sight object
     *
     * @param name            is the string resource ID for the sight name in the for fragment.
     * @param address         is the string resource ID for the sight address
     * @param imageResourceId is the drawable resource ID for the sight
     */

    public Sight(String name, String address, int imageResourceId) {
        mName = name;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Sight object
     *
     * @param name    is the string resource ID for the sight name in the for fragment.
     * @param info    is the string resource ID for some information of the sight
     * @param open    is the string resource ID for the sight open hour
     * @param address is the string resource ID for the sight address
     */
    public Sight(String name, String info, String open, String address) {
        mName = name;
        mOpen = open;
        mInfo = info;
        mAddress = address;
    }

    /**
     * Create a new Sight object
     *
     * @param name            is the string resource ID for the sight name in the for fragment.
     * @param info            is the string resource ID for some information of the sight
     * @param open            is the string resource ID for the sight open hour
     * @param address         is the string resource ID for the sight address
     * @param imageResourceId is the drawable resource ID for the sight
     */

    public Sight(String name, String info, String open, String address, int imageResourceId) {
        mName = name;
        mOpen = open;
        mInfo = info;
        mAddress = address;
        mImageResourceId = imageResourceId;
    }

    // Get string resource ID for the name of the sight.
    public String getmName() {
        return mName;
    }

    // Get string resource ID for the open hours of the sight.
    public String getmOpen() {
        return mOpen;
    }

    // Get string resource ID for information of the sight.
    public String getmInfo() {
        return mInfo;
    }

    // Get string resource ID for address of the sight.
    public String getmAddress() {
        return mAddress;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    // Returns whether or not there is an image for this sight.
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public boolean hasInfo() {
        return mInfo != null;
    }
}
