package app.panelist.pancake;

import android.support.v4.app.Fragment;

public interface FragmentOwner {
	void setFragment(Fragment fragment, boolean addToBackStack);
	void setArrow();
	void setBurger();
}
