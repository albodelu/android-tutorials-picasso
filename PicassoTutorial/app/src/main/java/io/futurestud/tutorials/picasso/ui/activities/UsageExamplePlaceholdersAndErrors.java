package io.futurestud.tutorials.picasso.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.picasso.R;

public class UsageExamplePlaceholdersAndErrors extends AppCompatActivity {

    @BindView(R.id.standard_list_imageview1) ImageView imageViewPlaceholder;
    @BindView(R.id.standard_list_imageview2) ImageView imageViewError;
    @BindView(R.id.standard_list_imageview3) ImageView imageViewFade;
    @BindView(R.id.standard_list_imageview4) ImageView imageViewCombined;
    @BindView(R.id.standard_list_imageview5) ImageView imageViewNoPlaceholder;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.bind( this );

        loadImageWithPlaceholder();
        loadImageWithError();
        loadImageNoFade();
        loadImageCombination();

        loadImageWithNoPlaceholder();
    }

    private void loadImageWithPlaceholder() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .into(imageViewPlaceholder);
    }

    private void loadImageWithError() {
        Picasso
                .with(context)
                .load("http://futurestud.io/non_existing_image.png")
                .error(R.mipmap.future_studio_launcher) // will be displayed if the image cannot be loaded
                .into(imageViewError);
    }

    private void loadImageNoFade() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .noFade()
                .into(imageViewFade);
    }

    private void loadImageCombination() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .error(R.mipmap.future_studio_launcher) // will be displayed if the image cannot be loaded
                .noFade()
                .into(imageViewCombined);
    }

    private void loadImageWithNoPlaceholder() {
        // load an image into the imageview
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .placeholder(R.mipmap.ic_launcher) // can also be a drawable
                .into(imageViewNoPlaceholder, new Callback() {
                    @Override
                    public void onSuccess() {
                        // once the image is loaded, load the next image
                        Picasso
                                .with(context)
                                .load(UsageExampleListView.eatFoodyImages[1])
                                .noPlaceholder() // but don't clear the imageview or set a placeholder; just leave the previous image in until the new one is ready
                                .into(imageViewNoPlaceholder);
                    }

                    @Override
                    public void onError() {

                    }
                });


    }
}