import java.util.ArrayList;
import java.util.List;

public class LazySequence {
	private NextValueProducer nvp;
	private List cache;
	
	public LazySequence(NextValueProducer nvp) {
		this.nvp = nvp;
		cache = new ArrayList<>();
	}
	
	public Object getNthElement(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("n has to be positive");
		}
		for (int i = cache.size(); i <= n; ++i) {
			Object produced = nvp.getNextValue();
			if (produced == null) {
				break;
			}
			else {
				cache.add(produced);
			}
		}
		if (cache.size() > n) {
			return cache.get(n);
		}
		else {
			return null;
		}
	}
}
