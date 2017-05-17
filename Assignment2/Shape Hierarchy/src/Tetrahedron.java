public class Tetrahedron extends ThreeDimensionalShape {
    private Vector3D a, b, c;
    private Vector3D origA, origB, origC, origD;

    public Tetrahedron(double a0, double a1, double a2,
                       double b0, double b1, double b2,
                       double c0, double c1, double c2,
                       double d0, double d1, double d2) {
        a = new Vector3D(a0 - d0, a1 - d1, a2 - d2);
        b = new Vector3D(b0 - d0, b1 - d1, b2 - d2);
        c = new Vector3D(c0 - d0, c1 - d1, c2 - d2);

        origA = new Vector3D(a0, a1, a2);
        origB = new Vector3D(b0, b1, b2);
        origC = new Vector3D(c0, c1, c2);
        origD = new Vector3D(d0, d1, d2);
    }

    @Override
    public double getArea() {
        // 0.5 * vec(ab) dot vec(ac)
        double res = 0;

        Vector3D da, db, dc, ba, bc;
        da = a;
        db = b;
        dc = c;
        ba = a.subtract(b);
        bc = c.subtract(b);
        res += da.cross(dc).getValue();
        //System.out.println(da.cross(dc).getValue());
        res += db.cross(dc).getValue();
        //System.out.println(db.cross(dc).getValue());
        res += da.cross(db).getValue();
        //System.out.println(da.cross(db).getValue());
        res += ba.cross(bc).getValue();
        //System.out.println(ba.cross(bc).getValue());

        res /= 2;
        return res;
    }

    @Override
    public double getVolume() {
        // https://en.wikipedia.org/wiki/Tetrahedron#Volume
        return Math.abs(a.dot(b.cross(c))) / 6.0;
    }

    @Override
    public String toString() {
//        return String.format("This object is a tetrahedron. The vectors given are: %s, %s, %s, %s. The area is %f, and the volume is %f",
//                origA.toString(), origB.toString(), origC.toString(), origD.toString(), getArea(), getVolume());

        return String.format("This object is a tetrahedron. The vectors given are: %s, %s, %s, %s.",
                origA.toString(), origB.toString(), origC.toString(), origD.toString());
    }

    public String convertedToString() {
        return String.format("This object is a tetrahedron. The vectors given are: %s, %s, %s. The area is %f, and the volume is %f",
                a.toString(), b.toString(), c.toString(), getArea(), getVolume());
    }
}
