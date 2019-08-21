package xavier.project_iodine.client;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

public class Sound {
    private File audioFile;
    private String name;

    public Sound(String name) {
        try {
            this.audioFile = new File(this.getClass().getClassLoader().getResource("sounds/"+name+".wav").getFile());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        this.name = name;
    }

    public void play(){
        try {
            InputStream in = new FileInputStream(audioFile);

            AudioStream audioStream = new AudioStream(in);

            AudioPlayer.player.start(audioStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }
}
