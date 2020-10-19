package lesson2.music.players;

import lesson2.music.drives.Drive;

abstract class MusicPlayer {
    protected String playerName;
    protected String FuckYou;
    protected String playerType;
    protected Drive playerDrive;


    public abstract void playSong(int index);

    public abstract void playEachSong();

    public abstract void setPlayerDrive(Drive drive);

    public abstract void ejectPlayerDrive();

    public abstract String getPlayerName();
}
