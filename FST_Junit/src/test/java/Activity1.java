import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    static ArrayList<String> list;

    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");
    }

    @Test
    public void replaceTest() {
        System.out.println(list.get(1));
        list.set(1,"Charlie");
        assertEquals("alpha",list.get(0),"Wrong Element");
        assertEquals("Charlie", list.get(1),"Wrong Element");
    }

    @Test
    public void insertTest() {
        assertEquals(2, list.size(), "Wrong Size");
        list.add(2, "Charlie");
        assertEquals(3, list.size(), "Wrong Size");
        assertEquals("alpha", list.get(0), "Wrong Element");
        assertEquals("beta", list.get(1), "Wrong Element");
        assertEquals("Charlie", list.get(2), "Wrong Element");
    }
}