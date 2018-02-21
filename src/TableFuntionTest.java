import org.junit.Test;
import static org.junit.Assert.*;

public class TableFuntionTest {
    @Test
    public void findNearestValue() {
        TableFuntion st = new TableFuntion();
        for (int i = -5; i < 5; i++) {
            st.add(i, 1 + 2 * i);
        }
        assertEquals("(-4.0, -7.0)", st.findNearestValue(-3.9));
        assertEquals("(0.0, 1.0)", st.findNearestValue(-0.25));
        assertEquals("(0.0, 1.0)", st.findNearestValue(0.5));
        assertEquals("(3.0, 7.0)", st.findNearestValue(3));
        assertEquals("(4.0, 9.0)", st.findNearestValue(4));
        assertEquals("(1.0, 3.0)", st.findNearestValue(1));
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
    @Test
    public void show(){
        TableFuntion st = new TableFuntion();
        for (int i = -5; i < 5; i++) {
            st.add(i, 2 * i);
        }
        assertEquals("(-5.0, -10.0), (-4.0, -8.0), (-3.0, -6.0), (-2.0, -4.0), (-1.0, -2.0), (0.0, 0.0), (1.0, 2.0), (2.0, 4.0), (3.0, 6.0), (4.0, 8.0)", st.show());
        st.remove(-4.0);
        assertEquals("(-5.0, -10.0), (-3.0, -6.0), (-2.0, -4.0), (-1.0, -2.0), (0.0, 0.0), (1.0, 2.0), (2.0, 4.0), (3.0, 6.0), (4.0, 8.0)", st.show());
        st.remove(3);
        assertEquals("(-5.0, -10.0), (-3.0, -6.0), (-2.0, -4.0), (-1.0, -2.0), (0.0, 0.0), (1.0, 2.0), (2.0, 4.0), (4.0, 8.0)", st.show());
        st.remove(-7);
        assertEquals("(-5.0, -10.0), (-3.0, -6.0), (-2.0, -4.0), (-1.0, -2.0), (0.0, 0.0), (1.0, 2.0), (2.0, 4.0), (4.0, 8.0)", st.show());
    }
}
