package source.kevtimov.starwarsapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.drawerBase.DrawerBaseActivity;
import source.kevtimov.starwarsapp.fragments.AskYodaFragment;

public class AskYodaActivity extends DrawerBaseActivity {


    private AskYodaFragment mFragment;
    public static final long IDENTIFIER = 267;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_yoda);

        mFragment = AskYodaFragment.createInstance();



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
}
