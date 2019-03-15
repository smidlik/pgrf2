package ui;

import raster.Visibility;
import render.Renderer;
import render.Triangle;
import transforms.Camera;
import transforms.Col;
import transforms.Vec3D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;


public class MainFrame extends JFrame {
    private static final int width = 800;
    private static final int height = 600;
    static final int FPS = 1000 / 30;

    private double moveX, moveY, moveZ;
    private double speed;
    private int beginX, beginY;
    private int sensitivity;

    private DrawPane drawPane;


    private Camera camera;
    private Visibility visibility;
    private BufferedImage img;
    private Renderer renderer;


    public MainFrame() {
        visibility = new Visibility(width, height);
        img = visibility.getBufferedImage();
        renderer = new Renderer(visibility);
        setTitle("PGRF2");
        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        camera = new Camera();


        Visibility visibility = new Visibility(width, height);
        Triangle rTriangle = new Triangle(visibility);
        rTriangle.setShader((vertex) -> new Col(0xFFFFFF));
        rTriangle.setShader((vertex) -> vertex.getColor().mul(1 / vertex.getOne()));

        initUI();
    }


    private void initUI() {
        resetCamera();
        sensitivity = 2500;


        drawPane =new DrawPane();
        add(drawPane);
        drawPane.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                beginX = e.getX();
                beginY = e.getY();
                super.mousePressed(e);
            }
        });
        drawPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                camera = camera.addAzimuth((Math.PI / sensitivity) * (beginX - e.getX()));
                camera = camera.addZenith((Math.PI / sensitivity) * (beginY - e.getY()));
                beginX = e.getX();
                beginY = e.getY();
                super.mouseDragged(e);
            }
        });
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println(e.getKeyCode());
                if (e.isShiftDown())
                    speed = 0.3;
                else
                    speed = 0.1;
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        camera = camera.forward(speed);
                        break;
                    case KeyEvent.VK_DOWN:
                        camera = camera.backward(speed);
                        break;
                    case KeyEvent.VK_LEFT:
                        camera = camera.left(speed);
                        break;
                    case KeyEvent.VK_RIGHT:
                        camera = camera.right(speed);
                        break;
                    case KeyEvent.VK_SPACE:
                        if (e.isControlDown())
                            camera = camera.down(speed);
                        else
                            camera = camera.up(speed);
                        break;

                    case KeyEvent.VK_I:
                        camera = camera.addZenith(0.1);
                        break;
                    case KeyEvent.VK_J:
                        camera = camera.addAzimuth(0.1);
                        break;
                    case KeyEvent.VK_K:
                        camera = camera.addZenith(-0.1);
                        break;
                    case KeyEvent.VK_L:
                        camera = camera.addAzimuth(-0.1);
                        break;
                    case KeyEvent.VK_O:
                        break;
                    case KeyEvent.VK_1:
                        camera = new Camera(new Vec3D(13, 1, 6),
                                -3, -0.5, 1.0, true);
                        break;
                    case KeyEvent.VK_2:
                        camera = new Camera(new Vec3D(0, 0, 12),
                                -8.8, -1.57, 1.0, true);
                        break;
                    case KeyEvent.VK_3:
                        camera = new Camera(new Vec3D(1, 13, 6),
                                4.5, -0.5, 1.0, true);
                        break;

                }
                super.keyPressed(e);
            }
        });


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        }, 100, FPS);
    }
/**Zde probíhá vykreslení */
    private void draw() {
        renderer.setViewMatrix(camera.getViewMatrix());
        repaint();
    }

    private void resetCamera() {
        moveX = 0;
        moveY = 0;
        moveZ = 0;
        camera = new Camera(new Vec3D(9, 9, 6.4),
                -2.44, -0.54, 1.0, true); //Hotovo
    }


    public class DrawPane extends JPanel {

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), null);
            g2d.dispose();
        }

    }
}