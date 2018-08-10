package source.kevtimov.starwarsapp.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import source.kevtimov.starwarsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {

    private ImageView mImageView;
    private TextView mTextView;
    private TextView mTextView2;


    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment createInstance(){
        return new AboutFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_about, container, false);

        mImageView = root.findViewById(R.id.iv_sky);

        mTextView = root.findViewById(R.id.tv_about);
        mTextView.setText(R.string.about_info);

        mTextView2 = root.findViewById(R.id.tv_about_2);
        mTextView2.setText(R.string.about_info_2);
        //mTextView2.setMovementMethod(ScrollingMovementMethod.getInstance());


        return root;
    }

}
