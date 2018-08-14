package source.kevtimov.starwarsapp.activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.drawerBase.DrawerBaseActivity;
import source.kevtimov.starwarsapp.fragments.QuizFragment;

public class QuizActivity extends DrawerBaseActivity {

    private MediaPlayer mMP;
    private QuizFragment mFragment;
    public static final long IDENTIFIER = 93;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mFragment = QuizFragment.createInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFragment)
                .commit();
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return null;
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }

    @Override
    public void onStart(){
        super.onStart();

        mMP = MediaPlayer.create(this, R.raw.cantina_song);

        //mMP.start();
    }
}
