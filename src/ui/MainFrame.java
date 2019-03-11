package ui;

import model.Vertex;
import raster.Visibility;
import render.Shader;
import render.Triangle;
import transforms.Col;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        setTitle("PGRF2");
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        Shader shader = new Shader() {
            @Override
            public Col shade(Vertex v) {
                return new Col(0xFFFFFF);
            }
        };

        Visibility visibility = new Visibility(width,height);
        Triangle rTriangle = new Triangle(visibility);

        initUI();
    }

    private void initUI() {
        add(new DrawPane());
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        }, 100, FPS);
    }

    private void draw() {
        repaint();
    }

    public class DrawPane extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(img,0,0,img.getWidth(),img.getHeight(),null);
            g2d.dispose();
        }

    }
}