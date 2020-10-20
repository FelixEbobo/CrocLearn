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

        /**
         * Uses design pattern to build a custom MusicPlayer with a custom properties
         * @param playerName pass a name that you want your MusicPlayer be
         */
        public Builder(String playerName) {
            this.playerName = playerName;
        }

        /**
         * Set a number of songs played
         * @param songsPlayed pass number of songs that already has played on Player
         * @return Object with set parameter
         */
        public Builder songsPlayed(int songsPlayed) {
            this.songsPlayed = songsPlayed;
            return this;
        }

        /**
         * Set a drive to a Player
         * @param drive pass a drive
         * @return Object with set parameter
         */
        public Builder playerDrive(Drive drive) {
            this.playerDrive = drive;
            return this;
        }

        /**
         * Set an ability to play music from CD Drives
         * @return Object with set parameter
         */
        public Builder canPlayCd() {
            this.playerType[0] = "cd";
            return this;
        }

        /**
         * Set an ability to play music from USB Drives
         * @return Object with set parameter
         */
        public Builder canPlayUsb() {
            this.playerType[1] = "usb";
            return this;
        }

        /**
         * Set an ability to play music from Phonogram Records
         * @return Object with set parameter
         */
        public Builder canPlayVinyl() {
            this.playerType[2] = "vinyl";
            return this;
        }

        /**
         * Builds MusicStation object
         * @return MusicStation object with custom fields
         */
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

    /**
     * Plays every single song recorded on a drive
     */
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

    /**
     * Play a song with a specific no. (start with 1)
     * @param index no. of song in playlist
     */
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

    /**
     * Sets a drive with recorded songs
     * @param drive drive that you want to install
     */
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

    /**
     * Ejects a drive
     */
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

    /**
     * Shows a number of song that player played
     */
    public void showSongsPlayed() {
        System.out.printf("This player played %d songs\n", this.songsPlayed);
    }
}
