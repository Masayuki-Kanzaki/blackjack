package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.Points;

public class PointsTest {
    @Test
    public void Initial_Points() {
        Points p1 = new Points(1);
        Assert.assertEquals(1,p1.getPoints());
        Points p2 = new Points(2);
        Assert.assertEquals(2,p2.getPoints());
        Assert.assertFalse(p2.isBust());
        Points p22 = new Points(22);
        Assert.assertEquals(22,p22.getPoints());
        Assert.assertTrue(p22.isBust());
//      Points p0 = new Points(0);
//      Assert.assertEquals(0,p0.getPoints());
    }

}
