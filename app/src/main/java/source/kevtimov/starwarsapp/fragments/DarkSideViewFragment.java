package source.kevtimov.starwarsapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.models.DarkSideHero;

/**
 * A simple {@link Fragment} subclass.
 */
public class DarkSideViewFragment extends Fragment {

    private ArrayAdapter<DarkSideHero> mAdapter;
    private ListView mListView;
    private ImageView mImageView;
//    private FirebaseFirestore mDb;
//    private Repository<TheForceHero> mTheForceRepository;


    public DarkSideViewFragment() {
        // Required empty public constructor
    }

    public static DarkSideViewFragment createInstance(){
        return new DarkSideViewFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dark_side_view, container, false);

        mListView = root.findViewById(R.id.lv_sith);
        mImageView = root.findViewById(R.id.iv_sith_logo);
        mAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_expandable_list_item_1);
        mListView.setAdapter(mAdapter);


        //mDb = FirebaseFirestore.getInstance();

        //        mTheForceRepository.add(new TheForceHero("Lea", "Rebel", "Luke sister"),
//                newHero -> {});
//
//
//        mTheForceRepository.getAll(theForceHeroes -> {
//            for (TheForceHero hero : theForceHeroes) {
//                mAdapter.add(hero);
//            }
//        });

//        mTheForceRepository.add(new TheForceHero("Jaba", "Businessman", "Gambler and a lizard"),
//                newHero -> mTheForceRepository.getAll(theForceHeroes -> {
//                    for (TheForceHero hero : theForceHeroes) {
//                        mAdapter.add(hero);
//                    }
//                }));


//        mDb.collection("theforceheros")
//                .add(new TheForceHero("pepi", "dfgdfg", "asdsdf"))
//                .addOnSuccessListener(task2 -> {
//                    int b = 6;
//                })
//                .addOnFailureListener(error -> {
//                    int b = 5;
//                });
//
//        mDb.collection("theforceheros")
//                .get()
//                .addOnCompleteListener(task -> {
//                    List<TheForceHero> heroes = task.getResult()
//                            .toObjects(TheForceHero.class);
//                    for (TheForceHero hero : heroes) {
//                        mAdapter.add(hero);
//                    }
//                });


        loadAdapter();



        return root;
    }

    private void loadAdapter() {
        mAdapter.add(new DarkSideHero("Darth Vader", "Sith lord", "Lovely father of Luke and Leia Skywalker."));
    }

}
