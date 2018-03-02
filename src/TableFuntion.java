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

    public TreeMap<Double, Double> show() {
        return (TreeMap<Double, Double>) table;
    }

    public Point findNearestValue(double x) {
        double key1 = table.floorKey(x);
        double key2 = table.ceilingKey(x);
        double range1 = Math.abs(key1 - x);
        double range2 = Math.abs(key2 - x);
        if (range1 >= range2) return new Point(key2, table.get(key2));
        else return new Point(key1, table.get(key1));
    }

    public double interpolate(double x) {
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
