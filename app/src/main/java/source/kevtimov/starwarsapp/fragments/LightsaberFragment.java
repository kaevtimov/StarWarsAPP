package source.kevtimov.starwarsapp.fragments;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import source.kevtimov.starwarsapp.CustomLightsaberView;
import source.kevtimov.starwarsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LightsaberFragment extends Fragment {


    private CustomLightsaberView mCustomView;
    private Button mButtonColor;
    private Button mButtonON;
    private Button mButtonOFF;
    private MediaPlayer mMP;


    public LightsaberFragment() {
        // Required empty public constructor
    }

    public static LightsaberFragment createInstance(){
        return new LightsaberFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_lightsaber, container, false);

        mCustomView = root.findViewById(R.id.customview);

        mButtonColor = root.findViewById(R.id.btn_color);
        mButtonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomView.change();
                mMP = MediaPlayer.create(getContext(), R.raw.saber_move);
                mMP.start();
            }
        });

        mButtonON = root.findViewById(R.id.btn_lightsaberON);
        mButtonON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomView.lightsaberON();
                mMP = MediaPlayer.create(getContext(), R.raw.lightsaber_on);
                mMP.start();
            }
        });

        mButtonOFF = root.findViewById(R.id.btn_lightsaberOFF);
        mButtonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomView.lightsaberOFF();
                mMP = MediaPlayer.create(getContext(), R.raw.saberoff);
                mMP.start();
            }
        });



        return root;
    }

}
