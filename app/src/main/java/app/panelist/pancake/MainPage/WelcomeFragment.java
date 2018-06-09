package app.panelist.pancake.MainPage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.panelist.pancake.MainPage.JoinAskroomDialogFragment;
import app.panelist.pancake.R;

public class WelcomeFragment extends Fragment {
	
	FloatingActionButton joinAskroomFloatingActionButton;
	
	public WelcomeFragment() {
		// Required empty public constructor
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_welcome, container, false);
	}
	
	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		setJoinRoomFloatingActionButton();
	}
	
	private void setJoinRoomFloatingActionButton() {
		joinAskroomFloatingActionButton = getView().findViewById(R.id.floatingActionButton_fragmentWelcome_joinAskroom);
		joinAskroomFloatingActionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				JoinAskroomDialogFragment.newInstance().show(getFragmentManager(), "joinAskroomDialogFragment");
			}
		});
	}
}
