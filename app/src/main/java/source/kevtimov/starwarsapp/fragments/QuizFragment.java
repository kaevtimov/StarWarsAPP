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
import android.widget.Toast;

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
    private TextView mTextViewQuestNumber;
    private TextView mTextViewFinal;
    private static int questionNumber = 1;

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

        mTextViewFinal = root.findViewById(R.id.tv_final_result);
        mTextViewFinal.setVisibility(View.INVISIBLE);

        mTextViewQuestNumber = root.findViewById(R.id.tv_quest_number);
        mTextViewQuestNumber.setVisibility(View.INVISIBLE);

        mTextViewName = root.findViewById(R.id.tv_player_name);
        mEditTextName = root.findViewById(R.id.et_player_name);

        mButtonAnswer1 = root.findViewById(R.id.btn_answer1);
        mButtonAnswer1.setVisibility(View.INVISIBLE);
        mButtonAnswer2 = root.findViewById(R.id.btn_answer2);
        mButtonAnswer2.setVisibility(View.INVISIBLE);
        mButtonAnswer3 = root.findViewById(R.id.btn_answer3);
        mButtonAnswer3.setVisibility(View.INVISIBLE);


        mButtonBegin = root.findViewById(R.id.btn_enter_name);
        mButtonBegin.setTextColor(Color.YELLOW);
        mButtonBegin.setText("BEGIN");
        mButtonBegin.setOnClickListener(this);




        return root;
    }

    @Override
    public void onClick(View v) {
        String playerName = mEditTextName.getText().toString();
        mPlayer = new Player(playerName, 0);
        mDatabase = new QueastionDatabase(new ArrayList<>());
        mDatabase.loadDatabase();

        mTextViewQuestNumber.setVisibility(View.VISIBLE);
        mTextViewQuestNumber.setText("1/10");
        mTextViewQuestNumber.setTextColor(Color.YELLOW);

        mButtonBegin.setVisibility(View.GONE);
        mTextViewName.setVisibility(View.GONE);
        mEditTextName.setVisibility(View.GONE);

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
                //fail
                mTextViewQuestNumber.setVisibility(View.GONE);
                mTextViewQuestion.setVisibility(View.GONE);
                mButtonAnswer1.setVisibility(View.GONE);
                mButtonAnswer2.setVisibility(View.GONE);
                mButtonAnswer3.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                        .show();

                mTextViewFinal.setVisibility(View.VISIBLE);
                mTextViewFinal.setText("Sorry! Try again...\n"
                        + "Payer name: " + mPlayer.getName() + "\n"
                        + "Points: " + mPlayer.getPoints() + "/50");
                mTextViewFinal.setTextSize(26);
            }
        });

        mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //continue
                Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                        .show();
                mPlayer.setPoints(mPlayer.getPoints()+5);
                mTextViewQuestNumber.setText("2/10");
                mTextViewQuestion.setText(mDatabase.getQuestions().get(1).getQuestion());

                mButtonAnswer1.setText(mDatabase
                        .getQuestions()
                        .get(1)
                        .getAnswers()
                        .get(0));
                mButtonAnswer2.setText(mDatabase
                        .getQuestions()
                        .get(1)
                        .getAnswers()
                        .get(1));
                mButtonAnswer3.setText(mDatabase
                        .getQuestions()
                        .get(1)
                        .getAnswers()
                        .get(2));

                mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //continue
                        Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                .show();
                        mPlayer.setPoints(mPlayer.getPoints()+5);
                        mTextViewQuestNumber.setText("3/10");
                        mTextViewQuestion.setText(mDatabase.getQuestions().get(2).getQuestion());

                        mButtonAnswer1.setText(mDatabase
                                .getQuestions()
                                .get(2)
                                .getAnswers()
                                .get(0));
                        mButtonAnswer2.setText(mDatabase
                                .getQuestions()
                                .get(2)
                                .getAnswers()
                                .get(1));
                        mButtonAnswer3.setText(mDatabase
                                .getQuestions()
                                .get(2)
                                .getAnswers()
                                .get(2));

                        mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //fail
                                mTextViewQuestNumber.setVisibility(View.GONE);
                                mTextViewQuestion.setVisibility(View.GONE);
                                mButtonAnswer1.setVisibility(View.GONE);
                                mButtonAnswer2.setVisibility(View.GONE);
                                mButtonAnswer3.setVisibility(View.GONE);
                                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                        .show();

                                mTextViewFinal.setVisibility(View.VISIBLE);
                                mTextViewFinal.setText("Sorry! Try again...\n"
                                        + "Payer name: " + mPlayer.getName() + "\n"
                                        + "Points: " + mPlayer.getPoints() + "/50");
                                mTextViewFinal.setTextSize(26);
                            }
                        });
                        mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //continue
                                Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                        .show();
                                mPlayer.setPoints(mPlayer.getPoints()+5);
                                mTextViewQuestNumber.setText("4/10");
                                mTextViewQuestion.setText(mDatabase.getQuestions().get(3).getQuestion());

                                mButtonAnswer1.setText(mDatabase
                                        .getQuestions()
                                        .get(3)
                                        .getAnswers()
                                        .get(0));
                                mButtonAnswer2.setText(mDatabase
                                        .getQuestions()
                                        .get(3)
                                        .getAnswers()
                                        .get(1));
                                mButtonAnswer3.setText(mDatabase
                                        .getQuestions()
                                        .get(3)
                                        .getAnswers()
                                        .get(2));

                                mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        //fail
                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                        mTextViewQuestion.setVisibility(View.GONE);
                                        mButtonAnswer1.setVisibility(View.GONE);
                                        mButtonAnswer2.setVisibility(View.GONE);
                                        mButtonAnswer3.setVisibility(View.GONE);
                                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                .show();

                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                        mTextViewFinal.setText("Sorry! Try again...\n"
                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                + "Points: " + mPlayer.getPoints() + "/50");
                                        mTextViewFinal.setTextSize(26);
                                    }
                                });
                                mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        //fail
                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                        mTextViewQuestion.setVisibility(View.GONE);
                                        mButtonAnswer1.setVisibility(View.GONE);
                                        mButtonAnswer2.setVisibility(View.GONE);
                                        mButtonAnswer3.setVisibility(View.GONE);
                                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                .show();

                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                        mTextViewFinal.setText("Sorry! Try again...\n"
                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                + "Points: " + mPlayer.getPoints() + "/50");
                                        mTextViewFinal.setTextSize(26);
                                    }
                                });
                                mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        //continue
                                        Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                                .show();
                                        mPlayer.setPoints(mPlayer.getPoints()+5);
                                        mTextViewQuestNumber.setText("5/10");
                                        mTextViewQuestion.setText(mDatabase.getQuestions().get(4).getQuestion());

                                        mButtonAnswer1.setText(mDatabase
                                                .getQuestions()
                                                .get(4)
                                                .getAnswers()
                                                .get(0));
                                        mButtonAnswer2.setText(mDatabase
                                                .getQuestions()
                                                .get(4)
                                                .getAnswers()
                                                .get(1));
                                        mButtonAnswer3.setText(mDatabase
                                                .getQuestions()
                                                .get(4)
                                                .getAnswers()
                                                .get(2));

                                        mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                //fail
                                                mTextViewQuestNumber.setVisibility(View.GONE);
                                                mTextViewQuestion.setVisibility(View.GONE);
                                                mButtonAnswer1.setVisibility(View.GONE);
                                                mButtonAnswer2.setVisibility(View.GONE);
                                                mButtonAnswer3.setVisibility(View.GONE);
                                                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                        .show();

                                                mTextViewFinal.setVisibility(View.VISIBLE);
                                                mTextViewFinal.setText("Sorry! Try again...\n"
                                                        + "Payer name: " + mPlayer.getName() + "\n"
                                                        + "Points: " + mPlayer.getPoints() + "/50");
                                                mTextViewFinal.setTextSize(26);
                                            }
                                        });
                                        mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                //fail
                                                mTextViewQuestNumber.setVisibility(View.GONE);
                                                mTextViewQuestion.setVisibility(View.GONE);
                                                mButtonAnswer1.setVisibility(View.GONE);
                                                mButtonAnswer2.setVisibility(View.GONE);
                                                mButtonAnswer3.setVisibility(View.GONE);
                                                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                        .show();

                                                mTextViewFinal.setVisibility(View.VISIBLE);
                                                mTextViewFinal.setText("Sorry! Try again...\n"
                                                        + "Payer name: " + mPlayer.getName() + "\n"
                                                        + "Points: " + mPlayer.getPoints() + "/50");
                                                mTextViewFinal.setTextSize(26);
                                            }
                                        });
                                        mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                //continue
                                                Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                                        .show();
                                                mPlayer.setPoints(mPlayer.getPoints()+5);
                                                mTextViewQuestNumber.setText("6/10");
                                                mTextViewQuestion.setText(mDatabase.getQuestions().get(5).getQuestion());

                                                mButtonAnswer1.setText(mDatabase
                                                        .getQuestions()
                                                        .get(5)
                                                        .getAnswers()
                                                        .get(0));
                                                mButtonAnswer2.setText(mDatabase
                                                        .getQuestions()
                                                        .get(5)
                                                        .getAnswers()
                                                        .get(1));
                                                mButtonAnswer3.setText(mDatabase
                                                        .getQuestions()
                                                        .get(5)
                                                        .getAnswers()
                                                        .get(2));

                                                mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        //fail
                                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                                        mTextViewQuestion.setVisibility(View.GONE);
                                                        mButtonAnswer1.setVisibility(View.GONE);
                                                        mButtonAnswer2.setVisibility(View.GONE);
                                                        mButtonAnswer3.setVisibility(View.GONE);
                                                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                .show();

                                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                                        mTextViewFinal.setText("Sorry! Try again...\n"
                                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                                + "Points: " + mPlayer.getPoints() + "/50");
                                                        mTextViewFinal.setTextSize(26);
                                                    }
                                                });
                                                mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        //continue
                                                        Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                                                .show();
                                                        mPlayer.setPoints(mPlayer.getPoints()+5);
                                                        mTextViewQuestNumber.setText("7/10");
                                                        mTextViewQuestion.setText(mDatabase.getQuestions().get(6).getQuestion());

                                                        mButtonAnswer1.setText(mDatabase
                                                                .getQuestions()
                                                                .get(6)
                                                                .getAnswers()
                                                                .get(0));
                                                        mButtonAnswer2.setText(mDatabase
                                                                .getQuestions()
                                                                .get(6)
                                                                .getAnswers()
                                                                .get(1));
                                                        mButtonAnswer3.setText(mDatabase
                                                                .getQuestions()
                                                                .get(6)
                                                                .getAnswers()
                                                                .get(2));

                                                        mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                //fail
                                                                mTextViewQuestNumber.setVisibility(View.GONE);
                                                                mTextViewQuestion.setVisibility(View.GONE);
                                                                mButtonAnswer1.setVisibility(View.GONE);
                                                                mButtonAnswer2.setVisibility(View.GONE);
                                                                mButtonAnswer3.setVisibility(View.GONE);
                                                                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                        .show();

                                                                mTextViewFinal.setVisibility(View.VISIBLE);
                                                                mTextViewFinal.setText("Sorry! Try again...\n"
                                                                        + "Payer name: " + mPlayer.getName() + "\n"
                                                                        + "Points: " + mPlayer.getPoints() + "/50");
                                                                mTextViewFinal.setTextSize(26);
                                                            }
                                                        });
                                                        mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                //continue
                                                                Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                                                        .show();
                                                                mPlayer.setPoints(mPlayer.getPoints()+5);
                                                                mTextViewQuestNumber.setText("8/10");
                                                                mTextViewQuestion.setText(mDatabase.getQuestions().get(7).getQuestion());

                                                                mButtonAnswer1.setText(mDatabase
                                                                        .getQuestions()
                                                                        .get(7)
                                                                        .getAnswers()
                                                                        .get(0));
                                                                mButtonAnswer2.setText(mDatabase
                                                                        .getQuestions()
                                                                        .get(7)
                                                                        .getAnswers()
                                                                        .get(1));
                                                                mButtonAnswer3.setText(mDatabase
                                                                        .getQuestions()
                                                                        .get(7)
                                                                        .getAnswers()
                                                                        .get(2));

                                                                mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        //continue
                                                                        Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                                                                .show();
                                                                        mPlayer.setPoints(mPlayer.getPoints()+5);
                                                                        mTextViewQuestNumber.setText("9/10");
                                                                        mTextViewQuestion.setText(mDatabase.getQuestions().get(8).getQuestion());

                                                                        mButtonAnswer1.setText(mDatabase
                                                                                .getQuestions()
                                                                                .get(8)
                                                                                .getAnswers()
                                                                                .get(0));
                                                                        mButtonAnswer2.setText(mDatabase
                                                                                .getQuestions()
                                                                                .get(8)
                                                                                .getAnswers()
                                                                                .get(1));
                                                                        mButtonAnswer3.setText(mDatabase
                                                                                .getQuestions()
                                                                                .get(8)
                                                                                .getAnswers()
                                                                                .get(2));

                                                                        mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                //fail
                                                                                mTextViewQuestNumber.setVisibility(View.GONE);
                                                                                mTextViewQuestion.setVisibility(View.GONE);
                                                                                mButtonAnswer1.setVisibility(View.GONE);
                                                                                mButtonAnswer2.setVisibility(View.GONE);
                                                                                mButtonAnswer3.setVisibility(View.GONE);
                                                                                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                                        .show();

                                                                                mTextViewFinal.setVisibility(View.VISIBLE);
                                                                                mTextViewFinal.setText("Sorry! Try again...\n"
                                                                                        + "Payer name: " + mPlayer.getName() + "\n"
                                                                                        + "Points: " + mPlayer.getPoints() + "/50");
                                                                                mTextViewFinal.setTextSize(26);
                                                                            }
                                                                        });
                                                                        mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                //fail
                                                                                mTextViewQuestNumber.setVisibility(View.GONE);
                                                                                mTextViewQuestion.setVisibility(View.GONE);
                                                                                mButtonAnswer1.setVisibility(View.GONE);
                                                                                mButtonAnswer2.setVisibility(View.GONE);
                                                                                mButtonAnswer3.setVisibility(View.GONE);
                                                                                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                                        .show();

                                                                                mTextViewFinal.setVisibility(View.VISIBLE);
                                                                                mTextViewFinal.setText("Sorry! Try again...\n"
                                                                                        + "Payer name: " + mPlayer.getName() + "\n"
                                                                                        + "Points: " + mPlayer.getPoints() + "/50");
                                                                                mTextViewFinal.setTextSize(26);
                                                                            }
                                                                        });
                                                                        mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                //continue
                                                                                Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                                                                        .show();
                                                                                mPlayer.setPoints(mPlayer.getPoints()+5);
                                                                                mTextViewQuestNumber.setText("10/10");
                                                                                mTextViewQuestion.setText(mDatabase.getQuestions().get(9).getQuestion());

                                                                                mButtonAnswer1.setText(mDatabase
                                                                                        .getQuestions()
                                                                                        .get(9)
                                                                                        .getAnswers()
                                                                                        .get(0));
                                                                                mButtonAnswer2.setText(mDatabase
                                                                                        .getQuestions()
                                                                                        .get(9)
                                                                                        .getAnswers()
                                                                                        .get(1));
                                                                                mButtonAnswer3.setText(mDatabase
                                                                                        .getQuestions()
                                                                                        .get(9)
                                                                                        .getAnswers()
                                                                                        .get(2));

                                                                                mButtonAnswer1.setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        //winner
                                                                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                                                                        mTextViewQuestion.setVisibility(View.GONE);
                                                                                        mButtonAnswer1.setVisibility(View.GONE);
                                                                                        mButtonAnswer2.setVisibility(View.GONE);
                                                                                        mButtonAnswer3.setVisibility(View.GONE);
                                                                                        Toast.makeText(getContext(), "Correct!", Toast.LENGTH_SHORT)
                                                                                                .show();

                                                                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                                                                        mTextViewFinal.setText("CONGRATULATIONS! YOU ARE A TRUE STAR WARS FAN!\n"
                                                                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                                                                + "Points: " + mPlayer.getPoints() + "/50");
                                                                                        mTextViewFinal.setTextSize(26);
                                                                                    }
                                                                                });
                                                                                mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        //fail
                                                                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                                                                        mTextViewQuestion.setVisibility(View.GONE);
                                                                                        mButtonAnswer1.setVisibility(View.GONE);
                                                                                        mButtonAnswer2.setVisibility(View.GONE);
                                                                                        mButtonAnswer3.setVisibility(View.GONE);
                                                                                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                                                .show();

                                                                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                                                                        mTextViewFinal.setText("Sorry! Try again...\n"
                                                                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                                                                + "Points: " + mPlayer.getPoints() + "/50");
                                                                                        mTextViewFinal.setTextSize(26);
                                                                                    }
                                                                                });
                                                                                mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                                                                                    @Override
                                                                                    public void onClick(View v) {
                                                                                        //fail
                                                                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                                                                        mTextViewQuestion.setVisibility(View.GONE);
                                                                                        mButtonAnswer1.setVisibility(View.GONE);
                                                                                        mButtonAnswer2.setVisibility(View.GONE);
                                                                                        mButtonAnswer3.setVisibility(View.GONE);
                                                                                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                                                .show();

                                                                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                                                                        mTextViewFinal.setText("Sorry! Try again...\n"
                                                                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                                                                + "Points: " + mPlayer.getPoints() + "/50");
                                                                                        mTextViewFinal.setTextSize(26);
                                                                                    }
                                                                                });
                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                                mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        //fail
                                                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                                                        mTextViewQuestion.setVisibility(View.GONE);
                                                                        mButtonAnswer1.setVisibility(View.GONE);
                                                                        mButtonAnswer2.setVisibility(View.GONE);
                                                                        mButtonAnswer3.setVisibility(View.GONE);
                                                                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                                .show();

                                                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                                                        mTextViewFinal.setText("Sorry! Try again...\n"
                                                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                                                + "Points: " + mPlayer.getPoints() + "/50");
                                                                        mTextViewFinal.setTextSize(26);
                                                                    }
                                                                });
                                                                mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        //fail
                                                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                                                        mTextViewQuestion.setVisibility(View.GONE);
                                                                        mButtonAnswer1.setVisibility(View.GONE);
                                                                        mButtonAnswer2.setVisibility(View.GONE);
                                                                        mButtonAnswer3.setVisibility(View.GONE);
                                                                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                                .show();

                                                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                                                        mTextViewFinal.setText("Sorry! Try again...\n"
                                                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                                                + "Points: " + mPlayer.getPoints() + "/50");
                                                                        mTextViewFinal.setTextSize(26);
                                                                    }
                                                                });
                                                            }
                                                        });
                                                        mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View v) {
                                                                //fail
                                                                mTextViewQuestNumber.setVisibility(View.GONE);
                                                                mTextViewQuestion.setVisibility(View.GONE);
                                                                mButtonAnswer1.setVisibility(View.GONE);
                                                                mButtonAnswer2.setVisibility(View.GONE);
                                                                mButtonAnswer3.setVisibility(View.GONE);
                                                                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                        .show();

                                                                mTextViewFinal.setVisibility(View.VISIBLE);
                                                                mTextViewFinal.setText("Sorry! Try again...\n"
                                                                        + "Payer name: " + mPlayer.getName() + "\n"
                                                                        + "Points: " + mPlayer.getPoints() + "/50");
                                                                mTextViewFinal.setTextSize(26);
                                                            }
                                                        });
                                                    }
                                                });
                                                mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        //fail
                                                        mTextViewQuestNumber.setVisibility(View.GONE);
                                                        mTextViewQuestion.setVisibility(View.GONE);
                                                        mButtonAnswer1.setVisibility(View.GONE);
                                                        mButtonAnswer2.setVisibility(View.GONE);
                                                        mButtonAnswer3.setVisibility(View.GONE);
                                                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                                                .show();

                                                        mTextViewFinal.setVisibility(View.VISIBLE);
                                                        mTextViewFinal.setText("Sorry! Try again...\n"
                                                                + "Payer name: " + mPlayer.getName() + "\n"
                                                                + "Points: " + mPlayer.getPoints() + "/50");
                                                        mTextViewFinal.setTextSize(26);
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });

                            }
                        });
                        mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //fail
                                mTextViewQuestNumber.setVisibility(View.GONE);
                                mTextViewQuestion.setVisibility(View.GONE);
                                mButtonAnswer1.setVisibility(View.GONE);
                                mButtonAnswer2.setVisibility(View.GONE);
                                mButtonAnswer3.setVisibility(View.GONE);
                                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                        .show();

                                mTextViewFinal.setVisibility(View.VISIBLE);
                                mTextViewFinal.setText("Sorry! Try again...\n"
                                        + "Payer name: " + mPlayer.getName() + "\n"
                                        + "Points: " + mPlayer.getPoints() + "/50");
                                mTextViewFinal.setTextSize(26);
                            }
                        });

                    }
                });
                mButtonAnswer2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //fail
                        mTextViewQuestNumber.setVisibility(View.GONE);
                        mTextViewQuestion.setVisibility(View.GONE);
                        mButtonAnswer1.setVisibility(View.GONE);
                        mButtonAnswer2.setVisibility(View.GONE);
                        mButtonAnswer3.setVisibility(View.GONE);
                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                .show();

                        mTextViewFinal.setVisibility(View.VISIBLE);
                        mTextViewFinal.setText("Sorry! Try again...\n"
                                + "Payer name: " + mPlayer.getName() + "\n"
                                + "Points: " + mPlayer.getPoints() + "/50");
                        mTextViewFinal.setTextSize(26);
                    }
                });
                mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //fail
                        mTextViewQuestNumber.setVisibility(View.GONE);
                        mTextViewQuestion.setVisibility(View.GONE);
                        mButtonAnswer1.setVisibility(View.GONE);
                        mButtonAnswer2.setVisibility(View.GONE);
                        mButtonAnswer3.setVisibility(View.GONE);
                        Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                                .show();

                        mTextViewFinal.setVisibility(View.VISIBLE);
                        mTextViewFinal.setText("Sorry! Try again...\n"
                                + "Payer name: " + mPlayer.getName() + "\n"
                                + "Points: " + mPlayer.getPoints() + "/50");
                        mTextViewFinal.setTextSize(26);
                    }
                });

            }
        });

        mButtonAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fail
                mTextViewQuestNumber.setVisibility(View.GONE);
                mTextViewQuestion.setVisibility(View.GONE);
                mButtonAnswer1.setVisibility(View.GONE);
                mButtonAnswer2.setVisibility(View.GONE);
                mButtonAnswer3.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Incorrect!", Toast.LENGTH_SHORT)
                        .show();

                mTextViewFinal.setVisibility(View.VISIBLE);
                mTextViewFinal.setText("Sorry! Try again...\n"
                        + "Payer name: " + mPlayer.getName() + "\n"
                        + "Points: " + mPlayer.getPoints() + "/50");
                mTextViewFinal.setTextSize(26);
            }
        });


    }
}
