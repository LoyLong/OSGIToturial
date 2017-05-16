package org.loy.osgi.helloworld.impl;

import org.loy.osgi.helloworld.Hello;

public class HelloImpl implements Hello {

    final String helloString;

    public HelloImpl(String helloStringParam) {
        this.helloString = helloStringParam;
    }

    @Override
    public void sayHello() {
        System.out.println(this.helloString);
    }

}
