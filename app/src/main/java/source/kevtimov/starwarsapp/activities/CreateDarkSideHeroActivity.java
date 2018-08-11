package source.kevtimov.starwarsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.fragments.CreateDarkSideHeroFragment;

public class CreateDarkSideHeroActivity extends AppCompatActivity {

    private CreateDarkSideHeroFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dark_side_hero);

        mFragment = CreateDarkSideHeroFragment.createInstance();


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFragment)
                .commit();
    }
}
