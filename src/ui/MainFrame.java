package ui;

import Model.Solid;
import Raster.ImgBuffer;
import Raster.ZBuffer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainFrame extends JFrame {

    static int FPS = 1000 / 30;
    private Canvas canvas;

    private List<Solid> solids;


    public MainFrame() {

        solids = new ArrayList<>();





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
        canvas = new Canvas();
        add(canvas);
        java.util.Timer timer = new Timer();
        System.out.println(canvas.getWidth());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        }, 100, FPS);
    }

    private void draw(){

        canvas.paint();


    }
}
