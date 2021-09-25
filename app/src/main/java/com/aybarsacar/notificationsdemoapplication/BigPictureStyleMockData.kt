package com.aybarsacar.notificationsdemoapplication

import android.app.NotificationManager
import androidx.core.app.NotificationCompat

object BigPictureStyleMockData {

  const val contentTitle = "Aybars's Post"
  const val contentText = "[Picture] Like my new shot of my dog?"
  const val priority = NotificationCompat.PRIORITY_HIGH

  const val bigImage = R.drawable.dog
  const val bigContentTitle = "Aybars's Post"
  const val summaryText = "Like my new shot of my dog?"

  const val channelId = "channel_social_1"

  const val channelName = "Social Demo"

  const val channelDescription = "Sample Picture Notifications"
  const val channelImportance = NotificationManager.IMPORTANCE_HIGH
  const val channelEnableVibrate = true
  const val channelLockscreenVisibility = NotificationCompat.VISIBILITY_PRIVATE

  fun getParticipants(): ArrayList<String> {
    return arrayListOf(
      "Aybars Acar",
    )
  }
}