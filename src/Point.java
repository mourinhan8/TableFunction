public class Point {
    private double x;
    private double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int res = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        res = prime * res + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        res = prime * res + (int) (temp ^ (temp >>> 32));
        return res;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point other = (Point) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "Point [" + "x = " + x + ", y = " + y + "]";
    }
}
