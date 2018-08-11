package source.kevtimov.starwarsapp.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.activities.CreateDarkSideHeroActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainCreateFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageView;
    private Button mJediButton;
    private Button mSithButton;


    public MainCreateFragment() {
        // Required empty public constructor
    }

    public static MainCreateFragment createInstance(){
        return new MainCreateFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main_create, container, false);

        mImageView = root.findViewById(R.id.iv_jedi_or_sith);
        mJediButton = root.findViewById(R.id.btn_jedi_create);
        mJediButton.setText(R.string.create_hero);
        mJediButton.setTextColor(Color.WHITE);
        mSithButton = root.findViewById(R.id.btn_sith_create);
        mSithButton.setText(R.string.create_hero);
        mSithButton.setTextColor(Color.RED);
        mSithButton.setOnClickListener(this);




        return root;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), CreateDarkSideHeroActivity.class);
        startActivity(intent);
    }
}
