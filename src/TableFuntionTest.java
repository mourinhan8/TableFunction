import org.junit.Test;

import static org.junit.Assert.*;

public class TableFuntionTest {

    @Test
    public void contains() {
        TableFuntion st = new TableFuntion();
        for (int i = -5; i < 5; i++) {
            st.add(i, 2 * i);
        }
        assertEquals(false, st.contains(-5, 10));
        assertEquals(true, st.contains(-5, -10));
        assertEquals(true, st.contains(-4, -8));
        assertEquals(false, st.contains(3.5, 2));
        assertEquals(false, st.contains(-7, -14));
    }

    @Test
    public void findNearestValue() {
        TableFuntion st = new TableFuntion();
        for (int i = -5; i < 5; i++) {
            st.add(i, 1 + 2 * i);
        }
        assertEquals(new Point(-4, -7), st.findNearestValue(-3.9));
        assertEquals(new Point(0, 1), st.findNearestValue(-0.25));
        assertEquals(new Point(1, 3), st.findNearestValue(0.5));
        assertEquals(new Point(3, 7), st.findNearestValue(3));
        assertEquals(new Point(4, 9), st.findNearestValue(4));
        assertEquals(new Point(1, 3), st.findNearestValue(1));
        st.remove(-4);
        assertEquals(new Point(-3, -5), st.findNearestValue(-3.9));
        st.remove(3);
        assertEquals(new Point(4, 9), st.findNearestValue(3));
    }
    @Test
    public void interpolate() {
        TableFuntion st = new TableFuntion();
        for (int i = -5; i < 5; i++) {
            st.add(i, 2 * i);
        }
        assertEquals(-6.0, st.interpolate(-3), 1.0E-05);
        assertEquals(4.0, st.interpolate(2), 1.0E-05);
        assertEquals(11.599999999999852, st.interpolate(5.8), 1.0E-05);
        assertEquals(2.0, st.interpolate(1), 1.0E-05);
        assertEquals(-8.0, st.interpolate(-4), 1.0E-05);
        assertEquals(11.999999999999943, st.interpolate(6), 1.0E-05);
    }

}
