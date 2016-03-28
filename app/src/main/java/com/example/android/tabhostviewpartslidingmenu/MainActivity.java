package com.example.android.tabhostviewpartslidingmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {
    ViewPager viewPager;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPager();
        inutTabhost();

    }

    private void inutTabhost() {
     tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        String tabNames[]= new String[]{"Tab1", "Tab2", "Tab3","Tab4","Tab5","Tab6","Tab7","Tab8","Tab9"};
        for(int i=0;i<tabNames.length;i++){
            TabHost.TabSpec tabSpec;
            tabSpec=tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getApplicationContext()));
            tabHost.addTab(tabSpec);

        }
        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
     tabHost.setCurrentTab(position);
    }
    //viewpager Listener
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String tabId) {
     int selecteditem=tabHost.getCurrentTab();
        viewPager.setCurrentItem(selecteditem);

        HorizontalScrollView horizontalScrollView= (HorizontalScrollView) findViewById(R.id.h_scroll_view);
        View tabview=tabHost.getCurrentTabView();
        int scrollpos= tabview.getLeft()-(horizontalScrollView.getWidth()-tabview.getWidth())/2;
        horizontalScrollView.smoothScrollTo(scrollpos,0);
    }

    public class FakeContent implements TabHost.TabContentFactory {
        Context context;
        public FakeContent(Context mcontext){
              context=mcontext;
        }

        @Override
        public View createTabContent(String tag) {
            View fakeview=new View(context);
            fakeview.setMinimumHeight(0);
            fakeview.setMinimumWidth(0);
            return fakeview;
        }


    }

    private void initPager(){
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        List<Fragment> listFragment=new ArrayList<Fragment>();
        listFragment.add(new Fragment1());
        listFragment.add(new Fragment2());
        listFragment.add(new Fragment3());
        listFragment.add(new Fragment1());
        listFragment.add(new Fragment2());
        listFragment.add(new Fragment3());
        listFragment.add(new Fragment1());
        listFragment.add(new Fragment2());
        listFragment.add(new Fragment3());
        Log.i("count/////////////////", String.valueOf(listFragment.size()));

        MyFragmentPagerAdapter myFragmentPagerAdapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),listFragment);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}
