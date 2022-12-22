package com.comp2059.app.models;

import com.comp2059.app.HelloApplication;
import javafx.scene.media.AudioClip;

public class MusicPlayer {
    AudioClip audioClip_Explosion = new AudioClip(HelloApplication.class.getResource("audio/Explosion2.WAV").toExternalForm());
    AudioClip audioClip = new AudioClip(HelloApplication.class.getResource("audio/StarWars60.wav").toExternalForm());
    AudioClip audioClip_Laser = new AudioClip(HelloApplication.class.getResource("audio/Laser.WAV").toExternalForm());


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
