package example.intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentExample extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        Button launchButton = (Button) this.findViewById(R.id.launch_button);
        launchButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Uri uri = new Uri.Builder().scheme("content").authority("example.intent").appendPath("intent_example").build();
                Intent intent = new Intent(Intent.ACTION_EDIT, uri);
                intent.setType("vnd.intent.cursor.item/intent_example");
                IntentExample.this.startActivity(intent);
            }
        });
    }
}
