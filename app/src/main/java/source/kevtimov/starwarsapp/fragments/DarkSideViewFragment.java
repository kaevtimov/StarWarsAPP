package source.kevtimov.starwarsapp.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.Objects;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.activities.ShowHeroActivity;
import source.kevtimov.starwarsapp.activities.TheForceViewActivity;
import source.kevtimov.starwarsapp.databaseFirestore.FirebaseRepository;
import source.kevtimov.starwarsapp.databaseFirestore.Repository;
import source.kevtimov.starwarsapp.models.heroes.DarkSideHero;

/**
 * A simple {@link Fragment} subclass.
 */
public class DarkSideViewFragment extends Fragment implements AdapterView.OnItemClickListener {

    private ArrayAdapter<DarkSideHero> mAdapterDarkSide;
    private ListView mListView;
    private ImageView mImageView;
    private static Repository<DarkSideHero> mDarkSideRepository;


    public DarkSideViewFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dark_side_view, container, false);

        mListView = root.findViewById(R.id.lv_sith);
        mImageView = root.findViewById(R.id.iv_sith_logo);
        mImageView.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetectorCompat mDetector = new GestureDetectorCompat(getContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Intent intent = new Intent(getContext(), TheForceViewActivity.class);
                    startActivity(intent);
                    Objects.requireNonNull(getActivity()).finish();
                    return super.onDoubleTap(e);
                }
                @Override
                public boolean onSingleTapConfirmed(MotionEvent event) {
                    return false;
                }
            });
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return true;
            }
        });
        mAdapterDarkSide = new ArrayAdapter<>(getContext(), android.R.layout.simple_expandable_list_item_1);
        mListView.setAdapter(mAdapterDarkSide);
        mListView.setOnItemClickListener(this);

        mDarkSideRepository = new FirebaseRepository<>(DarkSideHero.class);


        mDarkSideRepository.getAll(darkSideHeroes -> {
            for (DarkSideHero hero : darkSideHeroes) {
                mAdapterDarkSide.add(hero);
            }
        });

        return root;
    }


    public static DarkSideViewFragment createInstance(){
        return new DarkSideViewFragment();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DarkSideHero hero = mAdapterDarkSide.getItem(position);
        Intent intent = new Intent(getContext(), ShowHeroActivity.class);

        intent.putExtra("Hero", (Serializable) hero);
        startActivity(intent);
    }
}
