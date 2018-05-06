package app.panelist.pancake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		//ImageView goView = findViewById(R.id.goView);
		/*
		goView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				goView.setVisibility(View.INVISIBLE);
				// gdy nacisnie sie przycisk dalej - do nastepnego activity
			}
		});*/
	}
}
