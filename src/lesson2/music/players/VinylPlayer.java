package lesson2.music.players;

import lesson2.music.drives.Drive;

public class VinylPlayer extends MusicPlayer{
    public VinylPlayer(String playerName) {
        this.playerName = playerName;
        this.playerType = new String[]{"vinyl"};
        this.playerDrive = null;
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
}
