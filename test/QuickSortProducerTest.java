import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class QuickSortProducerTest {

	@Test
	public void testQuickSortEmptyList() {
		List<Integer> numsToSort = new ArrayList<>();
		LazySequence seq = new LazySequence(new QuickSortProducer(numsToSort));
		
		Object elem = seq.getNthElement(0);

		assertNull(elem);
	}

	@Test
	public void testQuickSortOneElementList() {
		List<Integer> numsToSort = new ArrayList<>();
		numsToSort.add(2);
		
		LazySequence seq = new LazySequence(new QuickSortProducer(numsToSort));

		assertEquals(2, seq.getNthElement(0));
		assertEquals(null, seq.getNthElement(1));
	}
	
	@Test
	public void testQuickSortUnsortedList() {
		List<Integer> numsToSort = new ArrayList<>();
		numsToSort.add(2);
		numsToSort.add(1);
		numsToSort.add(4);
		numsToSort.add(3);
		
		LazySequence seq = new LazySequence(new QuickSortProducer(numsToSort));

		assertEquals(1, seq.getNthElement(0));
		assertEquals(2, seq.getNthElement(1));
		assertEquals(3, seq.getNthElement(2));
		assertEquals(4, seq.getNthElement(3));
		assertEquals(null, seq.getNthElement(4));
	}

}
