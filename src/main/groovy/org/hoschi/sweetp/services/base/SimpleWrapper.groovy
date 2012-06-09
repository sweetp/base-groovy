package org.hoschi.sweetp.services.base

/**
 * Wraps concrete types to simple types. These types can be converted with
 * JsonBuilder if the response goes to a tcp service which only understood json.
 *
 * @author Stefan Gojan
 */
@SuppressWarnings('AbstractClassWithoutAbstractMethod')
abstract class SimpleWrapper {
	/**
	 * Calls 'wrap' for each element in iterable
	 * @param iterable list with elements
	 * @return list of wrapped objects
	 */
	List wrap(final Iterable iterable) {
		if (iterable == null) return []
		List list = []
		iterable.each {
			list << wrap(it)
		}
		list
	}
}
