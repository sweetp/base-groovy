package org.hoschi.sweetp.services.base

/**
 * Specifies which types of parameters a service can describe.
 *
 * @author Stefan Gojan
 */
class ServiceParameter {
	/**
	 * 'projectConfig' tells the router it should inject the received client
	 * config into this parameter.
	 */
	final static PROJECT_CONFIG = 'projectConfig'

	/**
	 * 'one' specifies only one parameter with this name. If the user or another
	 * service gives more than one parameter with this name, the router chose the
	 * first parameter of the parameter array of the request.
	 */
	final static ONE = 'one'

	/**
	 * 'list' specifies a list of parameters with this name.
	 */
	final static LIST = 'list'

	/**
	 * 'request' tells the router it should inject the received request to the
	 * client. In case the client need the caller url, use 'url' instead.
	 */
	final static String REQUEST = 'request'

	/**
	 * 'url' injects the caller url. This is necessary for tcp services, which
	 * want to call other services at the same server.
	 */
	final static String URL = 'url'
}
