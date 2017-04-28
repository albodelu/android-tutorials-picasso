package io.futurestud.tutorials.picasso.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.picasso.R;

public class UsageExampleImageResizing extends AppCompatActivity {

    @BindView(R.id.standard_list_imageview1) ImageView imageViewResize;
    @BindView(R.id.standard_list_imageview2) ImageView imageViewResizeCenterCrop;
    @BindView(R.id.standard_list_imageview3) ImageView imageViewResizeCenterInside;
    @BindView(R.id.standard_list_imageview4) ImageView imageViewResizeScaleDown;
    @BindView(R.id.standard_list_imageview5) ImageView imageViewFit;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.bind( this );

        loadImageWithResize();
        loadImageWithResizeCenterCrop();
        loadImageWithResizeCenterInside();
        loadImageWithResizeScaleDown();
        loadImageWithFit();
    }

    private void loadImageWithResize() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .resize(600, 200) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(imageViewResize);
    }

    private void loadImageWithResizeCenterCrop() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .resize(600, 200) // resizes the image to these dimensions (in pixel)
                .centerCrop() // this cropping technique scales the image so that it fills the requested bounds and then crops the extra.
                .into(imageViewResizeCenterCrop);
    }

    private void loadImageWithResizeCenterInside() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .resize(600, 200)
                .centerInside() // this scales the image so that both dimensions are equal to or less than the requested bounds.
                .into(imageViewResizeCenterInside);
    }

    private void loadImageWithResizeScaleDown() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .resize(6000, 2000)
                .onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                .into(imageViewResizeScaleDown);
    }

    private void loadImageWithFit() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .fit()
                        // call  .centerInside() or .centerCrop() to avoid a stretched image
                .into(imageViewFit);
    }
}