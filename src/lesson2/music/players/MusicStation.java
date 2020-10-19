package Lesson2;

public class MusicStation {
    private final MusicPlayer musicPlayer;
    private final int songsPlayed;

    public static class Builder {
        private final MusicPlayer musicPlayer;

        private int songsPlayed = 0;

        public Builder(MusicPlayer musicPlayer) {
            this.musicPlayer = musicPlayer;
        }

        public Builder songsPlayed(int songsPlayed) {
            this.songsPlayed = songsPlayed;
        }
    }

    private MusicStation(Builder builder) {
        musicPlayer = builder.musicPlayer;
        songsPlayed = builder.songsPlayed;
    }

    public static void main(String[] args) {
//        var mS = new MusicStation().Builder()
    }
}
