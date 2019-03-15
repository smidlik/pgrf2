package render;

import model.Part;
import model.Solid;
import model.Vertex;
import raster.Visibility;
import transforms.Mat4;
import util.Lerp;

public class Renderer {



    private Mat4 viewMatrix, modelMatrix, projeMatrix;
    private Triangle rTriangle;
    private Point rPoint;
    private Line rLine;
    private Line line;
    private Point point;
    private Lerp<Vertex> lerp = new Lerp();

    public Renderer(Visibility visibility) {
        this.rTriangle = new Triangle(visibility);
        this.rPoint = new Point(visibility);
        this.rLine = new Line(visibility);

    }


    public void render(Solid solid) {
        for (Part part : solid.getParts()) {
            switch (part.getType()) {
                case LINES:
                    renderLine();
                    break;
                case TRIANGLES:
                    for (int i = 0; i < part.getCount(); i++) {
                        Vertex a, b, c;

                        a = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3 * i + part.getStart()));
                        b = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3 * i + part.getStart() + 1));
                        c = solid.getVertexBuffer().get(solid.getIndexBuffer().get(3 * i + part.getStart() + 2));
                        renderTriangle(a, b, c);
                    }
                    break;
                case POINTS:
                    for (Vertex vertex : solid.getVertexBuffer()) {
                        renderPoint(vertex);
                    }
                    break;
                case LINE_LOOP:

                    break;
                case LINE_STRIP:

                    break;
                case TRIANGL_FAN:

                    break;
                case TRIANGL_STRIP:

                    break;
            }

        }
    }

    private void renderLine() {

    }

    private void renderPoint(Vertex a) {




        rPoint.rasterize(a);
    }


    private void renderTriangle(Vertex a, Vertex b, Vertex c) {

        //TODO: transformace
        //TODO: orez - rychle
        //TODO: o


        // Seřazení A<B<C
        if (a.getPosition().getZ() < b.getPosition().getZ()) {
            Vertex pom = a;
            a = b;
            b = pom;
        }
        if (b.getPosition().getZ() < c.getPosition().getZ()) {
            Vertex pom = b;
            b = c;
            c = pom;
        }
        if (a.getPosition().getZ() < c.getPosition().getZ()) {
            Vertex pom = a;
            a = c;
            c = pom;
        }

        if (a.getPosition().getZ() < 0) {
            return;
        }
        if (b.getPosition().getZ() < 0) {
            double t1 = -b.getPosition().getZ() / (a.getPosition().getZ() - b.getPosition().getZ());

            //Výpočet interpolace
            Vertex ab = lerp.lerp(b, a, t1);
            Vertex ac = lerp.lerp(c, a, t1);

            //Rasterizace
            rTriangle.rasterize(a, ab, ac);
            rTriangle.rasterize(a, b, ac);

        }
        if (c.getPosition().getZ() < 0) {
            double t1 = -b.getPosition().getZ() / (a.getPosition().getZ() - b.getPosition().getZ());

            Vertex bc = lerp.lerp(c, b, t1);

            rTriangle.rasterize(bc, b, a);
        }
        if (c.getPosition().getZ() >= 0) {
            rTriangle.rasterize(a, b, c);
        }

    }

    public Mat4 getViewMatrix() {
        return viewMatrix;
    }

    public void setViewMatrix(Mat4 viewMatrix) {
        this.viewMatrix = viewMatrix;
    }

    public Mat4 getModelMatrix() {
        return modelMatrix;
    }

    public void setModelMatrix(Mat4 modelMatrix) {
        this.modelMatrix = modelMatrix;
    }

    public Mat4 getProjeMatrix() {
        return projeMatrix;
    }

    public void setProjeMatrix(Mat4 projeMatrix) {
        this.projeMatrix = projeMatrix;
    }
}

