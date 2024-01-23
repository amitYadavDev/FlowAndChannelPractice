package amitapps.media.channelpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    var channel = Channel<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //For Channel
        producer()
        consumer()
    }

    private fun consumer() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.d("MainActivity_abc", channel.receive().toString())
            Log.d("MainActivity_abc", channel.receive().toString())
            Log.d("MainActivity_abc", channel.receive().toString())
        }
    }

    private fun producer() {
        CoroutineScope(Dispatchers.IO).launch {
            channel.send(1)
            delay(5000)
            channel.send(2)
            delay(5000)
            channel.send(3)
        }
    }
}