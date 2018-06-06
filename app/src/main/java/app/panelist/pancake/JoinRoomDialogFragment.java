package app.panelist.pancake;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

public class JoinRoomDialogFragment extends DialogFragment {
	
	public JoinRoomDialogFragment() {
		// Required empty public constructor
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		LayoutInflater inflater = getActivity().getLayoutInflater();
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setView(inflater.inflate(R.layout.dialog_join_room, null));
		
		return builder.create();
	}
	
	public static JoinRoomDialogFragment newInstance() {
		return new JoinRoomDialogFragment();
	}
}
