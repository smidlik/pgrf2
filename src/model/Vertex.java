package model;

import transforms.Col;
import transforms.Point3D;
import transforms.Vec2D;
import util.Vectorizable;

public class Vertex implements Vectorizable<Vertex> {

    private final double x, y, z;
    private Col color;
    private Vec2D texCord;
    private double one;

    public Vertex(Point3D pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
    }

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Col getColor() {
        return color;
    }
    public void setColor(Col color) {
        this.color = color;
    }

    public double getOne() {
        return one;
    }

    public void setOne(double one) {
        this.one = one;
    }

    public Point3D getPosition(){
        return new Point3D(x,y,z);
    }

    @Override
    public Vertex mul(double d) {
        return new Vertex(x * d, y * d, z * d);
    }

    @Override
    public Vertex add(Vertex a) {
        return null;
    }

    public Vertex dehomog(){
        return this.mul(1/getPosition().getW());
    }
}
