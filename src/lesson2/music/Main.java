package lesson2.music;

import lesson2.music.drives.CdDisk;
import lesson2.music.drives.PhonographRecord;
import lesson2.music.drives.UsbFlash;
import lesson2.music.players.CdPlayer;
import lesson2.music.players.DigitalPlayer;
import lesson2.music.players.MusicStation;
import lesson2.music.songs.Song;

public class Main {
    public static void main(String[] args) {
        Song[] myPlaylistOne = new Song[3];
        myPlaylistOne[0] = new Song("NCT U", "untitled", "BOSS");
        myPlaylistOne[1] = new Song("SEVENTEEN", ";[Semicolon]", "HOME;RUN");
        myPlaylistOne[2] = new Song("Florence + The Machine", "High As Hope", "Hunger");

        var usbFlashOne = new UsbFlash("myUsbOne", myPlaylistOne);
        var cdDiskOne = new CdDisk("myCdOne", myPlaylistOne);
        var vinylOne = new PhonographRecord("myVinylOne", myPlaylistOne);

        var cdPlayerOne = new CdPlayer("myCdPlayerOne");
        var digitalPlayerOne = new DigitalPlayer("myDigPlayerOne");
        cdPlayerOne.setPlayerDrive(usbFlashOne);

        var allInOnePlayer = new MusicStation.Builder("MultiPultiThing")
                .canPlayCd()
                .canPlayUsb()
                .canPlayVinyl()
                .songsPlayed(4)
                .build();

        allInOnePlayer.setPlayerDrive(usbFlashOne);
        allInOnePlayer.playSong(1);
        allInOnePlayer.setPlayerDrive(cdDiskOne);
        allInOnePlayer.playSong(2);
        allInOnePlayer.setPlayerDrive(vinylOne);
        allInOnePlayer.playSong(3);
    }
}
