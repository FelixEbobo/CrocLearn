package lesson2.music.players;

import lesson2.music.drives.Drive;
import lesson2.music.players.MusicPlayer;

public class MusicStation extends MusicPlayer{
    private int songsPlayed;

    public static class Builder {
        private String playerName;

        private int songsPlayed = 0;
        private Drive playerDrive = null;
        private String[] playerType = new String[]{"null", "null", "null"};

        public Builder(String playerName) {
            this.playerName = playerName;
        }

        public Builder songsPlayed(int songsPlayed) {
            this.songsPlayed = songsPlayed;
            return this;
        }

        public Builder playerDrive(Drive drive) {
            this.playerDrive = drive;
            return this;
        }

        public Builder canPlayCd() {
            this.playerType[0] = "cd";
            return this;
        }

        public Builder canPlayUsb() {
            this.playerType[1] = "usb";
            return this;
        }

        public Builder canPlayVinyl() {
            this.playerType[2] = "vinyl";
            return this;
        }

        public MusicStation build() {
            return new MusicStation(this);
        }
    }

    private MusicStation(Builder builder) {
        this.playerDrive = builder.playerDrive;
        this.playerName = builder.playerName;
        this.playerType = builder.playerType;
        this.songsPlayed = builder.songsPlayed;
    }

    @Override
    public void playEachSong() {
        if (this.playerDrive != null) {
            for (int i = 1; i < this.playerDrive.playlistLength + 1; i++) {
                this.playSong(i);
            }
        }
        else {
            System.out.println("You hasn't install drive!");
        }
    }

    @Override
    public void playSong(int index) {
        try {
            if (this.playerDrive != null) {
                System.out.println("NOW PLAYING:\n" + playerDrive.getSong(index - 1));
                this.songsPlayed++;
            }
            else {
                System.out.println("You hasn't install drive!");
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is no song with this index!");
        }
    }

    @Override
    public void setPlayerDrive(Drive drive) {
        if (this.playerDrive != null) {
            this.ejectPlayerDrive();
        }
        if (checkComplactability(drive)) {
            this.playerDrive = drive;
            System.out.printf("The player's drive now set to %s\n", drive.getDriveName());
        }
        else {
            System.out.println("This drive type doesn't match with player type!");
        }
    }

    @Override
    public void ejectPlayerDrive() {
        System.out.println("You ejected " + this.playerDrive.getDriveName());
        this.playerDrive = null;
    }

    @Override
    public String getPlayerName() {
        return this.playerName;
    }

    @Override
    protected boolean checkComplactability(Drive drive) {
        for (String type: this.playerType) {
            if (drive.getDriveType().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public void showSongsPlayed() {
        System.out.printf("This player played %d songs\n", this.songsPlayed);
    }
}
