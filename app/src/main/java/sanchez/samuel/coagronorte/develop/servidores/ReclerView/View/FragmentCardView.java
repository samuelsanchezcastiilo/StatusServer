package sanchez.samuel.coagronorte.develop.servidores.ReclerView.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sanchez.samuel.coagronorte.develop.servidores.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCardView extends Fragment {


    public FragmentCardView() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_card_view, container, false);
    }

}
