/*
 * This program is free software. It comes without any warranty, to
 * the extent permitted by applicable law. You can redistribute it
 * and/or modify it under the terms of the Do What The Fuck You Want
 * To Public License, Version 2, as published by Sam Hocevar. See
 * http://sam.zoy.org/wtfpl/COPYING for more details.
 */
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
