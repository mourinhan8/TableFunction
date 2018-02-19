import java.util.ArrayList;


public final class TableFuntion {
    private ArrayList<Double> listX;
    private ArrayList<Double> listY;

    TableFuntion() {
        listX = new ArrayList<>();
        listY = new ArrayList<>();
    }

    public void add(double x, double y) {
        listX.add(x);
        listY.add(y);
    }


    public void remove(double x) {
        int ind = listX.indexOf(x);
        if (ind >= 0) {
            listX.remove(new Double(x));
            listY.remove(ind);
        }
    }

    public String show() {
        StringBuilder st = new StringBuilder();
        int n = listX.size();
        for (int i = 0; i < n; i++) {
            st.append("(" + listX.get(i) + ", " + listY.get(i) + ")").append(", ");
        }
        return st.toString();
    }

    public boolean contains(double x, double y) {
        return listX.indexOf(x) >= 0 && listY.get(listX.indexOf(x)) == y;
    }

    public ArrayList<Double> findNearestValue(double x) {
        double minrange = Math.abs(x - listX.get(0));
        int location = 0;
        int n = listX.size();
        for (int i = 0; i < n; i++) {
            double range = Math.abs(x - listX.get(i));
            if (range < minrange) {
                minrange = range;
                location = i;
            }
        }
        double findX = listX.get(location);
        double findY = listY.get(location);
        ArrayList res = new ArrayList();
        res.add(findX);
        res.add(findY);
        return res;
    }

    public double interpolate(double x) {
        int n = listX.size();
        double p;
        double f = 0;
        for (int i = 0; i < n; i++) {
            p = 1;
            for (int j = 0; j < n; j++)
                if (i != j) p *= (x - listX.get(j)) / (listX.get(i) - listX.get(j));
            f += p * listY.get(i);
        }
        return f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TableFuntion{ table =\n");
        int n = listX.size();
        for (int i = 0; i < n; i++)
            sb.append("(" + listX.get(i) + ", " + listY.get(i) + ")").append(" ");
        return sb.toString();
    }

}
