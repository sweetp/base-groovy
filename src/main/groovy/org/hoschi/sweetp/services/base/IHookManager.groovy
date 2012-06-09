package org.hoschi.sweetp.services.base

/**
 * A IHookManager is responsible to manage published and subscribed hooks from
 * the registered services.
 *
 * @author Stefan Gojan
 */
interface IHookManager {

	/**
	 * Calls a hook and get data from the processed services back.
	 * 
	 * @param name of hook to call in url path form
	 * @param params for the call
	 * @param projectConfig for the call
	 * @return a map which can contain data but must has a allOk key.
	 * The value of the allOk key is an indicator to stop or continue further
	 * execution of calling service.
	 */
	Map callHook(String name, Map params, Map projectConfig)
}
