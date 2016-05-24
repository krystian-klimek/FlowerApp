package com.krystianklimek.flowerapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.krystianklimek.flowerapp.R;
import com.krystianklimek.flowerapp.helper.Constants;
import com.krystianklimek.flowerapp.model.Flower;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by: Krystian Klimek
 * Date: 23.05.2016.
 */

public class DetailActivity extends AppCompatActivity {
    @BindView(R.id.photoImageView)
    ImageView photoImageView;
    @BindView(R.id.nameTextView)
    TextView nameTextView;
    @BindView(R.id.idTextView)
    TextView idTextView;
    @BindView(R.id.categoryTextView)
    TextView categoryTextView;
    @BindView(R.id.priceTextView)
    TextView priceTextView;
    @BindView(R.id.instructionsTextView)
    TextView instructionsTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        Flower flower = (Flower) intent.getSerializableExtra(Constants.REFERENCE.FLOWER);

        setData(flower);
    }

    private void setData(Flower flower) {
        nameTextView.setText(flower.getName());
        idTextView.setText(String.valueOf(flower.getProductId()));
        categoryTextView.setText(flower.getCategory());
        priceTextView.setText(String.valueOf(flower.getPrice()) + "€");
        instructionsTextView.setText(flower.getInstructions());

        Picasso
                .with(getApplicationContext())
                .load(Constants.HTTP.PHOTO_URL + flower.getPhoto())
                .into(photoImageView);
    }
}
