package kg.tutorialapp.lesson_41

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kg.tutorialapp.lesson_41.Data.items

class MainActivity : AppCompatActivity() {

    lateinit var recycler: RecyclerView
    lateinit var myAdapter: MyAdapter

    lateinit var notificationChannel: NotificationChannel
    lateinit var notificationManager: NotificationManager
    lateinit var builder: Notification.Builder
    private val channelId = "12345"
    private val description = "Test Notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()

        notification()
    }


    private fun setup() {

        recycler = findViewById(R.id.recyclerView)
        myAdapter = MyAdapter()

        recycler.adapter = myAdapter

        myAdapter.setItems(Data.getLongListOfItems())
    }

    private fun notification() {

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val button = findViewById<Button>(R.id.buttonForNotification)

        button.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)

            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                notificationChannel = NotificationChannel(channelId, description, NotificationManager .IMPORTANCE_HIGH)

                notificationChannel.lightColor = Color.BLUE

                notificationChannel.enableVibration(true)

                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(this, channelId)
                        .setContentTitle(getString(R.string.noticeTitle))
                        .setContentText(getString(R.string.noticeText))
                        .setSmallIcon(R.drawable .ic_baseline_notifications_active_24)
                        .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.drawable.ic_launcher_background))
                        .setContentIntent(pendingIntent)
            }
            notificationManager.notify(12345, builder.build())
        }

    }

}