/*@author Agnes Aronsson [agar3573]*/
import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable>{

	@Override
	public int compare(Valuable v1, Valuable v2) {
		return Double.compare(v2.getValue(), v1.getValue());
	}

}
