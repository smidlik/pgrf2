package ui;

import raster.Visibility;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;


public class MainFrame extends JFrame {
    private static final int width = 800;
    private static final int height = 600;
    static final int FPS = 1000 / 30;
    private JPanel panel;

    private Canvas canvas;
    private Visibility visibility;
    private BufferedImage img;


    public MainFrame() {
        visibility = new Visibility(width, height);
        img = visibility.getBufferedImage();
        init();
    }

    private void init() {
        setTitle("PGRF2");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        panel = new JPanel();

        add(panel);

        img.setRGB(100,100,Color.RED.getRGB());

        java.util.Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        }, 100, FPS);
    }

    private void draw() {
        panel.paintComponents(img.getGraphics());
        panel.getGraphics().drawImage(img, 0,0,img.getWidth(), img.getHeight(), null);
        img.getGraphics().fillRect(0,0,img.getWidth(),img.getHeight());
    }
}