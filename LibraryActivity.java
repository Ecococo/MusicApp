package com.example.musicapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;

public class LibraryActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        /**
         * opens library
         */
        ImageButton library = (ImageButton) findViewById(R.id.library_button);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent libraryIntent = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(libraryIntent);
            }
        });
        /**
         * Change the image on the play button from play to pause
         */
        final boolean changeImage =true;
        final ImageButton playPause = (ImageButton) findViewById(R.id.pause_button);
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (changeImage) {
                    playPause.setImageResource(R.drawable.iconfinder_button_pause_violet_14774);
                    mMediaPlayer.pause();
                    Toast.makeText(LibraryActivity.this, "now paused ", Toast.LENGTH_SHORT).show();
                } else {
                    playPause.setImageResource(R.drawable.iconfinder_button_play_violet_14779);
                    mMediaPlayer.start();
                    Toast.makeText(LibraryActivity.this, "now playing " + sng, Toast.LENGTH_SHORT).show();
                }
            }
            Intent j =getIntent();
            String sng = j.getStringExtra("Song:");
        });



        /**
         * play next song
         */
        ImageButton nextSong = (ImageButton) findViewById(R.id.next_song_button);
        nextSong.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent s =getIntent();
            }
        });

        /**
         * recieve song name
         */
        TextView songName = (TextView) findViewById(R.id.song_name_text_view);
        Intent j =getIntent();
        String sng = j.getStringExtra("Song:");
        songName.setText(sng);

        /**
         * recieve artist name
         */
        TextView artistName = (TextView) findViewById(R.id.artist_name_text_view);
        // create the get Intent object
        Intent intent = getIntent();
        // receive the value by getStringExtra() method
        // and key must be same which is send by first activity
        String str = intent.getStringExtra("Artist: ");
        // display the string into textView
        artistName.setText(str);
    }
}