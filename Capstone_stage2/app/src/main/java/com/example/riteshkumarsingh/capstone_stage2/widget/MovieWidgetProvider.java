package com.example.riteshkumarsingh.capstone_stage2.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.activities.HomeActivity;

/**
 * Created by riteshkumarsingh on 08/05/17.
 */

public class MovieWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds){
            updateAppWidget(context,appWidgetManager,appWidgetId);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    private void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {
        String widgetText =  context.getString(R.string.movie_widget_text);

        Intent intent = new Intent(context, HomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.movie_widget_layout);
        views.setTextViewText(R.id.appwidget_text, widgetText);

        views.setRemoteAdapter(R.id.widget_list,
                new Intent(context, MovieWidgetService.class));

        views.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }
}
