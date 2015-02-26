package guiProject;

import java.util.Comparator;

public class ComparatorProductCard implements Comparator<IFProductCard>{

	@Override
	public int compare(IFProductCard o1, IFProductCard o2) {
		return o1.compareTo(o2);
	}

}
