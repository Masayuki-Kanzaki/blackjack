package src.main.java.blackjack;

public class TipController {
    final int INITIAL_CREDIT = 100;
	private int credit;
	private int tip;

	public TipController() {
		setCredit(INITIAL_CREDIT); 
	}

	public String toString() {
		return "[ credit = " + credit + " ]";
	}

	private void setCredit(int c) {
		credit = c;	
	}

	public int getCredit() {
		return credit;	
	}

	private void setTip(int t) {
		tip = t;	
	}

	public int getTip() {
		return tip;	
	}

	public void bet(int tip) {
		if (tip < 0) {
			tip = 0;
		}
		setTip(tip);	
		credit = credit - tip;
	}

	public void confiscate() {
		tip = 0;	
	}

	public void returnTip() {
		credit = credit + tip;
		tip = 0;	
	}
}
