package app.panelist.pancake;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class UserAskroomsFragment extends Fragment {
	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;

	private FragmentOwner mainActivity;
	private FloatingActionButton joinAskroomFloatingActionButton;

	public UserAskroomsFragment() {
		// Required empty public constructor
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		final View view = inflater.inflate(R.layout.fragment_user_askrooms, container, false);

		recyclerView = view.findViewById(R.id.recyclerView_fragmentUserAskrooms);
		recyclerView.setHasFixedSize(true);

		layoutManager = new LinearLayoutManager(getContext());

		recyclerView.setLayoutManager(layoutManager);

		DividerItemDecoration itemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
		recyclerView.addItemDecoration(itemDecoration);

		ArrayList<Askroom> askrooms = new ArrayList<>();
		Askroom testAskroom = new Askroom();
		testAskroom.setTitle("Askroom");
		testAskroom.setCreatedBy(1234);
		askrooms.add(testAskroom);
		askrooms.add(testAskroom);
		askrooms.add(testAskroom);

		adapter = new UserAskroomsAdapter(askrooms, mainActivity);
		recyclerView.setAdapter(adapter);
		return view;
	}

	public void setFragmentOwner(FragmentOwner fragmentOwner) {
		this.mainActivity = fragmentOwner;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		setJoinRoomFloatingActionButton();
	}

	private void setJoinRoomFloatingActionButton() {
		joinAskroomFloatingActionButton = getView().findViewById(R.id.floatingActionButton_fragmentUserAskrooms_joinAskroom);
		joinAskroomFloatingActionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				JoinAskroomDialogFragment.newInstance().show(getFragmentManager(), "joinAskroomDialogFragment");
			}
		});
	}
}
