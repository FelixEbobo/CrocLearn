package lesson2.music.drives;

import lesson2.music.songs.Song;

public class PhonographRecord extends Drive{
    public PhonographRecord(String driveName, Song[] drivePlaylist) {
        this.drivePlaylist = drivePlaylist;
        this.driveType = "vinyl";
        this.driveName = driveName;
        this.playlistLength = drivePlaylist.length;
    }

    @Override
    public String getDriveType() {
        return this.driveType;
    }

    @Override
    public String getDriveName() {
        return this.driveName;
    }

    @Override
    public String getSong(int index) {
        return this.drivePlaylist[index].getSong();
    }
}
