package model;

import java.util.List;

public abstract class Solid {

    protected List<Vertex> vertexBuffer;
    protected List<Integer> indexBuffer;
    protected List<Part> parts;

    public List<Vertex> getVertexBuffer() {
        return vertexBuffer;
    }

    public List<Integer> getIndexBuffer() {
        return indexBuffer;
    }

    public List<Part> getParts() {
        return parts;
    }
}
