package com.example.riteshkumarsingh.capstone_stage2.ui.home;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.riteshkumarsingh.capstone_stage2.R;
import com.example.riteshkumarsingh.capstone_stage2.core.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.main_content_view_container)
    FrameLayout mMainContainer;

    @BindView(R.id.nav_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUnbinder = ButterKnife.bind(this);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        setUpDrawerContent();
    }

    private void setUpDrawerContent(){
        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
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
