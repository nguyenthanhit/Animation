package sg.vinova.myapplication.activity;
/* *
 *  Created by JAY on 20/06/2018
 */

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import sg.vinova.myapplication.R;
import sg.vinova.myapplication.adapter.DetailAdapter;
import sg.vinova.myapplication.model.Food;
import sg.vinova.myapplication.util.Constants;
import sg.vinova.myapplication.util.Util;

public class FoodDetailActivity extends AppCompatActivity {

    @BindView(R.id.rvReview)
    RecyclerView rvReview;

    @BindView(R.id.ivCover)
    ImageView ivFoodCover;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fbLike)
    FloatingActionButton fabLike;

    Food food;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this);
        food = (Food) getIntent().getSerializableExtra(Constants.FOOD);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(food.getName());

        rvReview.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvReview.setAdapter(new DetailAdapter(food));

        Util.loadImage(food.getCover(), ivFoodCover);

        Animation animator = AnimationUtils.loadAnimation(this, R.anim.scale_anim);
        fabLike.startAnimation(animator);
    }

    @Override
    public void onBackPressed() {
        fabLike.animate().alpha(0)
                .scaleX(0)
                .scaleY(0)
                .setDuration(300)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        fabLike.hide();
                        FoodDetailActivity.super.onBackPressed();
                    }
                }).start();
    }
}
