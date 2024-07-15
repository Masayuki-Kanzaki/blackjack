package src.test.java.blackjack;

import org.junit.*;
import src.main.java.blackjack.TipController;

public class TipControllerTest {
    @Test
    public void Initial_Credit() {
        TipController tc = new TipController();
        Assert.assertEquals(100,tc.getCredit());
    }
    @Test
    public void bet_tip() {
        TipController tc = new TipController();
        tc.bet(20);
        Assert.assertEquals(80,tc.getCredit());
        Assert.assertEquals(20,tc.getTip());
    }
    @Test
    public void confiscate_tip() {
        TipController tc = new TipController();
        tc.bet(30);
        Assert.assertEquals(70,tc.getCredit());
        Assert.assertEquals(30,tc.getTip());
        tc.confiscate();
        Assert.assertEquals(70,tc.getCredit());
        Assert.assertEquals(0,tc.getTip());
    }
    @Test
    public void return_Tip() {
        TipController tc = new TipController();
        tc.bet(40);
        Assert.assertEquals(60,tc.getCredit());
        Assert.assertEquals(40,tc.getTip());
        tc.returnTip();
        Assert.assertEquals(100,tc.getCredit());
        Assert.assertEquals(0,tc.getTip());
    }
    @Test
    public void minus_tip() {
        TipController tc = new TipController();
        tc.bet(-10);
        Assert.assertEquals(100,tc.getCredit());
        Assert.assertEquals(0,tc.getTip());
    }
    @Test
    public void get_Dividend() {
        TipController tc = new TipController();
        tc.bet(50);
        Assert.assertEquals(50,tc.getCredit());
        Assert.assertEquals(50,tc.getTip());
        tc.getDividend(1.5);
        Assert.assertEquals(175,tc.getCredit());
        Assert.assertEquals(0,tc.getTip());
    }
}
