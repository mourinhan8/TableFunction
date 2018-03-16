import java.util.*;


public final class TableFuntion {
    private NavigableMap<Double, Double> table;

    TableFuntion() {
        table = new TreeMap<>();
    }

    public boolean contains(double x, double y) {
        return table.containsKey(x) && table.get(x) == y;
    }

    public void add(double x, double y) {
        if (!contains(x, y)) {
            table.put(x, y);
        }
    }

    public void remove(double x) {
        if (table.containsKey(x)) {
            table.remove(x);
        }
    }

    public ArrayList<Point> getTable() {
        ArrayList<Point> list = new ArrayList<>();
        for (double i : table.keySet()) {
            double j = table.get(i);
            Point A = new Point(i, j);
            list.add(A);
        }
        return list;
    }

    public Point findNearestValue(double x) {
        double key1 = table.floorKey(x);
        double key2 = table.ceilingKey(x);
        double range1 = Math.abs(key1 - x);
        double range2 = Math.abs(key2 - x);
        if (range1 >= range2) return new Point(key2, table.get(key2));
        else return new Point(key1, table.get(key1));
    }

    public boolean isInRange(double x) {
        return x >= table.firstKey() && x <= table.lastKey();
    }

    public double interpolate(double x) {
        if (!isInRange(x)) {
            double p;
            double f = 0;
            for (double i : table.keySet()) {
                p = 1;
                for (double j : table.keySet())
                    if (i != j) p *= (x - j) / (i - j);
                f += p * table.get(i);
            }
            return f;
        }
        if (table.containsKey(x)) return table.get(x);
        else {
            double x1 = table.floorKey(x);
            double y1 = table.get(x1);
            double x2 = table.ceilingKey(x);
            double y2 = table.get(x2);
            return (y2 - y1) * (x - x1) / (x2 - x1) + y1;
        }
    }

    @Override
    public String toString() {
        return "TableFuntion [table=" + table + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((table == null) ? 0 : table.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TableFuntion other = (TableFuntion) obj;
        if (table == null) {
            if (other.table != null)
                return false;
        } else if (!table.equals(other.table))
            return false;
        return true;
    }

}