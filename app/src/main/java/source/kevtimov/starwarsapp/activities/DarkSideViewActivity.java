package source.kevtimov.starwarsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.fragments.DarkSideViewFragment;

public class DarkSideViewActivity extends AppCompatActivity {

    private DarkSideViewFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dark_side_view);

        mFragment = DarkSideViewFragment.createInstance();


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFragment)
                .commit();
    }
}
