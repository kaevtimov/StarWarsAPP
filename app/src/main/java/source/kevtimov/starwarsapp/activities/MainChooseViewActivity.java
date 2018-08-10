package source.kevtimov.starwarsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.fragments.ChooseViewFragment;

public class MainChooseViewActivity extends AppCompatActivity {

    private ChooseViewFragment mFragment;
    public static final long IDENTIFIER = 530;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_choose_view);

        mFragment = ChooseViewFragment.createInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.view_content, mFragment)
                .commit();
    }
}
