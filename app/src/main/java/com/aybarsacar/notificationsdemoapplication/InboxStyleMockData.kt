package com.aybarsacar.notificationsdemoapplication

import android.app.NotificationManager
import androidx.core.app.NotificationCompat


object InboxStyleMockData {

  const val contentTitle = "5 new emails"
  const val contentText = "from Jane, Jay, Alex +2 more"
  const val numberOfEmails = 5
  const val priority = NotificationCompat.PRIORITY_DEFAULT

  const val bigContentTitle = "5 new emails from Jane, Jay, Alex +2 more"
  const val summaryText = "New emails"

  // notification channel values (for devices targeting 26 and above)
  const val channelId = "channel_email_1"

  const val channelName = "Email Demo"

  const val channelDescription = "Sample Email Notifications"
  const val channelImportance = NotificationManager.IMPORTANCE_DEFAULT
  const val channelEnableVibrate = true
  const val channelLockscreenVisibility = NotificationCompat.VISIBILITY_PRIVATE


  fun getIndividualEmailSummary(): ArrayList<String> {
    return arrayListOf(
      "Aybars Acar - I am on my way",
      "Zuhre Acar - Hey bro how are you?",
      "Shuang Zhao - I am a great designer",
      "Isilsu Sozgec - So proud ...",
      "Jane Johns - Check in code?"
    )
  }

  fun getParticipants(): ArrayList<String> {
    return arrayListOf(
      "Aybars Acar",
      "Zuhre Acar",
      "Shuang Zhao",
      "Isilsu Sozgec",
      "Jane Johns"
    )
  }
}