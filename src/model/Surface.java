package model;

import transforms.Bicubic;
import transforms.Cubic;
import transforms.Point3D;

public class Surface extends Solid {

    private Point3D[] controlPoints = new Point3D[16];   //matice řídících bodů

    public Surface() {
        for (int i = 0; i < 16; i++) {
            controlPoints[i] = new Point3D();
        }
        Bicubic bc = new Bicubic(Cubic.BEZIER, controlPoints);
        int index = 0;
        for (float u = 0; u <= 1; u += 0.1) {
            for (float v = 0; v <= 1; v += 0.1) {
                Vertex vertex = new Vertex(bc.compute(u, v));
                getVertexBuffer().add(vertex);
                getIndexBuffer().add(index);

            }
        }
    }
}
