/**
 * Created by henrybear327 on 5/15/17.
 */
public class Vector3D {
    private double[] pt;

    public Vector3D(double x, double y, double z) {
        pt = new double[3];

        pt[0] = x;
        pt[1] = y;
        pt[2] = z;
    }

    public Vector3D substract(Vector3D second) {
        double u1 = this.pt[0];
        double u2 = this.pt[1];
        double u3 = this.pt[2];

        double v1 = second.pt[0];
        double v2 = second.pt[1];
        double v3 = second.pt[2];

        return new Vector3D(u1 - v1, u2 - v2, u3 - v3);
    }

    public Vector3D cross(Vector3D second) {
        double u1 = this.pt[0];
        double u2 = this.pt[1];
        double u3 = this.pt[2];

        double v1 = second.pt[0];
        double v2 = second.pt[1];
        double v3 = second.pt[2];

        return new Vector3D((u2 * v3 - u3 * v2), (u3 * v1 - u1 * v3), (u1 * v2 - u2 * v1));
    }

    public double dot(Vector3D second) {
        double u1 = this.pt[0];
        double u2 = this.pt[1];
        double u3 = this.pt[2];

        double v1 = second.pt[0];
        double v2 = second.pt[1];
        double v3 = second.pt[2];

        return u1 * v1 + u2 * v2 + u3 * v3;
    }

    public String toString() {
        return String.format("(%s, %s, %s)", pt[0], pt[1], pt[2]);
    }
}
