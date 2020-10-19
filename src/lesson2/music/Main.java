package lesson2.music;

import lesson2.music.drives.CdDisk;
import lesson2.music.players.CdPlayer;
import lesson2.music.songs.Song;

public class Main {
    public static void main(String[] args) {
        Song[] myPlaylistOne = new Song[3];
        myPlaylistOne[0] = new Song("NCT U", "untitled", "BOSS");
        myPlaylistOne[1] = new Song("SEVENTEEN", ";[Semicolon]", "HOME;RUN");
        myPlaylistOne[2] = new Song("Florence + The Machine", "High As Hope", "Hunger");

        var cdDiskOne = new CdDisk("myCdOne", myPlaylistOne);
        var cdPlayerOne = new CdPlayer("myCdPlayerOne");
        cdPlayerOne.playSong(1);
        cdPlayerOne.setPlayerDrive(cdDiskOne);
        cdPlayerOne.playEachSong();
    }
}
