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
import android.widget.Toast;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.activities.DarkSideViewActivity;
import source.kevtimov.starwarsapp.activities.TheForceViewActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseViewFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageView;
    private Button mButtonJedi;
    private Button mButtonSith;

    public ChooseViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_choose_view, container, false);

        mImageView = root.findViewById(R.id.iv_jedi_or_sith);

        mButtonJedi = root.findViewById(R.id.btn_jedi);
        mButtonJedi.setText("The Force");
        mButtonJedi.setTextColor(Color.WHITE);
        mButtonJedi.setOnClickListener(this);

        mButtonSith = root.findViewById(R.id.btn_sith);
        mButtonSith.setText("Dark Side");
        mButtonSith.setOnClickListener(this);



        return root;
    }


    public static ChooseViewFragment createInstance(){
        return new ChooseViewFragment();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_jedi:
                Intent intentJedi = new Intent(getContext(), TheForceViewActivity.class);
                startActivity(intentJedi);
                break;
            case R.id.btn_sith:
                Intent intentSith = new Intent(getContext(), DarkSideViewActivity.class);
                startActivity(intentSith);
            default:
                break;
        }

    }
}
