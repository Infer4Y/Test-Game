package client;

import java.io.*;

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
    }

    public String getName() {
        return name;
    }
}
