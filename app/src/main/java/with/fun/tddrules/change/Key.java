package with.fun.tddrules.change;

import androidx.annotation.Nullable;

public class Key {
	public String from;
	public String to;

	public Key(String from, String to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public boolean equals(@Nullable Object obj) {
		Key key = (Key) obj;
		return from.equals(key.from) && to.equals(key.to);
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
