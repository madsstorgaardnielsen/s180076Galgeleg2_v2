package dk.s180076galgelegmadsstorgaardnielsen.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import dk.s180076galgelegmadsstorgaardnielsen.R;


public class HelpMenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_help_menu, container, false);

        return root;
    }
}