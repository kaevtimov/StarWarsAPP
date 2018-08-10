package source.kevtimov.starwarsapp.activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.fragments.AboutFragment;

public class AboutActivity extends AppCompatActivity {

    private AboutFragment mFragment;
    public static final long IDENTIFIER = 410;
    private MediaPlayer mMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mFragment = AboutFragment.createInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.about_content, mFragment)
                .commit();
    }

    @Override
    public void onStart(){
        super.onStart();

        mMP = MediaPlayer.create(this, R.raw.main_song);

        mMP.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        mMP.stop();
    }
}
