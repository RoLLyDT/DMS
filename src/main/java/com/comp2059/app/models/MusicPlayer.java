package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.scene.media.AudioClip;
/**
 * The MusicPlayer class plays the music and the sound effects.
 * 
 * @author TeamMinecraft
 */
public class MusicPlayer {
    AudioClip audioClip_Explosion = new AudioClip(HelloApplication.class.getResource("audio/Explosion2.WAV").toExternalForm());
    AudioClip audioClip = new AudioClip(HelloApplication.class.getResource("audio/StarWars60.wav").toExternalForm());
    AudioClip audioClip_Laser = new AudioClip(HelloApplication.class.getResource("audio/Laser.WAV").toExternalForm());

    /**
     * This method plays the explosion sound effect.
     */
    public void playExplosion() {
        audioClip_Explosion.play();
    }
    /**
     * This method plays the music.
     * 
     * @param indefinite The boolean value of the music.
     */
    public void playClip(boolean indefinite) {
        audioClip.setCycleCount(indefinite ? AudioClip.INDEFINITE : 1);
        audioClip.play();
    }
    /**
     * This method plays the laser sound effect.
     */
    public void playLaser() {
        audioClip_Laser.play();
    }
}
