package com.djx.bean;

public abstract class AbstractLookupDemo implements DemoBean {

	public abstract MyHelper getMyHelper();
	@Override
	public MyHelper getHelper() {
		// TODO Auto-generated method stub
		return getMyHelper();
	}

	@Override
	public void someOperation() {
		// TODO Auto-generated method stub
		getMyHelper().doSomethingHelpful();
	}

}
