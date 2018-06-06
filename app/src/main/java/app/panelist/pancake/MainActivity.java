package app.panelist.pancake;

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

public class MainActivity extends AppCompatActivity {
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
			setFragment(WelcomeFragment.class.newInstance());
		} catch (ReflectiveOperationException e) {
			e.printStackTrace();
		}
	}
	
	public void setFragment(Fragment fragment) {
		getSupportFragmentManager()
				.beginTransaction()
				.setTransition(FragmentTransaction.TRANSIT_EXIT_MASK)
				.replace(R.id.main_activity_content, fragment)
				.commit();
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
	public boolean onOptionsItemSelected(MenuItem item) {
		return actionBarDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
	}
}
