package com.comp2059.app;

import javafx.scene.media.AudioClip;

public class MusicPlayer {
    AudioClip audioClip_Explosion = new AudioClip(getClass().getResource("audio/Explosion2.WAV").toExternalForm());
    ;
    AudioClip audioClip = new AudioClip(getClass().getResource("audio/StarWars60.wav").toExternalForm());
    AudioClip audioClip_Laser = new AudioClip(getClass().getResource("audio/Laser.WAV").toExternalForm());


    public void playExplosion() {
        audioClip_Explosion.play();
    }

    public void playClip(boolean indefinite) {
        audioClip.setCycleCount(indefinite ? AudioClip.INDEFINITE : 1);
        audioClip.play();
    }

    public void playLaser() {
        audioClip_Laser.play();
    }
}
