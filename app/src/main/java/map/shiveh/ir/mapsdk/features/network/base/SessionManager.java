package map.shiveh.ir.mapsdk.features.network.base;

import android.content.Context;
import android.content.Intent;

import map.shiveh.ir.mapsdk.app.helpers.SessionHelper;
import map.shiveh.ir.mapsdk.app.services.PreferenceService;


/**
 * Created by Ahetesum on 10/28/17.
 */
public class SessionManager {

    public static final int REQUEST_CODE_SESSION_TIMEOUT_PENDING_INTENT = 0x1000;
    public static final int SESSION_TIMEOUT_DURATION = 1000*60*20 ;

    private static SessionManager sessionManager;
    private Context context;
    private SessionListener listener;

    private SessionManager(Context context) {
        this.context = context;
    }

    public static SessionManager getInstance(Context context) {
        if (sessionManager == null) {
            sessionManager = new SessionManager(context);
        }
        return sessionManager;
    }

    public void setListener(SessionListener listener) {
        this.listener = listener;
    }

    public void startSession() {
        if (context != null)
            SessionHelper.setSessionAlarm(context, SESSION_TIMEOUT_DURATION, REQUEST_CODE_SESSION_TIMEOUT_PENDING_INTENT);
    }

    /**
     * This function will just stop the alarm set for session. This will not clear session data from preferences
     */
    public void finishSession() {
        if (context != null)
            SessionHelper.cancelAlarm(context, REQUEST_CODE_SESSION_TIMEOUT_PENDING_INTENT);
        listener = null;
        sessionManager = null;
        context = null;
    }

    public void sessionAlarmReceived(Intent intent) {
        sessionExpired();
    }

    /**
     * This function will clear session data from preferences and finish the session
     */
    public void sessionExpired() {
        if (context != null)
           PreferenceService.Companion.getInstance(context).clearUserInfo();

        if (listener != null)
            listener.onSessionExpired();

        finishSession();
    }

    public void updateSessionIfAvailable() {
        if (context != null)
            startSession();
    }

    public interface SessionListener {
        void onSessionExpired();
    }
}