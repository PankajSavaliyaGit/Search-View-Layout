package xyz.sahildave.widget.sample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import xyz.sahildave.widget.SearchViewLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        final SearchViewLayout searchViewLayout = (SearchViewLayout) findViewById(R.id.search_view_container);
        searchViewLayout.setExpandedContentFragment(this, new SearchStaticFragment());
        searchViewLayout.handleToolbarAnimation(toolbar);
        searchViewLayout.setSearchListener(new SearchViewLayout.SearchListener() {
            @Override
            public void onFinished(String searchKeyword) {
                searchViewLayout.collapse();
                Snackbar.make(searchViewLayout, "Search Done - " + searchKeyword, Snackbar.LENGTH_LONG).show();
            }
        });
        searchViewLayout.setOnToggleVisibilityListener(new SearchViewLayout.OnToggleVisibilityListener() {
            @Override
            public void onStart(boolean expanded) {
                if(expanded) {
                    fab.hide();
                } else {
                    fab.show();
                }
            }

            @Override
            public void onFinish(boolean expanded) { }
        });
    }
}
