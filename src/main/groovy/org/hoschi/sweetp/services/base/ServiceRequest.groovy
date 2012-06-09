package org.hoschi.sweetp.services.base

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper
import groovy.transform.ToString

/**
 * Extended http request class with more specific information about the service
 * call.
 *
 * @author Stefan Gojan
 */
@ToString
class ServiceRequest extends HttpServletRequestWrapper implements HttpServletRequest {
	String target
	String projectName
	Map projectConfig
	Map parameterValues
	private static HttpServletRequest dummy = [] as HttpServletRequest

	/**
	 * Create a request object with a dummy HttpServletRequest as super.
	 */
	ServiceRequest() {
		super(dummy)
		target = ''
		projectName = ''
		projectConfig = [:]
		parameterValues = [:]
	}

	/**
	 * Wrap a normal http request and extend it with more attributes.
	 *
	 * @param request object to extend/wrap
	 */
	ServiceRequest(HttpServletRequest request) {
		super(request)
		target = request.requestURI
		projectName = ''
		projectConfig = [:]
		parameterValues = [:]
	}

	/**
	 * Get all parameter values, whether they come from the extended map or the
	 * original request object.
	 *
	 * @param name of parameter
	 * @return values
	 */
	@Override
	String[] getParameterValues(String name) {
		List values = []

		if (super.request != dummy) {
			values = super.getParameterValues(name)
			if (!values) {
				values = []
			}
		}

		if (parameterValues."$name") {
			values.addAll(parameterValues."$name")
		}

		values
	}

	/**
	 * Convert this instance to a map instance.
	 * @return this as a map
	 */
	Map toMap() {
		Map map = [
		        target: target,
				localAddr: localAddr,
				localPort: localPort,
				scheme: scheme
		]
		map
	}
}
