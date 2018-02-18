/*@author Agnes Aronsson [agar3573]*/
package Valuables;

import java.util.Comparator;

public class NameComparator implements Comparator<Valuable>{

	@Override
	public int compare(Valuable v1, Valuable v2) {
		return v1.getName().compareToIgnoreCase(v2.getName());
	}

}