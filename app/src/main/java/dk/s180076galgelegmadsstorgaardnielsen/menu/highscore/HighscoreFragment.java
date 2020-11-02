package dk.s180076galgelegmadsstorgaardnielsen.menu.highscore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import dk.s180076galgelegmadsstorgaardnielsen.R;
import dk.s180076galgelegmadsstorgaardnielsen.menu.highscore.HighscoreModel;


public class HighscoreFragment extends Fragment {
    ListView listView;
    ArrayList<HighscoreModel> highscoreList;
    String SHAREDPREFKEY = "highscores";
    String HIGHSCOREKEY = "highscore";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_highscore, container, false);

        loadData();
        sortHighscores();
        listView = root.findViewById(R.id.ListView);
        listView.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, highscoreList));
        return root;
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(SHAREDPREFKEY, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(HIGHSCOREKEY, null);
        Type type = new TypeToken<ArrayList<HighscoreModel>>() {
        }.getType();
        highscoreList = gson.fromJson(json, type);

        if (highscoreList == null) {
            highscoreList = new ArrayList<>();
        }
    }

    private void sortHighscores() {
        loadData();
        Collections.sort(highscoreList, new Comparator<HighscoreModel>() {
            @Override
            public int compare(HighscoreModel hs1, HighscoreModel hs2) {
                return Integer.compare(Integer.parseInt(hs1.getGuesses()), Integer.parseInt(hs2.getGuesses()));
            }
        });
    }
}