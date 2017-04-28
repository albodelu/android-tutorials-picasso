package io.futurestud.tutorials.picasso.ui.activities;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.futurestud.tutorials.picasso.R;
import io.futurestud.tutorials.picasso.transformation.BlurTransformation;
import io.futurestud.tutorials.picasso.transformation.GrayscaleTransformation;
import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class UsageExampleRotationTransformation extends AppCompatActivity {

    @BindView(R.id.standard_list_imageview1) ImageView imageViewSimpleRotate;
    @BindView(R.id.standard_list_imageview2) ImageView imageViewComplexRotate;
    @BindView(R.id.standard_list_imageview3) ImageView imageViewTransformationBlur;
    @BindView(R.id.standard_list_imageview4) ImageView imageViewTransformationsMultiple;
    @BindView(R.id.standard_list_imageview5) ImageView imageViewTransformationLibrary;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_standard_imageview);
        ButterKnife.bind( this );

        loadImageWithSimpleRotate();
        loadImageWithComplexRotate();
        loadImageWithTransformation();
        loadImageWithMultipleTransformation();
        loadImageWithTransformationLibrary();
    }

    private void loadImageWithSimpleRotate() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .rotate(90f)
                .into(imageViewSimpleRotate);
    }

    private void loadImageWithComplexRotate() {
        Picasso
                .with(context)
                .load(R.drawable.floorplan)
                .rotate(45f, 200f, 100f)
                .into(imageViewComplexRotate);
    }

    private void loadImageWithTransformation() {
        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                        //.transform(new GrayscaleTransformation(Picasso.with(context)))
                .transform(new BlurTransformation(context))
                .into(imageViewTransformationBlur);
    }

    private void loadImageWithMultipleTransformation() {
        List<Transformation> transformations = new ArrayList<>();

        transformations.add(new GrayscaleTransformation(Picasso.with(context)));
        transformations.add(new BlurTransformation(context));

        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .transform(transformations)
                .into(imageViewTransformationsMultiple);
    }


    private void loadImageWithTransformationLibrary() {
        int color = Color.parseColor("#339b59b6");

        Picasso
                .with(context)
                .load(UsageExampleListView.eatFoodyImages[0])
                .transform(new ColorFilterTransformation(color))
                .transform(new CropCircleTransformation())
                .into(imageViewTransformationLibrary);
    }
}
