package map.shiveh.ir.mapsdk.features.network.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by Ahetesum on 10/30/17.
 */
public class SessionAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        SessionManager.getInstance(context).sessionAlarmReceived(intent);
    }
}
