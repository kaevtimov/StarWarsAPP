package source.kevtimov.starwarsapp.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import source.kevtimov.starwarsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AskYodaFragment extends Fragment implements View.OnClickListener {

    private ImageView mImageView;
    private Button mButtonAsk;
    private Button mButtonAdvise;
    private EditText mEditText;
    private Button mEditTextButton;
    private TextView mTextView;


    public AskYodaFragment() {
        // Required empty public constructor
    }

    public static AskYodaFragment createInstance(){
        return new AskYodaFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_ask_yoda, container, false);

        mImageView = root.findViewById(R.id.iv_yoda);
        mTextView = root.findViewById(R.id.tv_answer);
        mTextView.setTextColor(Color.BLACK);
        mTextView.setVisibility(View.INVISIBLE);

        mButtonAdvise = root.findViewById(R.id.btn_advise);
        mButtonAdvise.setText(R.string.yoda_advise);
        mButtonAdvise.setTextColor(Color.WHITE);
        mButtonAdvise.setOnClickListener(this);

        mButtonAsk = root.findViewById(R.id.btn_question);
        mButtonAsk.setText(R.string.yoda_ask);
        mButtonAsk.setTextColor(Color.WHITE);
        mButtonAsk.setOnClickListener(this);

        mEditText = root.findViewById(R.id.et_ask);
        mEditText.setVisibility(View.INVISIBLE);
        mEditTextButton = root.findViewById(R.id.btn_ask_2);
        mEditTextButton.setText(R.string.yoda_ask);
        mEditTextButton.setVisibility(View.INVISIBLE);

        return root;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_question:
                mButtonAsk.setVisibility(View.INVISIBLE);
                mButtonAdvise.setVisibility(View.INVISIBLE);

                mEditText.setVisibility(View.VISIBLE);
                mEditTextButton.setVisibility(View.VISIBLE);
                mEditTextButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mEditText.setVisibility(View.INVISIBLE);
                        mEditTextButton.setVisibility(View.INVISIBLE);

                        mTextView.setVisibility(View.VISIBLE);
                        int min = 1;
                        int max = 15;
                        Random random = new Random();
                        int number = random.nextInt((max - min) + 1) + min;

                        switch (number){
                            case 1:
                                mTextView.setText("The force is not clear with the answer. Try again later.");
                                break;
                            case 2:
                                mTextView.setText("Yes, it will.");
                                break;
                            case 3:
                                mTextView.setText("The force says no...");
                                break;
                            case 4:
                                mTextView.setText("No.");
                                break;
                            case 5:
                                mTextView.setText("Tell you not better now.");
                                break;
                            case 6:
                                mTextView.setText("I can't predict now.");
                                break;
                            case 7:
                                mTextView.setText("The force points to YES.");
                                break;
                            case 8:
                                mTextView.setText("Yes - definitely.");
                                break;
                            case 9:
                                mTextView.setText("The force says very doubtful.");
                                break;
                            case 10:
                                mTextView.setText("Absolutely.");
                                break;
                            case 11:
                                mTextView.setText("Negative.");
                                break;
                            case 12:
                                mTextView.setText("Leave me alone, I am trying to sleep.");
                                break;
                            case 13:
                                mTextView.setText("You may rely on it.");
                                break;
                            case 14:
                                mTextView.setText("I feel disturbance in the force right now.");
                                break;
                            case 15:
                                mTextView.setText("Go away, I don't want to answer you.");
                                break;
                        }
                    }
                });
                break;
            case R.id.btn_advise:
                mButtonAsk.setVisibility(View.INVISIBLE);
                mButtonAdvise.setVisibility(View.INVISIBLE);

                mTextView.setVisibility(View.VISIBLE);
                int min = 1;
                int max = 20;
                Random random = new Random();
                int number = random.nextInt((max - min) + 1) + min;

                switch (number){
                    case 1:
                        mTextView.setText("Once you start down the dark path, forever will it dominate your destiny, consume you it will.");
                        break;
                    case 2:
                        mTextView.setText("Luminous beings are we, not this crude matter.");
                        break;
                    case 3:
                        mTextView.setText("In a dark place we find ourselves, and a little more knowledge lights our way.");
                        break;
                    case 4:
                        mTextView.setText("Fear is the path to the dark side. Fear leads to anger. Anger leads to hate. Hate leads to suffering.");
                        break;
                    case 5:
                        mTextView.setText("Patience you must have, my young padawan.");
                        break;
                    case 6:
                        mTextView.setText("A Jedi uses the Force for knowledge and defense, never for attack.");
                        break;
                    case 7:
                        mTextView.setText("Adventure. Excitement. A Jedi craves not these things.");
                        break;
                    case 8:
                        mTextView.setText("No! Try not! Do or do not, there is no try.");
                        break;
                    case 9:
                        mTextView.setText("Wars not make one great.");
                        break;
                    case 10:
                        mTextView.setText("Clear your mind must be, if you are to find the villains behind this plot.");
                        break;
                    case 11:
                        mTextView.setText("Always two there are, no more, no less. A master and an apprentice.");
                        break;
                    case 12:
                        mTextView.setText("Leave me alone, I am trying to sleep.");
                        break;
                    case 13:
                        mTextView.setText("Always pass on what you have learned.");
                        break;
                    case 14:
                        mTextView.setText("I feel disturbance in the force right now.");
                        break;
                    case 15:
                        mTextView.setText("In this war, a danger there is, of losing who we are.");
                        break;
                    case 16:
                        mTextView.setText("Attachment leads to jealously. The shadow of greed, that is.");
                        break;
                    case 17:
                        mTextView.setText("In the end, cowards are those who follow the dark side.");
                        break;
                    case 18:
                        mTextView.setText("So certain were you. Go back and closer you must look.");
                        break;
                    case 19:
                        mTextView.setText("When you look at the dark side, careful you must be. For the dark side looks back.");
                        break;
                    case 20:
                        mTextView.setText("If no mistake have you made, yet losing you are… a different game you should play.");
                        break;
                }
                break;
        }

    }
}
