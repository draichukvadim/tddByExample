package with.fun.tddrules.change;

import java.util.HashMap;

public class Bank {
	HashMap<Key, Integer> rates = new HashMap<>();

	Money reduce(Expression source, String to) {
		return source.reduce(this, to);
	}

	int rate(String from, String to) {
		if (from.equals(to))
			return 1;
		return rates.get(new Key(from, to));
	}

	void addRate(String from, String to, int rate) {
		rates.put(new Key(from, to), rate);
	}
}
