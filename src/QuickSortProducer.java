import java.util.ArrayList;
import java.util.List;

public class QuickSortProducer implements NextValueProducer {

	private List<Object> work;
	
	public QuickSortProducer(List<Integer> nums) {
		work = new ArrayList<>();
		List<Integer> temp = new ArrayList<>(nums);
		work.add(temp);
	}

	@Override
	public Object getNextValue() {

		List workCopy = new ArrayList<>(work);
		
		while (true) {
		
			List part = new ArrayList<>((List)workCopy.get(0));
			List parts = new ArrayList<>(workCopy.subList(1, workCopy.size()));
			
			if (part.size() > 0) {
				int pivot = (int)part.get(0);
				List xs = part.subList(1, part.size());
				
				List<Integer> smallers = new ArrayList<>();
				List<Integer> biggers = new ArrayList<>();
				
				for (Object xObj : xs) {
					int x = (int)xObj;
					if (x < pivot) {
						smallers.add(x);
					}
					else if (x > pivot) {
						biggers.add(x);
					}
				}
				
				workCopy = new ArrayList<>();
				workCopy.add(smallers);
				workCopy.add(pivot);
				workCopy.add(biggers);
				workCopy.addAll(parts);
			}
			else {
				if (parts.size() > 0) {
					work = new ArrayList<>(parts.subList(1, parts.size()));
					return parts.get(0);
				}
				else {
					return null;
				}
			}
		}		
	}

}
