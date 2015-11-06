package com.example.lulu.alarma;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;

/**
 * Created by possiblelabs on 8/29/15.
 */
public class AlarmReceiver extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 1;
    private final String ticker = "Wakeup";
    private final String title = "Alarm Title";
    private final String content = "Alarm";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mNotificationIntent = new Intent(context, Alarm.class);

        PendingIntent mContentIntent = PendingIntent.getActivity(context, 0, mNotificationIntent, PendingIntent.FLAG_ONE_SHOT);

        Notification.Builder notificationBuilder = new Notification.Builder(
                context).setTicker(ticker)
                .setSound(RingtoneManager.getActualDefaultRingtoneUri(context, RingtoneManager.TYPE_RINGTONE))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true).setContentTitle(title)
                .setContentText(content).setContentIntent(mContentIntent);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());
    }

}
