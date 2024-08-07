package gsdk.source.vectors;

import com.raylib.Raylib;

/**
 * Float 2D Vector.
 */
public class Vector2Df {
    private float x, y;

    /**
     * Create new 2D float vector.
     */
    public Vector2Df(float x_, float y_) {
        x = x_;
        y = y_;
    }

    /**
     * Set X.
     */
    public void x(float x_) {
        x = x_;
    }

    /**
     * Get X.
     */
    public float x() {
        return x;
    }

    /**
     * Set Y.
     */
    public void y(float y_) {
        y = y_;
    }

    /**
     * Get Y.
     */
    public float y() {
        return y;
    }

    /**
     * Cast vector to Raylib vector.
     */
    public Raylib.Vector2 toRlVec() {
        return new Raylib.Vector2().x(x).y(y);
    }

    /**
     * Cast vector to array.
     */
    public float[] toArray() {
        return new float[] {x, y};
    }

    /**
     * Cast vector to double array.
     */
    public double[] toDoubleArray() {
        return new double[] {(double) x, (double) y};
    }

    /**
     * Shortcut for creating 2D float vector.
     */
    public static Vector2Df vec2df(int x, int y) {
        return new Vector2Df(x, y);
    }
}
