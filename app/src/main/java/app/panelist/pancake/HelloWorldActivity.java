package app.panelist.pancake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class HelloWorldActivity extends AppCompatActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_helloworld);
		
		((TextView)findViewById(R.id.helloWorldTextView)).setText(R.string.helloworld);
	}
	
	public void onClick(View view) {
		if (view == findViewById(R.id.helloWorldTextView)) {
			findViewById(R.id.easterEggImageView).setVisibility(View.VISIBLE);
		} else if (view == findViewById(R.id.easterEggImageView)) {
			findViewById(R.id.easterEggImageView).setVisibility(View.INVISIBLE);
		}
	}
}
