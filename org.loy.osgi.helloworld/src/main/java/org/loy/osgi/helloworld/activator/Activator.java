package org.loy.osgi.helloworld.activator;

import java.util.ArrayList;
import java.util.List;

import org.loy.osgi.helloworld.Hello;
import org.loy.osgi.helloworld.impl.HelloImpl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	private static BundleContext context;
    private List<ServiceRegistration> registrations = new ArrayList<ServiceRegistration>();

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
	    System.out.println("[Activator].start");
		Activator.context = bundleContext;
        ServiceRegistration svcReg = context.registerService(Hello.class.getName(), new HelloImpl("Hello OSGI"), null);
        registrations.add(svcReg);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("[Activator].stop");
		Activator.context = null;
        for (ServiceRegistration svcReg : registrations) {
            System.out.println("unregistering : " + svcReg);
            svcReg.unregister();
        }
	}

}
