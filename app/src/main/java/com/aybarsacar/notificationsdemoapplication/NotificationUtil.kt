package com.aybarsacar.notificationsdemoapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build


class NotificationUtil {

  fun createInboxStyleNotificationChannel(context: Context): String {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

      // the id of the channel
      val channelId = InboxStyleMockData.channelId

      // the user visible name of hte channel
      val channelName = InboxStyleMockData.channelName

      val channelDescription = InboxStyleMockData.channelDescription
      val channelImportance = InboxStyleMockData.channelImportance
      val channelEnableVibrate = InboxStyleMockData.channelEnableVibrate
      val channelLockscreenVisibility = InboxStyleMockData.channelLockscreenVisibility

      // initialise NotificationChannel
      val notificationChannel = NotificationChannel(channelId, channelName, channelImportance)
      notificationChannel.description = channelDescription
      notificationChannel.enableVibration(channelEnableVibrate)
      notificationChannel.lockscreenVisibility = channelLockscreenVisibility

      // adds NotificationChannel to system
      // Attempting to create an existing notification channel with its original values performs no operation,
      // so it is safe to perform the below sequence
      val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.createNotificationChannel(notificationChannel)

      return channelId
    }


    return ""
  }

}