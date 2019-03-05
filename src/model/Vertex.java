package model;

import transforms.Point3D;
import util.Vectorizable;

public class Vertex implements Vectorizable<Vertex> {
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
