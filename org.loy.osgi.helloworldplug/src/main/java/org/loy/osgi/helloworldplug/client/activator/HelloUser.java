package org.loy.osgi.helloworldplug.client.activator;

import java.util.ArrayList;
import java.util.List;

import org.loy.osgi.helloworld.Hello;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

public class HelloUser implements BundleActivator {

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
        System.out.println("[HelloUser].start");
	    HelloUser.context = bundleContext;
		ServiceReference ref = context.getServiceReference(Hello.class.getName());
        if(ref != null) {
            Hello hello = null;
            try{
                hello= (Hello) context.getService(ref);
                if(hello != null)
                    hello.sayHello();
                else
                    System.out.println("Service:Hello---objectnull");
            }catch (RuntimeException e) {
                e.printStackTrace();
            }finally {
                context.ungetService(ref);
                hello= null;
            }
        }else {
            System.out.println("Service:Hello---notexists");
        }

	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("[HelloUser].stop");
	}

}
