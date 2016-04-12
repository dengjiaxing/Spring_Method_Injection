package com.djx.bean;

public class StandardLookupDemo implements DemoBean {

	private MyHelper myHelper;
	
	public MyHelper getMyHelper() {
		return myHelper;
	}

	public void setMyHelper(MyHelper myHelper) {
		myHelper = myHelper;
	}

	@Override
	public MyHelper getHelper() {
		// TODO Auto-generated method stub
		return myHelper;
	}

	@Override
	public void someOperation() {
		// TODO Auto-generated method stub
		myHelper.doSomethingHelpful();
	}

}
