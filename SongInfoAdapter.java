package com.example.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class SongInfoAdapter extends ArrayAdapter<SongInfo> {


    public SongInfoAdapter(Activity context, ArrayList<SongInfo> SongInfo) {
        super(context, 0, SongInfo);}
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate
                    (R.layout.list_item, parent, false);
        }
        //get the song object located at this position in the list

        SongInfo currentSongInfo = getItem(position);

        //find the TextView int hte list_item.xml layout with the ID song_name_text_view
        TextView songNameTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);
        //Get the song name from the current SongInfo object an set the text on the TextView
        songNameTextView.setText(currentSongInfo.getSongName());

        //Do the same for the artist name
        TextView artistNameTextView =(TextView) listItemView.findViewById(R.id.artist_name_text_view);
        artistNameTextView.setText(currentSongInfo.getArtistName());

        return listItemView;

    }
}
