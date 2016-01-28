import java.util.ArrayList;
import java.util.List;

public class LazySeqMain {

	public static void main(String[] args) {
		List<Integer> numsToSort = new ArrayList<>();
		numsToSort.add(2);
		numsToSort.add(1);
		numsToSort.add(4);
		numsToSort.add(3);
		
		LazySequence seq = new LazySequence(new QuickSortProducer(numsToSort));

		for (int i = 0; i < 10; ++i) {
			System.err.println(seq.getNthElement(i));
		}

	}

}
