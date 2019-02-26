package util;

import Model.Vertex;

public class Lerp <V extends Vectorizable<V>> {
    public V lerp (V a, V b, double t){  //Generická třída, kteá říká že V musí dědit z Vectorizable
        return a.mul(1-t).add(b.mul(t));
    }
}
