package source.kevtimov.starwarsapp.drawerBase;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import source.kevtimov.starwarsapp.R;
import source.kevtimov.starwarsapp.activities.AboutActivity;
import source.kevtimov.starwarsapp.activities.MainChooseViewActivity;

public abstract class DrawerBaseActivity extends AppCompatActivity {

    public void setUpDrawer(){
        PrimaryDrawerItem viewHeroes = new PrimaryDrawerItem()
                .withIdentifier(MainChooseViewActivity.IDENTIFIER)
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(R.drawable.vader_logo)
                .withName("View heroes");

        PrimaryDrawerItem createSuperheroItem = new PrimaryDrawerItem()
                //.withIdentifier(SuperheroCreateActivity.IDENTIFIER)
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(android.R.drawable.ic_input_add)
                .withName("Create superhero");

        PrimaryDrawerItem aboutApp = new PrimaryDrawerItem()
                .withIdentifier(AboutActivity.IDENTIFIER)
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(android.R.drawable.ic_dialog_info)
                .withName("About");

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.vader_logo)
                .build();

        Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(getDrawerToolbar())
                .withSliderBackgroundColor(Color.BLACK)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        viewHeroes,
                        new DividerDrawerItem(),
                        createSuperheroItem,
                        new DividerDrawerItem(),
                        aboutApp
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(
                            View view,
                            int position,
                            IDrawerItem drawerItem) {
                        long identifier = drawerItem.getIdentifier();

                        if (getIdentifier() == identifier) {
                            return false;
                        }

                        Intent intent = getNextIntent(identifier);
                        if (intent == null) {
                            return false;
                        }

                        startActivity(intent);
                        return true;
                    }
                })
                .build();



    }

    protected abstract android.support.v7.widget.Toolbar getDrawerToolbar();

    protected abstract long getIdentifier();

    private Intent getNextIntent(long identifier){
        if(identifier == AboutActivity.IDENTIFIER) {
            return new Intent(DrawerBaseActivity.this, AboutActivity.class);
        }else if(identifier == MainChooseViewActivity.IDENTIFIER){
            return new Intent(DrawerBaseActivity.this, MainChooseViewActivity.class);
        }
        return null;
    }

    @Override
    public void onStart(){
        super.onStart();
        setUpDrawer();
    }
}
