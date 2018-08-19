package source.kevtimov.starwarsapp.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.models.heroes.Hero;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowHeroFragment extends Fragment {

    private Hero mHero;
    private TextView mTextView;
    private CircleImageView mImageView;


    public ShowHeroFragment() {
        // Required empty public constructor
    }



    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_show_hero, container, false);

        mImageView = root.findViewById(R.id.profile_image);
        Picasso.get()
                .load(mHero.getHeroImage())
                .into(mImageView);

        mTextView = root.findViewById(R.id.tv_hero);
        mTextView.setText("NAME:\n" + mHero.getName() + "\n\n"
                + "TYPE:\n" + mHero.getType() + "\n\n"
                + "History:\n" + mHero.getInfo());
        mTextView.setMovementMethod(new ScrollingMovementMethod());



        return root;
    }


    public static ShowHeroFragment createInstance(){
        return new ShowHeroFragment();
    }

    public void setHero(Hero hero){
        mHero = hero;
//        if(mAvengerTextView == null){
//            return;
//        }
//        mAvengerTextView.setText(mAvenger.getInfo());
    }

}
