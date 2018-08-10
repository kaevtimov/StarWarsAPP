package source.kevtimov.starwarsapp.fragments;


import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.activities.MainActivity;
import source.kevtimov.starwarsapp.activities.OptionsActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageView;
    private ImageButton mImageButton;
    private TextView mTextView;
    private TextView mTextViewVersion;
    private Animation mAnim;
    private MediaPlayer mMP;


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment createInstance(){
        return new MainFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mTextView = root.findViewById(R.id.tv_text_start);
        mTextView.setText(R.string.start_text);
        mTextViewVersion = root.findViewById(R.id.tv_version);
        mTextViewVersion.setText(R.string.version_app);

        //animation for blinking text
        mAnim = new AlphaAnimation(0.0f, 1.0f);
        mAnim.setDuration(920); // here I can menage the speed of blinking
        mAnim.setStartOffset(20);
        mAnim.setRepeatMode(Animation.REVERSE);
        mAnim.setRepeatCount(Animation.INFINITE);
        mTextView.startAnimation(mAnim);

        mImageButton = root.findViewById(R.id.ib_trooper_button);
        mImageButton.setOnClickListener(this);

        mImageView = root.findViewById(R.id.iv_start);

        return root;
    }

    @Override
    public void onClick(View v) {
        mAnim.setDuration(120); // here I can menage the speed of blinking
        mAnim.setStartOffset(20);
        mAnim.setRepeatMode(Animation.REVERSE);
        mAnim.setRepeatCount(Animation.INFINITE);
        mImageButton.setAnimation(mAnim);
        mMP = MediaPlayer.create(getContext(), R.raw.may_the_force_be_with_you);
        mMP.start();

        Intent intent = new Intent(getContext(), OptionsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume(){
        super.onResume();
        mImageButton.setAnimation(null);
        mAnim.setDuration(920);
    }
}
