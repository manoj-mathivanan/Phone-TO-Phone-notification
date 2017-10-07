package com.manoj.app.callsmsnotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;

public class IncomingCall extends BroadcastReceiver {
    
    public void onReceive(Context context, Intent intent) {
        
    try {
               // TELEPHONY MANAGER class object to register one listner
                TelephonyManager tmgr = (TelephonyManager) context
                        .getSystemService(Context.TELEPHONY_SERVICE);
                        
                //Create Listner
                MyPhoneStateListener PhoneListener = new MyPhoneStateListener();
                
                // Register listener for LISTEN_CALL_STATE
                tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);
        
        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    private class MyPhoneStateListener extends PhoneStateListener {

        public void onCallStateChanged(int state, String incomingNumber) {
        

            if (state == 1) {
            	if(incomingNumber.compareToIgnoreCase(helper.number)!=0)
            	{
            	helper.number = incomingNumber;

                String msg = "Call from: "+incomingNumber;

                try{
                	if(helper.isenabled)
                	{
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage("+917299066702", null, msg, null, null);
                	}
                    }
                    catch(Exception e)
                    {
                    	e.printStackTrace();
                    }
            	}
            }
        }
    }
}
