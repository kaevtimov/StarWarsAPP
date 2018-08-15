package source.kevtimov.starwarsapp.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.drawerBase.DrawerBaseActivity;
import source.kevtimov.starwarsapp.fragments.LightsaberFragment;

public class LightsaberActivity extends DrawerBaseActivity {

    public static final long IDENTIFIER = 940;
    private LightsaberFragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lightsaber);

        mFragment = LightsaberFragment.createInstance();

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
