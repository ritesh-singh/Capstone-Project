package com.example.riteshkumarsingh.capstone_stage2.ui.home.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseActivity;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.CelebsFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.ExploreFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.MoviesFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.TvFragment;
import com.example.riteshkumarsingh.capstone_stage2.utils.ActivityUtils;
import com.example.riteshkumarsingh.capstone_stage2.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.main_content_view_container)
    FrameLayout mMainContainer;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    private void schedulerJobScheduler(){
        UiUtils.scheduleJob(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        schedulerJobScheduler();

        Slide slide = new Slide(Gravity.LEFT);
        slide.setInterpolator(new LinearInterpolator());
        getWindow().setExitTransition(slide);
        getWindow().setReenterTransition(slide);

        mUnbinder = ButterKnife.bind(this);

        mToolBar.setNavigationIcon(R.drawable.ic_menu);
        setSupportActionBar(mToolBar);

        setUpDrawerContent();


        setToolBarTitle(getString(R.string.movies));
        mNavigationView.setCheckedItem(R.id.nav_movies);
        addFragmentView(R.id.nav_movies);
    }


    private void setToolBarTitle(String title){
        setTitle(title);
    }

    /**
     *
     * @param id - NavView menu item id.
     * This function is responsible for adding different fragments based on Navigation Drawer Click.
     */
    private void addFragmentView(int id){
        switch (id){
            case R.id.nav_explore:
                ActivityUtils.addAndReplaceFragment(ExploreFragment.newInstance(),
                        R.id.main_content_view_container,
                        getSupportFragmentManager());
                setToolBarTitle(getString(R.string.explore));
                break;
            case R.id.nav_movies:
                ActivityUtils.addAndReplaceFragment(MoviesFragment.newInstance(),
                        R.id.main_content_view_container,
                        getSupportFragmentManager());
                setToolBarTitle(getString(R.string.movies));
                break;
            case R.id.nav_tv_shows:
                ActivityUtils.addAndReplaceFragment(TvFragment.newInstance(),
                        R.id.main_content_view_container,
                        getSupportFragmentManager());
                setToolBarTitle(getString(R.string.tv));
                break;
            case R.id.nav_celebs:
                ActivityUtils.addAndReplaceFragment(CelebsFragment.newInstance(),
                        R.id.main_content_view_container,
                        getSupportFragmentManager());
                setToolBarTitle(getString(R.string.celebs));
                break;
            default:
                return;
        }
    }


    /**
     *
     */
    private int mDrawerMenuClickedItem = -1;

    /**
     * Setting up the drawer content and adding NavigationOnItemSelectedListener.
     */
    private void setUpDrawerContent(){
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerMenuClickedItem = menuItem.getItemId();
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });


        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                if (mDrawerMenuClickedItem != -1)
                    addFragmentView(mDrawerMenuClickedItem);
                mDrawerMenuClickedItem = -1;
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
