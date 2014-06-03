package com.zulridzwan.alma.test;

import com.zulridzwan.alma.MainActivity;
import com.zulridzwan.alma.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	//Standard constructor for unit test
	public MainActivityTest() {
		super(MainActivity.class);
	}
	/*
	 * The constructor is invoked by the test runner to instantiate the test class, 
	 * while the setUp() method is invoked by the test runner before it runs any tests 
	 * in the test class.
	 */
	
	/*
	 * Typically, in the setUp() method, you should:

Invoke the superclass constructor for setUp(), which is required by JUnit.
Initialize your test fixture state by:
-Defining the instance variables that store the state of the fixture.
-Creating and storing a reference to an instance of the Activity under test.
-Obtaining a reference to any UI components in the Activity that you want to test.
You can use the getActivity() method to get a reference to the Activity under test.
	 */
	private MainActivity mFirstTestActivity;
    private TextView tv;
	
	@Override
    protected void setUp() throws Exception {
        super.setUp();
        mFirstTestActivity = getActivity();
        tv = (TextView)mFirstTestActivity.findViewById(R.id.textView1);

    }
	
/*
 * Add Test Preconditions

As a sanity check, it is good practice to verify that the test fixture has been set up 
correctly, and the objects that you want to test have been correctly instantiated or 
initialized. That way, you won’t have to see tests failing because something was wrong 
with the setup of your test fixture. By convention, the method for verifying your 
test fixture is called testPreconditions().
 */
	public void testPreconditions() {
	    assertNotNull("mFirstTestActivity is null", mFirstTestActivity);
	    assertNotNull("mFirstTestText is null", tv);
	}
	
/*
 *Add Test Methods to Verify Your Activity

Next, add one or more test methods to verify the layout and functional behavior of your Activity.

For example, if your Activity includes a TextView, you can add a test method like this 
to check that it has the correct label text:
 */
	public void testMyFirstTestTextView_labelText() {
	    final String expected =
	            mFirstTestActivity.getString(R.string.hello_world);
	    final String actual = tv.getText().toString();
	    assertEquals(expected, actual);
	}
}
