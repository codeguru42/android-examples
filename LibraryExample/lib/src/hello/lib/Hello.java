package hello.lib;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Hello extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        this.helloButton = (Button) this.findViewById(R.id.hello_button);
        this.helloButton.setOnClickListener(onHello);
    }
    private View.OnClickListener onHello = new View.OnClickListener() {
        public void onClick(View view) {
            Toast.makeText(Hello.this, "Hello, Library!", Toast.LENGTH_LONG).show();
        }
    };
    private Button helloButton = null;
}
