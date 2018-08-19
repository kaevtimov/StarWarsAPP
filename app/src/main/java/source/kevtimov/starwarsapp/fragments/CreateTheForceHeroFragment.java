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
import source.kevtimov.starwarsapp.databaseFirestore.FirebaseRepository;
import source.kevtimov.starwarsapp.databaseFirestore.Repository;
import source.kevtimov.starwarsapp.models.heroes.TheForceHero;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateTheForceHeroFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageView;
    private TextView mTextViewName;
    private TextView mTextViewType;
    private TextView mTextViewInfo;
    private TextView mTextViewPoints;
    private TextView mTextViewImage;
    private EditText mEditTextName;
    private EditText mEditTextType;
    private EditText mEditTextInfo;
    private EditText mEditTextPoints;
    private EditText mEditTextImage;
    private Button mButtonFinish;
    private Repository<TheForceHero> mTheForceRepository;


    public CreateTheForceHeroFragment() {
        // Required empty public constructor
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
        mTextViewImage = root.findViewById(R.id.tv_hero_image_url);
        mTextViewImage.setText("Image URL:");

        mEditTextName = root.findViewById(R.id.et_hero_name);
        mEditTextType = root.findViewById(R.id.et_hero_type);
        mEditTextInfo = root.findViewById(R.id.et_hero_info);
        mEditTextPoints = root.findViewById(R.id.et_hero_points);
        mEditTextImage = root.findViewById(R.id.et_hero_image_url);

        mButtonFinish = root.findViewById(R.id.btn_finish);
        mButtonFinish.setText(R.string.finish_create);
        mButtonFinish.setOnClickListener(this);



        return root;
    }


    public static CreateTheForceHeroFragment createInstance(){
        return new CreateTheForceHeroFragment();
    }

    @Override
    public void onClick(View v) {

        String heroName = mEditTextName.getText().toString();
        String heroType = mEditTextType.getText().toString();
        String heroInfo = mEditTextInfo.getText().toString();
        String heroImage = mEditTextImage.getText().toString();
        String points = mEditTextPoints.getText().toString();
        int heroPoints = Integer.parseInt(points);

        if((heroName.length() > 0 && heroType.length() > 0
                && heroInfo.length() > 0 && heroImage.length() > 0 && points.length() > 0)){
            TheForceHero hero = new TheForceHero(heroName, heroType, heroInfo, heroImage, heroPoints);
            mTheForceRepository = new FirebaseRepository<>(TheForceHero.class);
            mTheForceRepository.add(hero, newSuperhero -> {});

            Toast.makeText(getContext(), "Hero created", Toast.LENGTH_SHORT)
                    .show();
        }else if(heroName.length() <= 0 || heroType.length() <= 0
                || heroInfo.length() <= 0 || heroImage.length() <= 0 || points.length() <= 0){
            Toast.makeText(getContext(), "Fill every field above!", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
