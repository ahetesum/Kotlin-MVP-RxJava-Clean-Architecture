package map.shiveh.ir.mapsdk.app.helpers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import map.shiveh.ir.mapsdk.features.network.base.SessionAlarmReceiver;

/**
 * Created by Ahetesum on 10/25/17.
 */
public class SessionHelper
{

    public static void setSessionAlarm(Context context, int sessionTimeoutDuration, int timeoutReqCode) {
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, SessionAlarmReceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, timeoutReqCode, i, PendingIntent.FLAG_UPDATE_CURRENT);
        am.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + sessionTimeoutDuration, pi);
    }

    public static void cancelAlarm(Context context, int timeoutReqCode) {
        Intent intent = new Intent(context, SessionAlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, timeoutReqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }

}