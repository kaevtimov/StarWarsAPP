package source.kevtimov.starwarsapp.fragments;


import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.databaseFirestore.FirebaseRepository;
import source.kevtimov.starwarsapp.databaseFirestore.Repository;
import source.kevtimov.starwarsapp.models.TheForceHero;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheForceViewFragment extends Fragment {


    private ListView mListView;
    private ArrayAdapter<TheForceHero> mAdapter;
    private ImageView mImageView;
//    private FirebaseFirestore mDb;
//    private Repository<TheForceHero> mTheForceRepository;

    public TheForceViewFragment() {
        // Required empty public constructor
    }

    public static TheForceViewFragment createInstance() {
        return new TheForceViewFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_the_force_view, container, false);

        //mDb = FirebaseFirestore.getInstance();
        mListView = root.findViewById(R.id.lv_theforce);
        mAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_expandable_list_item_1);
        mListView.setAdapter(mAdapter);

        mImageView = root.findViewById(R.id.iv_logo);

        //mTheForceRepository = new FirebaseRepository<>(TheForceHero.class);

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
        mAdapter.add(new TheForceHero("Leia Skywalker", "Rebel", "She is Luke Skywalker sister and Darth Vader's daughter."));
        mAdapter.add(new TheForceHero("Luke Skywalker", "Jedi Knight", "He is Lea Skywalker brother and Darth Vader's son." +
                "His master is Obi-One Kenobi and his destiny is to bring balance in the force."));
        mAdapter.add(new TheForceHero("Han Solo", "Rebel and gambler", "He is Luke Skywalker best friend, Lea biggest love and a very good pilot." +
                "He owns The millennium falcon."));
    }

}

