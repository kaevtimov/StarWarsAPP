package source.kevtimov.starwarsapp.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
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

import java.util.List;
import java.util.Objects;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.activities.DarkSideViewActivity;
import source.kevtimov.starwarsapp.activities.TheForceViewActivity;
import source.kevtimov.starwarsapp.databaseFirestore.FirebaseRepository;
import source.kevtimov.starwarsapp.databaseFirestore.Repository;
import source.kevtimov.starwarsapp.models.TheForceHero;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheForceViewFragment extends Fragment {


    private ListView mListView;
    public static ArrayAdapter<TheForceHero> mAdapterForceHero;       // it is public and static because I want to get it in other class
    private ImageView mImageView;
//    private FirebaseFirestore mDb;
//    private Repository<TheForceHero> mTheForceRepository;

    public TheForceViewFragment() {
        // Required empty public constructor
    }

    public static TheForceViewFragment createInstance() {
        return new TheForceViewFragment();
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_the_force_view, container, false);

        //mDb = FirebaseFirestore.getInstance();
        mListView = root.findViewById(R.id.lv_theforce);
        mAdapterForceHero = new ArrayAdapter<>(getContext(), android.R.layout.simple_expandable_list_item_1);
        mListView.setAdapter(mAdapterForceHero);

        mImageView = root.findViewById(R.id.iv_logo);
        mImageView.setOnTouchListener(new View.OnTouchListener() {
            private GestureDetectorCompat mDetector = new GestureDetectorCompat(getContext(), new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onDoubleTap(MotionEvent e) {
                    Intent intent = new Intent(getContext(), DarkSideViewActivity.class);
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

        loadAdapter();

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

        return root;
    }

    private void loadAdapter() {
        mAdapterForceHero.add(new TheForceHero("Luke Skywalker", "Jedi Master", "Luke Skywalker was a Tatooine farmboy who rose from humble beginnings to become one of the greatest " +
                "Jedi the galaxy has ever known. Along with his friends Princess Leia and Han Solo, " +
                "Luke battled the evil Empire, discovered the truth of his parentage, and ended the tyranny of the Sith." +
                " A generation later, the location of the famed Jedi master was one of the galaxy’s greatest mysteries. " +
                "Haunted by Ben Solo’s fall to evil and convinced the Jedi had to end, Luke sought exile on a " +
                "distant world, ignoring the galaxy’s pleas for help. But his solitude would be interrupted – " +
                "and Luke Skywalker had one final, momentous role to play in the struggle between good and evil."));

        mAdapterForceHero.add(new TheForceHero("Leia Organa", "Princess and Rebel", "Princess Leia Organa was one of the Rebel Alliance’s greatest leaders, fearless on the battlefield and dedicated to " +
                "ending the tyranny of the Empire. Daughter of Padmé Amidala and Anakin Skywalker, sister of Luke Skywalker, and with a " +
                "soft spot for scoundrels, Leia ranks among the galaxy’s great heroes. But life under the New Republic has not been easy for " +
                "Leia. Sidelined by a new generation of political leaders, she struck out on her own to oppose the First Order as " +
                "founder of the Resistance. These setbacks in her political career have been accompanied by more personal losses."));

        mAdapterForceHero.add(new TheForceHero("Obi-Wan Kenobi", "Jedi Master", "A legendary Jedi Master, Obi-Wan Kenobi was a noble man and gifted in the ways of the Force. He trained Anakin Skywalker, " +
                "served as a general in the Republic Army during the Clone Wars, and guided Luke Skywalker as a mentor."));

        mAdapterForceHero.add(new TheForceHero("Master Yoda", "Jedi Master", "Yoda was a legendary Jedi Master and stronger than most in his connection with the Force. " +
                "Small in size but wise and powerful, he trained Jedi for over 800 years," +
                " playing integral roles in the Clone Wars, the instruction of Luke Skywalker, and unlocking the path to immortality."));

        mAdapterForceHero.add(new TheForceHero("Qui-Gon Jinn", "Jedi Master", "A venerable if maverick Jedi Master, Qui-Gon Jinn was a student of the living Force. Qui-Gon lived for the moment, espousing " +
                "a philosophy of \"feel, don't think -- use your instincts.\" On Tatooine," +
                " Qui-Gon discovered a young slave boy named Anakin Skywalker who was strong in the Force. Sensing the boy's potential, Qui-Gon liberated Anakin from slavery. " +
                "The Jedi Master presented Anakin to the Jedi Council, but they deemed the boy too old to begin training and dangerously full of fear and anger. " +
                "They refused to allow Qui-Gon to train Anakin, but rescinded their decision to fulfill Qui-Gon's dying wish."));

        mAdapterForceHero.add(new TheForceHero("Han Solo", "Rebel nad Gambler", "Han Solo rose from an impoverished childhood on the mean streets of Corellia to become one of the heroes of the Rebel Alliance." +
                " As captain of the Millennium Falcon, Han and his co-pilot Chewbacca came to believe in the cause of " +
                "galactic freedom, joining Luke Skywalker and Princess Leia Organa in the fight against the Empire. After the Battle of Endor," +
                " Han faced difficult times in a chaotic galaxy, leading to a shattering confrontation with his estranged son Ben."));

        mAdapterForceHero.add(new TheForceHero("Chewbacca", "Wookiee warrior", "During his long life Chewbacca has been many things: Wookiee warrior, ace smuggler and rebel hero. " +
                "Chewie fought with the Republic on Kashyyyk during the Clone Wars, then befriended Han Solo while in Imperial captivity on Mimban." +
                " After adventures on Vandor and Kessel, he became Han’s co-pilot aboard the Millennium Falcon, and eventually helped the Alliance " +
                "restore freedom to the galaxy. Known for his short temper and accuracy with a bowcaster, Chewie also had a big heart – and unflagging " +
                "loyalty to his friends. He stuck with Han through years of turmoil, and flew the Falcon alongside Rey after the Corellian’s death."));

        mAdapterForceHero.add(new TheForceHero("Mace Windu", "Jedi Master", "A grim Jedi Master with an amethyst-bladed lightsaber, Mace Windu was the champion of " +
                "the Jedi Order, with little tolerance for the failings of the Senate," +
                " the arguments of politicians, or the opinions of rebellious Jedi. As the Clone Wars intensified, Mace sensed the dark side " +
                "of the Force at work, and knew the Jedi's enemies were plotting to destroy the Order and end its stewardship of the galaxy."));

        mAdapterForceHero.add(new TheForceHero("Padme Amidala", "Queen", "Padmé Amidala was a courageous, hopeful leader, serving as Queen and then Senator of Naboo -- " +
                "and was also handy with a blaster. Despite her ideals and all she did for the cause of peace, her secret, " +
                "forbidden marriage to Jedi Anakin Skywalker would prove to have dire consequences for the galaxy."));

        mAdapterForceHero.add(new TheForceHero("R2-D2", "Robot", "A resourceful astromech droid, R2-D2 served Padmé Amidala, Anakin Skywalker and Luke Skywalker in turn, showing great " +
                "bravery in rescuing his masters and their friends from many perils. A skilled starship " +
                "mechanic and fighter pilot's assistant, he formed an unlikely but enduring friendship with the fussy protocol droid C-3PO."));

    }

}

