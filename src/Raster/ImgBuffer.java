package Raster;

import java.awt.image.BufferedImage;

public class ImgBuffer implements Raster<Integer>{

    private BufferedImage img;

    public ImgBuffer(int width, int height) {
    img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    }


    @Override
    public void set(int x, int y, Integer value) {
        img.setRGB(x,y,value);
    }

    @Override
    public Integer get(int x, int y) {
        return img.getRGB(x,y);
    }

    @Override
    public int getWidth() {
        return img.getWidth();
    }

    @Override
    public int getHeight() {
       return img.getHeight();
    }
}
