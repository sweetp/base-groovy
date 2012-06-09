package org.hoschi.sweetp.services.base

/**
 * Specification of methods on which IRouter routes the incoming request. These
 * methods describe how IRouter distinguish between different services for the
 * same target.
 *
 * @author Stefan Gojan
 */
class RouterMethod {
	/**
	 * Specifies the routing method 'config-property-exists'. For this method
	 * the router checks if the project config contains a property with name
	 * 'route.property'.
	 *
	 * Attention:
	 * This method is made to be mutual exclusive. That means only one property
	 * in the config should be set. Are more than one set the router chose the
	 * first one it finds. If another Service registers for 'hg' or 'svn', the
	 * config must contain only one of 'git', 'hg' or 'svn'.
	 *
	 * Example:
	 * [
	 * 	method: 'commit',
	 * 	route: [
	 * 			method: IRouter.CONFIG_EXISTS,
	 * 			property: 'git'
	 * 	],
	 * 	params: []
	 * ]
	 *
	 */
	final static CONFIG_EXISTS = 'config-property-exists'
}
