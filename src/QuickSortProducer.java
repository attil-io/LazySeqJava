import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSortProducer implements NextValueProducer {

	private List<Object> work;
	
	public QuickSortProducer(List<Integer> nums) {
		work = new ArrayList<>();
		List<Integer> temp = new ArrayList<>(nums);
		work.add(temp);
	}

/*	
	(defn sort-parts [work]
			  (lazy-seq
			    (loop [[part & parts] work] (do (println (str "work='" work "' part='' parts='" parts "'"))
			      (if-let [[pivot & xs] (seq part)]
			              (do  (println (str "if-let: true! pivot='" pivot "' xs='" xs "'"))
			              (let [smaller? #(< % pivot)]
			                   (recur (list*
			                           (filter smaller? xs)
			                           pivot
			                           (remove smaller? xs)
			                           parts))))
			              (when-let [[x & parts] parts]
			                   (println (str "if-let: false! x='" x "' parts='" parts "'"))
			                   (cons x (sort-parts parts))))))))
*/	
	
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
