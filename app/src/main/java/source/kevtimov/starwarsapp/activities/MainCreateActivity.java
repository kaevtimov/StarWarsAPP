package source.kevtimov.starwarsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.fragments.MainCreateFragment;

public class MainCreateActivity extends AppCompatActivity {


    private MainCreateFragment mFragment;
    public static final long IDENTIFIER = 281;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);


        mFragment = MainCreateFragment.createInstance();


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, mFragment)
                .commit();
    }
}
