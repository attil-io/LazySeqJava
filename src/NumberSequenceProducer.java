
public class NumberSequenceProducer implements NextValueProducer {
	private int counter = 0;
	
	
	@Override
	public Object getNextValue() {
		Integer ret = counter;
		++counter;
		return ret;
	}

}
