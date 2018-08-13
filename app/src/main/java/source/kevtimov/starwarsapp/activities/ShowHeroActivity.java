package source.kevtimov.starwarsapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.fragments.ShowHeroFragment;
import source.kevtimov.starwarsapp.models.Hero;

public class ShowHeroActivity extends AppCompatActivity {

    private ShowHeroFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hero);

        Intent intent = getIntent();

        Hero hero = (Hero) intent.getSerializableExtra("Hero");


        mFragment = ShowHeroFragment.createInstance();
        mFragment.setHero(hero);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFragment)
                .commit();
    }
}
