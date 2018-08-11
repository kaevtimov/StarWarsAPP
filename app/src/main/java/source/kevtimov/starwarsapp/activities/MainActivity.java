package source.kevtimov.starwarsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.fragments.DarkSideViewFragment;
import source.kevtimov.starwarsapp.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    private MainFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = MainFragment.createInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content, mFragment)
                .commit();

    }

}
