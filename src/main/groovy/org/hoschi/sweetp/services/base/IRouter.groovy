package org.hoschi.sweetp.services.base

/**
 * Interface for a service request router. A JVM service is able to have a
 * property which name 'router' and as type this interface. After the server
 * created an instance of the service, it injects his router instance into the
 * 'router' property. In this manner a JVM service can easily call other
 * services.
 *
 * @author Stefan Gojan
 */
interface IRouter {
	/**
	 * Call a service method.
	 * @param request for the service and it's method
	 * @return what the called service returns as simple type (String, Map, List,
	 * int, float, long, bool, null)
	 */
	Object route(ServiceRequest request)

	/**
	 * Get a HookManager to call hooks which the service methods publishes.
	 * @return the one and only hook manager of the system
	 */
	IHookManager getHooks()
}
