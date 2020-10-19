package lesson2.music.players;

import lesson2.music.players.MusicPlayer;

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
            return this;
        }

        public MusicStation build() {
            return new MusicStation(this);
        }
    }

    private MusicStation(Builder builder) {
        musicPlayer = builder.musicPlayer;
        songsPlayed = builder.songsPlayed;
    }

//    public static void main(String[] args) {
//        var cdPlayer = new CdPlayer("Myboy1");
//        var mS = new MusicStation
//                .Builder(cdPlayer)
//                .songsPlayed(4)
//                .build();
//    }
}
