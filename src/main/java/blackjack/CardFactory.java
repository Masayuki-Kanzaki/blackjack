package src.main.java.blackjack;

// 生成ロジックが容易なため、特にファクトリーメソッドはいらないかもしれない
public class CardFactory {
    public static Card createCard(CardRank type, CardSuit mark) {
        return new Card(type, mark);
    }
}
