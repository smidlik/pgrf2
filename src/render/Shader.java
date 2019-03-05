package render;

import model.Vertex;
import transforms.Col;

@FunctionalInterface
public interface Shader {
    public Col shade(Vertex v);

}
