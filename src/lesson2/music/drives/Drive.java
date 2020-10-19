package lesson2.music.drives;

import lesson2.music.songs.Song;

public abstract class Drive {
    protected String driveType;
    protected String driveName;
    protected Song[] drivePlaylist;
    public int playlistLength;

    public abstract String getDriveType();

    public abstract String getDriveName();

    public abstract String getSong(int index);
}
