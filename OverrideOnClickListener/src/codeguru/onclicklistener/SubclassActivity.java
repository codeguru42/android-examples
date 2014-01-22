package codeguru.onclicklistener;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class SubclassActivity extends MainActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		View textView = findViewById(R.id.button1);
		textView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(SubclassActivity.this, "SubclassActivity",
						Toast.LENGTH_LONG).show();
			}
		});
	}

}
