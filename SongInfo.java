package com.example.musicapp;

public class SongInfo {

    /**
     * Song name
     */
    private String mSongName;

    /**
     * Song artist
     */
    private String mArtistName;

    /**
     * song sound
     */
    private int mSoundResourceId;

    /**
     * create new object
     */
    public SongInfo (String songName, String artistName) {
        mSongName = songName;
        mArtistName = artistName;
    }

    /**
     * create new object
     */
    public SongInfo (String songName, String artistName, int soundResourceId) {
        mSongName = songName;
        mArtistName = artistName;
        mSoundResourceId = soundResourceId;
    }

    /**
     * get the info
     */
    public String getSongName() {
        return mSongName;
    }

    public String getArtistName() {
        return mArtistName;
    }

    public int getSoundResourceId() {return mSoundResourceId;}

}

