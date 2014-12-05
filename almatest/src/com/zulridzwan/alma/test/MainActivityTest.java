package com.zulridzwan.alma.test;

import com.zulridzwan.alma.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;

import com.zulridzwan.alma.R;

public class MainActivityTest extends
		ActivityUnitTestCase<MainActivity> {
	
	private MainActivity activity;
	private SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;

	public MainActivityTest() {
		super(MainActivity.class);
	}

	//https://www.packtpub.com/sites/default/files/3500-chapter-1-getting-started-with-testing.pdf
	protected void setUp() throws Exception {
		super.setUp();
		//Clear shared preference where login info is stored to force login
		Context c =getInstrumentation().getTargetContext();
		sharedpreferences=c.getSharedPreferences(MyPREFERENCES,c.MODE_PRIVATE);
		sharedpreferences.edit().clear().commit();
		
		//Get the activity of the tested activity (class)
		Intent intent = new Intent(c,MainActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testLoginLayout(){
		//Check if text fields and button are loaded
		assertNotNull(activity.findViewById(R.id.editText1));
		assertNotNull(activity.findViewById(R.id.editText2));
		assertNotNull(activity.findViewById(R.id.button1));
		
	}

	public void testLoginIntent(){
		String uname ="admin";
		String passw ="admin";
		// Set a value into the text fields
	    EditText tx_uname = (EditText) activity.findViewById(R.id.editText1);
	    EditText tx_passw = (EditText) activity.findViewById(R.id.editText2);
	    tx_uname.setText(uname);
	    tx_passw.setText(passw);
	    //Click the login button
	    Button btn_login = (Button) activity.findViewById(R.id.button1);
	    btn_login.performClick();

	    //Verify if SecondActivity was launched by evaluating the triggered intent
	    Intent triggeredIntent = getStartedActivityIntent();
	    assertNotNull("Intent should have triggered after button press",triggeredIntent);
		
		
	}
}
