package src.main.java.blackjack;

public class Points {
    // point classがあった方がいいと思ったが、未使用
    static final int MIN = 1;
    static final int MAX = 21;

    int points;

    boolean blackjack = false;
    boolean bust = false;

    public Points(int points) {
        if (points < MIN) {throw new
            IllegalArgumentException("不正：" + MIN + "未満");
        }
        if (points > MAX) {
            bust = true;
        }
        this.points = points;
    }

    // カード２枚を見てからセットするため、他のクラスになるか検討要
    public boolean isBlackjack() {
        return blackjack;
    }

    public boolean isBust() {
        return bust;
    }

    public int getPoints() {
        return points;
    }
}
