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
import source.kevtimov.starwarsapp.activities.AskYodaActivity;
import source.kevtimov.starwarsapp.activities.LightsaberActivity;
import source.kevtimov.starwarsapp.activities.MainChooseViewActivity;
import source.kevtimov.starwarsapp.activities.MainCreateActivity;
import source.kevtimov.starwarsapp.activities.QuizActivity;

public abstract class DrawerBaseActivity extends AppCompatActivity {

    public void setUpDrawer(){
        PrimaryDrawerItem viewHeroes = new PrimaryDrawerItem()
                .withIdentifier(MainChooseViewActivity.IDENTIFIER)
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(R.drawable.vader_logo)
                .withName("View heroes");

        PrimaryDrawerItem createSuperheroItem = new PrimaryDrawerItem()
                .withIdentifier(MainCreateActivity.IDENTIFIER)
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(android.R.drawable.ic_input_add)
                .withName("Create superhero");

        PrimaryDrawerItem quiz = new PrimaryDrawerItem()
                .withIdentifier(QuizActivity.IDENTIFIER)
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(android.R.drawable.ic_media_play)
                .withName("Quiz");

        PrimaryDrawerItem askYoda = new PrimaryDrawerItem()
                .withIdentifier(AskYodaActivity.IDENTIFIER)
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(R.drawable.yoda_icon)
                .withSelectedColor(Color.GREEN)
                .withName("Ask master Yoda");

        PrimaryDrawerItem lightsaber = new PrimaryDrawerItem()
                .withIdentifier(LightsaberActivity.IDENTIFIER)
                .withTextColor(Color.WHITE)
                .withSelectedTextColor(Color.BLACK)
                .withIcon(R.drawable.common_google_signin_btn_text_dark_focused)
                .withName("Lightsaber");

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
                        quiz,
                        new DividerDrawerItem(),
                        askYoda,
                        new DividerDrawerItem(),
                        lightsaber,
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
        }else if(identifier == MainCreateActivity.IDENTIFIER){
            return new Intent(DrawerBaseActivity.this, MainCreateActivity.class);
        }else if(identifier == AskYodaActivity.IDENTIFIER){
            return new Intent (DrawerBaseActivity.this, AskYodaActivity.class);
        }else if(identifier == QuizActivity.IDENTIFIER){
            return new Intent(DrawerBaseActivity.this, QuizActivity.class);
        }else if(identifier == LightsaberActivity.IDENTIFIER){
            return new Intent(DrawerBaseActivity.this, LightsaberActivity.class);
        }
        return null;
    }

    @Override
    public void onStart(){
        super.onStart();
        setUpDrawer();
    }
}
