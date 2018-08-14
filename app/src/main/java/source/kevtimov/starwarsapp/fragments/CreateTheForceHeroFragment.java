package source.kevtimov.starwarsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import source.kevtimov.starwarsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTheForceHeroFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageView;
    private TextView mTextViewName;
    private TextView mTextViewType;
    private TextView mTextViewInfo;
    private TextView mTextViewPoints;
    private EditText mEditTextName;
    private EditText mEditTextType;
    private EditText mEditTextInfo;
    private EditText mEditTextPoints;
    private Button mButtonFinish;
    //private Repository<TheForceHero> mSuperheroRepository;


    public CreateTheForceHeroFragment() {
        // Required empty public constructor
    }

    public static CreateTheForceHeroFragment createInstance(){
        return new CreateTheForceHeroFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_create_the_force_hero, container, false);

        mImageView = root.findViewById(R.id.create_jedi);

        mTextViewName = root.findViewById(R.id.tv_hero_name);
        mTextViewName.setText(R.string.hero_name);
        mTextViewType = root.findViewById(R.id.tv_hero_type);
        mTextViewType.setText(R.string.hero_type);
        mTextViewInfo = root.findViewById(R.id.tv_hero_info);
        mTextViewInfo.setText(R.string.hero_info);
        mTextViewPoints = root.findViewById(R.id.tv_hero_points);
        mTextViewPoints.setText(R.string.hero_points);

        mEditTextName = root.findViewById(R.id.et_hero_name);
        mEditTextType = root.findViewById(R.id.et_hero_type);
        mEditTextInfo = root.findViewById(R.id.et_hero_info);
        mEditTextPoints = root.findViewById(R.id.et_hero_points);

        mButtonFinish = root.findViewById(R.id.btn_finish);
        mButtonFinish.setText(R.string.finish_create);
        mButtonFinish.setOnClickListener(this);



        return root;
    }

    @Override
    public void onClick(View v) {

        String heroName = mEditTextName.getText().toString();
        String heroType = mEditTextType.getText().toString();
        String heroInfo = mEditTextInfo.getText().toString();
        int heroPoints = Integer.parseInt(mEditTextPoints.getText().toString());

        //TheForceHero hero = new TheForceHero(heroName, heroType, heroInfo, heroPoints);
        //TheForceViewFragment.getmTheForceRepository().add(hero, newSuperhero -> {});


        Toast.makeText(getContext(), "Hero created", Toast.LENGTH_SHORT)
                .show();
    }
}
