package codeguru.notificationexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import codeguru.notificationexample.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notificationButton.setOnClickListener {
            Snackbar.make(binding.root, "Button clicked", Snackbar.LENGTH_LONG).show()
        }
    }
}
