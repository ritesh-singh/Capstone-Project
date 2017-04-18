package com.example.riteshkumarsingh.capstone_stage2.ui.home.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.riteshkumarsingh.capstone_stage2.constants.Constants;
import com.example.riteshkumarsingh.capstone_stage2.constants.Counts;
import com.example.riteshkumarsingh.capstone_stage2.constants.LaunchModes;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.celebfragments.PopularCelebFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.explorefragments.ExploreMoviesFragments;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.explorefragments.ExploreTvShowsFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviesNowPlayingFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviesPopularFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviesTopRatedFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.moviesfragments.MoviesUpcomingFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.tvfragments.ArrivingTodayTvShowsFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.tvfragments.OnTvTvShowsFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.tvfragments.PopularTvShowsFragment;
import com.example.riteshkumarsingh.capstone_stage2.ui.home.fragments.viewpagerfragments.tvfragments.TopRatedTvShowsFragment;

import java.util.List;

/**
 * Created by riteshkumarsingh on 18/04/17.
 */

public class CustomFragmentStatePagerAdapter extends FragmentStatePagerAdapter{

    private int mTotalCount;

    @LaunchModes
    private int mLaunchMode;

    private List<String> mTabTitles;

    public CustomFragmentStatePagerAdapter(FragmentManager fm,
                                           @Counts int totalCount,
                                           @LaunchModes int launchMode,
                                           List<String> tabTitles) {
        super(fm);
        this.mTotalCount = totalCount;
        this.mLaunchMode = launchMode;
        this.mTabTitles = tabTitles;
    }

    private Fragment getExploreFragments(int position){
        switch (position){
            case 0:
                return ExploreMoviesFragments.newInstance();
            case 1:
                return ExploreTvShowsFragment.newInstance();
            default:
                return null;
        }
    }

    private Fragment getMoviesFragments(int position){
        switch (position){
            case 0:
                return MoviesPopularFragment.newInstance();
            case 1:
                return MoviesTopRatedFragment.newInstance();
            case 2:
                return MoviesNowPlayingFragment.newInstance();
            case 3:
                return MoviesUpcomingFragment.newInstance();
            default:
                return null;
        }
    }

    private Fragment getTvFragments(int position){
        switch (position){
            case 0:
                return PopularTvShowsFragment.newInstance();
            case 1:
                return TopRatedTvShowsFragment.newInstance();
            case 2:
                return OnTvTvShowsFragment.newInstance();
            case 3:
                return ArrivingTodayTvShowsFragment.newInstance();
            default:
                return null;
        }
    }

    private Fragment getCelebFragments(int position){
        switch (position){
            case 0:
                return PopularCelebFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (mLaunchMode){
            case Constants.EXPLORE_LAUNCH_MODE:
                return getExploreFragments(position);
            case Constants.MOVIE_LAUNCH_MODE:
                return getMoviesFragments(position);
            case Constants.TVSERIES_LAUNCH_MODE:
                return getTvFragments(position);
            case Constants.CELEBS_LAUNCH_MODE:
                return getCelebFragments(position);
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mTotalCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }
}
