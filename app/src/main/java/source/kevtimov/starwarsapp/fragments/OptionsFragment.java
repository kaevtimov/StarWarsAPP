package source.kevtimov.starwarsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import source.kevtimov.starwarsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OptionsFragment extends Fragment {


    private ImageView mImageView;

    public OptionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_options, container, false);

        mImageView = root.findViewById(R.id.iv_sith_jedi);


        return root;
    }


    public static OptionsFragment createInstance(){
        return new OptionsFragment();
    }

}
