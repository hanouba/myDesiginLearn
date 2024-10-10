package com.demo.hntest.advanced.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.RemoteViews;

import com.demo.hntest.R;

import java.text.DateFormat;
import java.util.Date;

public class NewAppWidget extends AppWidgetProvider {
    private static final String TAG = "NewAppWidget_TAG";
    private static final String SHARED_PREF_FILE =
            "com.example.android.appwidgetsample";
    private static final String COUNT_KEY = "count";

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        SharedPreferences prefs =
                context.getSharedPreferences(SHARED_PREF_FILE, 0);

        int count = prefs.getInt(COUNT_KEY + appWidgetId, 0);
        Log.i(TAG, "updateAppWidget: count " + count);
        Log.i(TAG, "updateAppWidget: appWidgetId " + appWidgetId);
        count++;
        Log.i(TAG, "updateAppWidget: count++  " + count);
        //get the current time
        String dataString = DateFormat.getTimeInstance(DateFormat.SHORT).format(new Date());

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.appwidget_id, String.valueOf(appWidgetId));
        views.setTextViewText(R.id.appwidget_update, context.getResources().getString(
                R.string.date_count_format, count, dataString));

        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt(COUNT_KEY + appWidgetId, count);
        edit.apply();

        Intent intentUpdate = new Intent(context, NewAppWidget.class);
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] idArray = new int[]{appWidgetId};
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, appWidgetId, intentUpdate,PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.button_update,pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);

    }
}
