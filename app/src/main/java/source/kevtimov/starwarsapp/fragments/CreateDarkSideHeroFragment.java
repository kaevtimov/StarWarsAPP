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

import source.kevtimov.starwarsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateDarkSideHeroFragment extends Fragment {

    private ImageView mImageView;
    private TextView mTextViewName;
    private TextView mTextViewType;
    private TextView mTextViewInfo;
    private EditText mEditTextName;
    private EditText mEditTextType;
    private EditText mEditTextInfo;
    private Button mButtonFinish;

    public CreateDarkSideHeroFragment() {
        // Required empty public constructor
    }

    public static CreateDarkSideHeroFragment createInstance(){
        return new CreateDarkSideHeroFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_create_dark_side_hero, container, false);

        mImageView = root.findViewById(R.id.create_sith);

        mTextViewName = root.findViewById(R.id.tv_hero_name);
        mTextViewName.setText(R.string.hero_name);
        mTextViewType = root.findViewById(R.id.tv_hero_type);
        mTextViewType.setText(R.string.hero_type);
        mTextViewInfo = root.findViewById(R.id.tv_hero_info);
        mTextViewInfo.setText(R.string.hero_info);

        mEditTextName = root.findViewById(R.id.et_hero_name);
        mEditTextType = root.findViewById(R.id.et_hero_type);
        mEditTextInfo = root.findViewById(R.id.et_hero_info);

        mButtonFinish = root.findViewById(R.id.btn_finish);
        mButtonFinish.setText(R.string.finish_create);




        return root;
    }

}
