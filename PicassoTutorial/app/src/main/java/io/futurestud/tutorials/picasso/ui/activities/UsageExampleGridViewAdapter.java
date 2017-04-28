package io.futurestud.tutorials.picasso.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.picasso.R;
import io.futurestud.tutorials.picasso.ui.adapter.SimpleImageListAdapter;

public class UsageExampleGridViewAdapter extends AppCompatActivity {

    @BindView(R.id.usage_example_gridview) GridView gridView;

    public UsageExampleGridViewAdapter() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_usage_example_gridview);
        GridView gridView = (GridView) findViewById( R.id.usage_example_gridview );
        ButterKnife.bind( this );

        gridView.setAdapter(new SimpleImageListAdapter(UsageExampleGridViewAdapter.this, UsageExampleListView.eatFoodyImages));
    }
}