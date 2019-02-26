package raster;

import transforms.Col;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Visibility {

    private ImgBuffer imgBuffer;
    private ZBuffer<Float> zBuffer;
    private int width;
    private int heigth;

    public Visibility(int width, int heigth) {
        this.heigth = heigth;
        this.width = width;
        this.imgBuffer = new ImgBuffer(width, heigth);
        this.zBuffer = new ZBuffer<Float>(width, heigth);
        init(Color.BLACK.getRGB());
    }

    public void put(int x, int y, float z, Col color) {
        if (z < zBuffer.get(x, y)) {
            imgBuffer.set(x, y, color.getRGB());
            zBuffer.set(x, y, z);
        }
    }

    public void init(int color) {
        //*
        for (int i = 0; i < imgBuffer.getHeight(); i++) {
            for (int j = 0; j < imgBuffer.getWidth(); j++) {
                //imgBuffer.set(i,j,color);
                zBuffer.set(j,i,1f); //místo 1f je správně: new Float(1)
            }
        }
        /*/
        for (int i = 0; i < imgBuffer.getHeight()*imgBuffer.getHeight(); i++) {
            zBuffer.add(1f);
        }
        //*/
        imgBuffer.clear(color);
    }

    public BufferedImage getBufferedImage() {
        return imgBuffer.getImg();
    }
}
