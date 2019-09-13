package with.fun.tddrules.change;

import androidx.annotation.NonNull;

public class Money implements Expression {
	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	@Override
	public Expression times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}

	public String currency() {
		return this.currency;
	}

	@Override
	public Expression plus(Expression added) {
		return new Sum(this, added);
	}

	@Override
	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}

	@Override
	public boolean equals(Object object) {
		Money money = (Money) object;
		return amount == money.amount
				&& currency().equals(money.currency());
	}

	@NonNull
	@Override
	public String toString() {
		return amount + " " + currency;
	}
}
