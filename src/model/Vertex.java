package model;

import transforms.Col;
import transforms.Point3D;
import transforms.Vec2D;
import util.Vectorizable;

public class Vertex implements Vectorizable<Vertex> {

    private Point3D pos;
    private Col color;
    private Vec2D texCord;
    private double one;

    public Vertex(Point3D pos) {
        this.pos = pos;
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
        return null;
    }

    @Override
    public Vertex mul(double t) {
        return null;
    }

    @Override
    public Vertex add(Vertex a) {
        return null;
    }

    public Vertex dehomog(){
        return this.mul(1/getPosition().getW());
    }
}
