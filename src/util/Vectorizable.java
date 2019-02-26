package util;

public interface Vectorizable<V> { //cokoli implementuje tuto třídu musí obsahovat metody mul a add
    V mul(double t);
    V add(V a);
}
