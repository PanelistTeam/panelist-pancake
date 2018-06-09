package app.panelist.pancake.ViewAskroomPage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.panelist.pancake.MainPage.FragmentOwner;
import app.panelist.pancake.Models.Askroom;
import app.panelist.pancake.R;

public class UserAskroomsAdapter extends RecyclerView.Adapter<UserAskroomsAdapter.AskroomViewHolder> {

	private ArrayList<Askroom> userAskrooms;
	private FragmentOwner mainActivity;

	static class AskroomViewHolder extends RecyclerView.ViewHolder {
		TextView titleTextView;
		TextView ownerTextView;
		AskroomViewHolder(View view) {
			super(view);
			titleTextView = view.findViewById(R.id.textView_itemAskroom_title);
			ownerTextView = view.findViewById(R.id.textView_itemAskroom_owner);
		}
	}

	UserAskroomsAdapter(ArrayList<Askroom> userAskrooms, FragmentOwner fragmentOwner) {
		this.userAskrooms = userAskrooms;
		mainActivity = fragmentOwner;
	}

	@NonNull
	@Override
	public AskroomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_askroom, parent, false);

		AskroomViewHolder vh = new AskroomViewHolder(view);

		return vh;
	}

	@Override
	public void onBindViewHolder(@NonNull AskroomViewHolder holder, final int position) {
		holder.titleTextView.setText(userAskrooms.get(position).getTitle());
		holder.ownerTextView.setText(Integer.toString(userAskrooms.get(position).getCreatedBy()));

		holder.itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				try {
					Fragment askroomFragment = AskroomFragment.class.newInstance();
					Bundle bundle = new Bundle();
					bundle.putString("title", userAskrooms.get(position).getTitle());
					askroomFragment.setArguments(bundle);
					mainActivity.setFragment(askroomFragment, true);
					mainActivity.setArrow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public int getItemCount() {
		return userAskrooms.size();
	}
}
