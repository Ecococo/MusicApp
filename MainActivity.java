package com.example.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        //here I would add all the actual songs in the list
        final ArrayList<SongInfo> songs = new ArrayList<SongInfo>();
        songs.add(new SongInfo("song1", "xx", R.raw.fight));
        songs.add(new SongInfo("song2", "xx", R.raw.jamack));
        songs.add(new SongInfo("song3", "xx", R.raw.name));
        songs.add(new SongInfo("Crack", "Thunder"));
        songs.add(new SongInfo("TikTok", "Clock"));
        songs.add(new SongInfo("123", "Numerals"));
        songs.add(new SongInfo("CIX", "Romans"));
        songs.add(new SongInfo("Type", "What"));
        songs.add(new SongInfo("Coding", "Is Hard"));
        songs.add(new SongInfo("Sleep", "I need"));
        songs.add(new SongInfo("Melody", "Orchestra"));
        songs.add(new SongInfo("Almost done", "Me"));
        songs.add(new SongInfo("One more", "Me"));
        songs.add(new SongInfo("Finally", "Me"));

        SongInfoAdapter adapter = new SongInfoAdapter(this, songs);
        ListView ListView = (ListView) findViewById(R.id.list);
        ListView.setAdapter(adapter);
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SongInfo song = songs.get(position);
                if(song.getSoundResourceId() == 0) {
                    Toast.makeText(MainActivity.this, "no song", Toast.LENGTH_SHORT).show();
                    return;}

                /**
                 * send title of song playing
                 */
                Intent j = new Intent(MainActivity.this, LibraryActivity.class);
                String songName = song.getSongName();
                j.putExtra("Song: ", songName);

                /**
                 * send artist name info
                 */
                Intent i = new Intent(MainActivity.this, LibraryActivity.class);
                String strName = song.getArtistName();
                i.putExtra("Artist: ", strName);

                Intent s = new Intent(MainActivity.this, LibraryActivity.class);
                ArrayList<SongInfo> sng = songs;

                mMediaPlayer = MediaPlayer.create(MainActivity.this, song.getSoundResourceId());
                mMediaPlayer.start();
                Toast.makeText(MainActivity.this, "now Playing" + song.getSongName(), Toast.LENGTH_SHORT).show();
                Intent library = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(library);
            }



        });

        /**
         * opens main activity
         */
        ImageButton library = (ImageButton) findViewById(R.id.library_button);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(libraryIntent);
            }
        });

    }
}
