package com.aybarsacar.notificationsdemoapplication

import android.app.Notification
import android.app.PendingIntent
import android.app.Person
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

  private val _notificationId = 10
  private lateinit var _notificationManagerCompat: NotificationManagerCompat

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    _notificationManagerCompat = NotificationManagerCompat.from(this@MainActivity)

    val buttonInboxStyleNotification = findViewById<Button>(R.id.btn_inbox_style)
    buttonInboxStyleNotification.setOnClickListener(this@MainActivity)

    val bigImageStyleNotification = findViewById<Button>(R.id.btn_big_image_style)
    bigImageStyleNotification.setOnClickListener(this@MainActivity)
  }


  override fun onClick(view: View?) {
    when (view!!.id) {
      R.id.btn_inbox_style -> {
        generateInboxStyleNotification()
        return
      }

      R.id.btn_big_image_style -> {
        generateBigPictureStyleNotification()
        return
      }
    }
  }


  private fun generateBigPictureStyleNotification() {

    val notificationChannelId = NotificationUtil().createBigPictureStyleNotificationChannel(this@MainActivity)

    val bigPictureStyle = NotificationCompat.BigPictureStyle()
      .bigPicture(BitmapFactory.decodeResource(resources, BigPictureStyleMockData.bigImage))
      .setBigContentTitle(BigPictureStyleMockData.bigContentTitle)
      .setSummaryText(BigPictureStyleMockData.summaryText)

    val mainIntent = Intent(this@MainActivity, MainActivity::class.java)

    val mainPendingIntent = PendingIntent.getActivity(
      this@MainActivity, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT
    )

    val notificationCompatBuilder = NotificationCompat.Builder(applicationContext, notificationChannelId)

    notificationCompatBuilder
      .setStyle(bigPictureStyle)
      .setContentTitle(BigPictureStyleMockData.contentTitle)
      .setContentText(BigPictureStyleMockData.contentText)
      .setSmallIcon(R.drawable.ic_baseline_email_24)
      .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_email_24))
      .setContentIntent(mainPendingIntent)
      .setDefaults(NotificationCompat.DEFAULT_ALL)
      .setColor(ContextCompat.getColor(applicationContext, R.color.purple_200))
      .setSubText(1.toString())
      .setCategory(Notification.CATEGORY_SOCIAL)
      .setPriority(BigPictureStyleMockData.priority)
      .setVisibility(BigPictureStyleMockData.channelLockscreenVisibility)

    for (name in BigPictureStyleMockData.getParticipants()) {
      notificationCompatBuilder.addPerson(name)
    }

    val notification = notificationCompatBuilder.build()

    _notificationManagerCompat.notify(_notificationId, notification)
  }


  private fun generateInboxStyleNotification() {

    val notificationChannelId = NotificationUtil().createInboxStyleNotificationChannel(this@MainActivity)

    val inboxStyle = NotificationCompat.InboxStyle()
      .setBigContentTitle(InboxStyleMockData.bigContentTitle)
      .setSummaryText(InboxStyleMockData.summaryText)

    for (summary in InboxStyleMockData.getIndividualEmailSummary()) {
      inboxStyle.addLine(summary)
    }

    // set where the notification will launch the user to
    val mainIntent = Intent(this@MainActivity, MainActivity::class.java)

    val mainPendingIntent = PendingIntent.getActivity(
      this@MainActivity, 0, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT
    )

    val notificationCompatBuilder = NotificationCompat.Builder(applicationContext, notificationChannelId)

    notificationCompatBuilder.setStyle(inboxStyle)
      .setContentInfo(InboxStyleMockData.contentTitle)
      .setContentText(InboxStyleMockData.contentText)
      .setSmallIcon(R.drawable.ic_baseline_email_24)
      .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_baseline_email_24))
      .setContentIntent(mainPendingIntent)
      .setDefaults(NotificationCompat.DEFAULT_ALL)
      .setColor(ContextCompat.getColor(applicationContext, R.color.purple_200))
      .setSubText(InboxStyleMockData.numberOfEmails.toString())
      .setCategory(Notification.CATEGORY_EMAIL)
      .setPriority(InboxStyleMockData.priority)
      .setVisibility(InboxStyleMockData.channelLockscreenVisibility)

    for (name in InboxStyleMockData.getParticipants()) {
      notificationCompatBuilder.addPerson(name)
    }

    val notification = notificationCompatBuilder.build()

    _notificationManagerCompat.notify(_notificationId, notification)
  }
}