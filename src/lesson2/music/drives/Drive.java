package lesson2.music.drives;

import lesson2.music.songs.Song;

public abstract class Drive {
    /**
     * Abstract class for creating drive storage with playlists
     */
    protected String driveType;
    protected String driveName;
    protected Song[] drivePlaylist;
    public int playlistLength;

    public abstract String getDriveType();

    public abstract String getDriveName();

    /**
     * Returs a song information from playlist
     * @param index Index of song in playlist
     * @return Song information
     */
    public abstract String getSong(int index);
}
