package lesson2.music.players;

import lesson2.music.drives.Drive;

abstract class MusicPlayer {
    /**
     * Abstract class for creating MusicPlayers
     */
    protected String playerName;
    protected String[] playerType;
    protected Drive playerDrive;

    /**
     * Play a song with a specific no. (start with 1)
     * @param index no. of song in playlist
     */
    public abstract void playSong(int index);

    /**
     * Plays every single song recorded on a drive
     */
    public abstract void playEachSong();

    /**
     * Sets a drive with recorded songs
     * @param drive drive that you want to install
     */
    public abstract void setPlayerDrive(Drive drive);

    /**
     * Ejects a drive
     */
    public abstract void ejectPlayerDrive();

    public abstract String getPlayerName();

    protected abstract boolean checkComplactability(Drive drive);
}
