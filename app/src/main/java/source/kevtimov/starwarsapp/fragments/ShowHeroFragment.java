package source.kevtimov.starwarsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.models.Hero;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowHeroFragment extends Fragment {

    private Hero mHero;
    private TextView mTextView;


    public ShowHeroFragment() {
        // Required empty public constructor
    }

    public static ShowHeroFragment createInstance(){
        return new ShowHeroFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_show_hero, container, false);

        mTextView = root.findViewById(R.id.tv_hero);
        mTextView.setText(mHero.getName());



        return root;
    }

    public void setHero(Hero hero){
        mHero = hero;
//        if(mAvengerTextView == null){
//            return;
//        }
//        mAvengerTextView.setText(mAvenger.getInfo());
    }

}
