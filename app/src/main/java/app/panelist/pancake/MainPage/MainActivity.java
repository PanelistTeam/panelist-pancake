package app.panelist.pancake.MainPage;

import android.content.ClipData;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import app.panelist.pancake.LoginPage.LoginActivity;
import app.panelist.pancake.R;
import app.panelist.pancake.ViewAskroomPage.UserAskroomsFragment;

public class MainActivity extends AppCompatActivity implements FragmentOwner {
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle actionBarDrawerToggle;
	private NavigationView navigationView;
	private Toolbar toolbar;
	private ClipData.Item logoutItem;
	private TextView username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent ownIntent = getIntent();
		
		setNavigationView();
		final Intent loginIntent = new Intent(this, LoginActivity.class);
		
		toolbar = findViewById(R.id.toolbar);
		drawerLayout = findViewById(R.id.drawer_layout);
		
		View navigationHeader = navigationView.getHeaderView(0);
		username = navigationHeader.findViewById(R.id.username);
		username.setText(ownIntent.getStringExtra("username"));
		
		setSupportActionBar(toolbar);
		actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
		drawerLayout.addDrawerListener(actionBarDrawerToggle);
		
		try {
			//setFragment(WelcomeFragment.class.newInstance());
			UserAskroomsFragment userAskroomsFragment = UserAskroomsFragment.class.newInstance();
			userAskroomsFragment.setFragmentOwner(this);
			setFragment(userAskroomsFragment, false);
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setFragment(Fragment fragment, boolean addToBackStack) {
		FragmentTransaction fragmentTransaction = getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.main_activity_content, fragment)
				.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

		if (addToBackStack)
			fragmentTransaction.addToBackStack("X");

		fragmentTransaction.commit();
	}
	
	private void setNavigationView() {
		navigationView = findViewById(R.id.navigation_view);
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				onSelectMenuItem(item);
				new Handler().postDelayed(new Runnable() {
					@Override
					public void run() {
						drawerLayout.closeDrawers();
					}
				}, 0);
				return false;
			}
		});
	}
	
	private void onSelectMenuItem(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.settings_item:
				break;
			case R.id.logout_item:
				startActivity(new Intent(this, LoginActivity.class));
				break;
		}
	}

	@Override
	public void onPostCreate(Bundle savedInstance) {
		super.onPostCreate(savedInstance);
		actionBarDrawerToggle.syncState();

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		actionBarDrawerToggle.onConfigurationChanged(newConfig);
	}

	@Override
	public void setArrow() {
		actionBarDrawerToggle.setDrawerIndicatorEnabled(false);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
		actionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
	}

	@Override
	public void setBurger() {
		actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
		actionBarDrawerToggle.setToolbarNavigationClickListener(null);
		getSupportActionBar().setDisplayHomeAsUpEnabled(false);
		getSupportActionBar().setDisplayShowHomeEnabled(false);
		actionBarDrawerToggle.syncState();
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		setBurger();
		setTitle("Panelist");
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
	}
}
