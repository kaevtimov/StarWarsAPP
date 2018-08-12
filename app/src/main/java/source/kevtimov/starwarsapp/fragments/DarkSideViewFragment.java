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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.activities.DarkSideViewActivity;
import source.kevtimov.starwarsapp.activities.TheForceViewActivity;
import source.kevtimov.starwarsapp.databaseFirestore.FirebaseRepository;
import source.kevtimov.starwarsapp.databaseFirestore.Repository;
import source.kevtimov.starwarsapp.models.DarkSideHero;

/**
 * A simple {@link Fragment} subclass.
 */
public class DarkSideViewFragment extends Fragment {

    private ArrayAdapter<DarkSideHero> mAdapterDarkSide;
    private ListView mListView;
    private ImageView mImageView;
    //private FirebaseFirestore mDb;
    private static Repository<DarkSideHero> mDarkSideRepository;


    public DarkSideViewFragment() {
        // Required empty public constructor
    }

    public static DarkSideViewFragment createInstance(){
        return new DarkSideViewFragment();
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

        mDarkSideRepository = new FirebaseRepository<>(DarkSideHero.class);


        //mDb = FirebaseFirestore.getInstance();

        //        mDarkSideRepository.add(new DarkSideHero("Darth Vader", "Sith", "Luke father"),
//                newHero -> {});
//
//
//        mDarkSideRepository.getAll(darkSideHeroes -> {
//            for (DarkSideHero hero : darkSideHeroes) {
//                mAdapterDarkSide.add(hero);
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

    public static Repository<DarkSideHero> getmDarkSideRepository() {
        return mDarkSideRepository;
    }

    private void loadAdapter() {
        mAdapterDarkSide.add(new DarkSideHero("Darth Vader", "Sith lord", "Also known as Anakin Skywalker, father of Luke an Leia Skywalker" +
                "Discovered as a slave on Tatooine by Qui-Gon Jinn and Obi-Wan Kenobi, " +
                "Anakin Skywalker had the potential to become one of the most powerful Jedi ever, " +
                "and was believed by some to be the prophesied Chosen One who would bring balance to the Force." +
                "A hero of the Clone Wars, Anakin was caring and compassionate, " +
                "but also had a fear of loss that would prove to be his downfall."));
        mAdapterDarkSide.add(new DarkSideHero("Darth Sidious", "Sith lord", "Scheming, powerful, and evil to the core, " +
                "Darth Sidious restored the Sith and destroyed the Jedi Order. " +
                "Living a double life, Sidious was in fact Palpatine, " +
                "a Naboo Senator and phantom menace. He slowly manipulated " +
                "the political system of the Galactic Republic until he was named Supreme Chancellor " +
                "-- and eventually Emperor -- ruling the galaxy through fear and tyranny."));
        mAdapterDarkSide.add(new DarkSideHero("Count Dooku", "Sith lord", "Count Dooku was a menacing Sith Lord and central figure in the Clone Wars. " +
                "Once a Jedi -- trained by Yoda -- he became disillusioned with the Jedi Order and thirsted for greater power. " +
                "Dooku voluntarily left the light side behind and became Darth Sidious’ dark side disciple, taking the secret name Darth Tyranus and leading" +
                " the Separatist army. Dooku advanced Sidious’s secret plot to take over the galaxy, but forgot that betrayal is the nature of the Sith."));
        mAdapterDarkSide.add(new DarkSideHero("Darth Maul", "Sith lord", "A deadly, agile Sith Lord trained by the evil Darth Sidious, Darth Maul was a " +
                "formidable warrior and scheming mastermind. He wielded an intimidating double-bladed lightsaber and fought with a menacing ferocity." +
                " Though he fell in battle against Obi-Wan Kenobi, the Zabrak from Dathomir would prove to be much harder to destroy than originally believed."));
        mAdapterDarkSide.add(new DarkSideHero("Boba Fett", "Headhunter", "With his customized Mandalorian armor, deadly weaponry, and silent demeanor," +
                " Boba Fett was one of the most feared bounty hunters in the galaxy." +
                "A genetic clone of his “father,” bounty hunter Jango Fett, Boba learned combat and martial skills from a young age. Over the course of his career, " +
                "which included contracts for the Empire and the criminal underworld, he became a legend."));
        mAdapterDarkSide.add(new DarkSideHero("Jabba the Hutt", "Gangster", "Jabba the Hutt was one of the galaxy’s most powerful gangsters, with far-reaching " +
                "influence in both politics and the criminal underworld. There were no second chances with Jabba, something Han Solo would find out -- " +
                "though the slug-like alien would ultimately fall victim to his own hubris and vengeful ways."));
        mAdapterDarkSide.add(new DarkSideHero("General Griveous", "Jedi hunter", "General Grievous was a brilliant Separatist military strategist and a feared Jedi hunter, known for his ruthlessness " +
                "and hacking cough. His body itself was a weapon, allowing him lightning quick strikes and devastating blows. " +
                "But he was also quick to run from a fight, a tactic that worked until one final meeting with Obi-Wan Kenobi."));
        mAdapterDarkSide.add(new DarkSideHero("Mas Amedda", "Vice Chair of the Galactic Senate", "Mas Amedda was the Vice Chair of the Galactic Senate during Chancellor Valorum's term, " +
                "a position he continued to hold as Chancellor Palpatine transformed the Republic into the Galactic Empire. " +
                "Amedda's booming voice often called for order when the partisan nature of the Republic's government degenerated into pointless bickering." +
                " In an alien gesture of authority, he would often punctuate such calls with a flicker of his long, forked tongue."));
        mAdapterDarkSide.add(new DarkSideHero("Grand Moff Tarkin", "Grand Moff", "An ambitious, ruthless proponent of military power, Wilhuff Tarkin became a favorite of Supreme Chancellor Palpatine and " +
                "rose rapidly through the Imperial ranks. Shortly after the Empire's creation, he was put in charge of the construction of the Death Star. " +
                " saw the Death Star as a way to crush all dissent to the Empire's rule -- fear of the station's" +
                " planet-killing superlaser would keep the galaxy's star systems in line. He demonstrated the station's power" +
                " by destroying Alderaan, but died soon afterwards when the Death Star itself was destroyed."));
    }

}
