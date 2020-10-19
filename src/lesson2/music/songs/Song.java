package lesson2.music.songs;

public class Song {
    private String artistName;
    private String albumName;
    private String songName;

    public Song(String artistName, String albumName, String songName) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.songName = songName;
    }

    public String getSong() {
        return String.format("\"%s\" by %s (%s)", this.songName, this.artistName, this.albumName);
    }
}
