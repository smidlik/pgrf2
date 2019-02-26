package ui;

import Model.Solid;
import Raster.ImgBuffer;
import Raster.Visibility;
import Raster.ZBuffer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrame extends JFrame {

    private static int width = 800;
    private static int height = 600;
    private static int FPS = 1000 / 30;
    private JPanel panel;
    private Visibility visibility;
    private BufferedImage img;



    public MainFrame() {

        visibility = new Visibility(width,height);
        img = visibility.getBufferedImage();
        //TODO:

        init();
    }

    private void init() {
        setTitle("PGRF2");
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        panel = new JPanel();
        add(panel);
        java.util.Timer timer = new Timer();
        System.out.println(panel.getWidth());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        }, 100, FPS);
    }

    private void draw(){

        img.getGraphics().fillRect(0,0,img.getWidth(),img.getHeight());

        panel.getGraphics().drawImage(img,0,0,img.getWidth(),img.getHeight(),null);

        panel.paintComponents(getGraphics());



    }
}
