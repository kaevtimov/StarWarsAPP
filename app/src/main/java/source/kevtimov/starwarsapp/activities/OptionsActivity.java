package source.kevtimov.starwarsapp.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.drawerBase.DrawerBaseActivity;
import source.kevtimov.starwarsapp.fragments.OptionsFragment;

public class OptionsActivity extends DrawerBaseActivity {

    private OptionsFragment mFragment;
    private Toolbar mToolbar;
    public static final long IDENTIFIER = 169;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        mFragment = OptionsFragment.createInstance();
        mToolbar = this.findViewById(R.id.tb_drawer);
        mToolbar.setTitle(R.string.star_wars);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.options_content, mFragment)
                .commit();
    }

    @Override
    protected Toolbar getDrawerToolbar() {
        return mToolbar;
    }

    @Override
    protected long getIdentifier() {
        return IDENTIFIER;
    }
}
