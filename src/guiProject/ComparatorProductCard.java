package guiProject;

import guiProject.interfaces.IFProductCard;

import java.util.Comparator;
/**
 * A comparator used to sort the product cards in the result list.
 * @author Anton
 *
 */
public class ComparatorProductCard implements Comparator<IFProductCard>{

	@Override
	public int compare(IFProductCard o1, IFProductCard o2) {
		return o1.compareTo(o2);
	}

}
