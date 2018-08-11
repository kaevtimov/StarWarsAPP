package source.kevtimov.starwarsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.fragments.CreateTheForceHeroFragment;

public class CreateTheForceHeroActivity extends AppCompatActivity {

    private CreateTheForceHeroFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_the_force_hero);


        mFragment = CreateTheForceHeroFragment.createInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFragment)
                .commit();
    }
}
