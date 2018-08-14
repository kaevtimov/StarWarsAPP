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

import java.util.ArrayList;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.models.questions.Player;
import source.kevtimov.starwarsapp.models.questions.QueastionDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment implements View.OnClickListener {

    private Player mPlayer;
    private ImageView mImageViewBg;
    private ImageView mImageViewLogo;
    private TextView mTextViewName;
    private EditText mEditTextName;
    private Button mButtonBegin;
    private QueastionDatabase mDatabase;
    private Button mButtonAnswer1;
    private Button mButtonAnswer2;
    private Button mButtonAnswer3;
    private TextView mTextViewQuestion;
    private static int mPlayerPoints = 0;

    public QuizFragment() {
        // Required empty public constructor
    }

    public static QuizFragment createInstance(){
        return new QuizFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_quiz, container, false);

        mImageViewBg = root.findViewById(R.id.iv_quiz_bg);
        mImageViewLogo = root.findViewById(R.id.iv_quiz_show);

        mTextViewQuestion = root.findViewById(R.id.tv_quiz_question);
        mTextViewQuestion.setTextColor(Color.WHITE);
        mTextViewQuestion.setVisibility(View.INVISIBLE);

        mTextViewName = root.findViewById(R.id.tv_player_name);
        mEditTextName = root.findViewById(R.id.et_player_name);

        mButtonAnswer1 = root.findViewById(R.id.btn_answer1);
        mButtonAnswer1.setVisibility(View.INVISIBLE);
        mButtonAnswer2 = root.findViewById(R.id.btn_answer2);
        mButtonAnswer2.setVisibility(View.INVISIBLE);
        mButtonAnswer3 = root.findViewById(R.id.btn_answer3);
        mButtonAnswer3.setVisibility(View.INVISIBLE);


        mButtonBegin = root.findViewById(R.id.btn_enter_name);
        mButtonBegin.setTextColor(Color.BLACK);
        mButtonBegin.setOnClickListener(this);




        return root;
    }

    @Override
    public void onClick(View v) {
        String playerName = mEditTextName.getText().toString();
        mPlayer = new Player(playerName, 0);
        mDatabase = new QueastionDatabase(new ArrayList<>());
        mDatabase.loadDatabase();

        mButtonBegin.setVisibility(View.INVISIBLE);
        mTextViewName.setVisibility(View.INVISIBLE);
        mEditTextName.setVisibility(View.INVISIBLE);

        mTextViewQuestion.setVisibility(View.VISIBLE);
        mTextViewQuestion.setText(mDatabase.getQuestions().get(0).getQuestion());

        mButtonAnswer1.setVisibility(View.VISIBLE);
        mButtonAnswer1.setText(mDatabase
                .getQuestions()
                .get(0)
                .getAnswers()
                .get(0));
        mButtonAnswer2.setVisibility(View.VISIBLE);
        mButtonAnswer2.setText(mDatabase
                .getQuestions()
                .get(0)
                .getAnswers()
                .get(1));
        mButtonAnswer3.setVisibility(View.VISIBLE);
        mButtonAnswer3.setText(mDatabase
                .getQuestions()
                .get(0)
                .getAnswers()
                .get(2));

        mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send me to fail activity
            }
        });

        mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //continue
            }
        });

        mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send me to fail activity
            }
        });


    }
}
