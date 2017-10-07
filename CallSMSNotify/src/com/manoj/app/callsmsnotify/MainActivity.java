package com.manoj.app.callsmsnotify;

import android.app.Activity;
import android.os.Bundle;
//import android.support.v7.app.ActionBarActivity;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


public class MainActivity extends Activity {

	ToggleButton tg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tg = (ToggleButton) findViewById(R.id.toggleButton1);
        tg.setChecked(helper.isenabled);
        tg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                	  helper.isenabled = true;  
                } else {
                	helper.isenabled = false;
                }
            }
        });
    }
    
  


}
