package sg.vinova.myapplication.activity;
/* *
 *  Created by JAY on 21/06/2018
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import sg.vinova.myapplication.R;
import sg.vinova.myapplication.util.Constants;
import sg.vinova.myapplication.util.Util;

public class UserDetailActivity extends AppCompatActivity {

    @BindView(R.id.ivAvatar)
    ImageView ivAvatar;

    @BindViews({R.id.tvLikeNumber, R.id.tvRating, R.id.tvBuyNumber})
    View[] views;

    @BindView(R.id.tvUserName)
    TextView tvUserName;

    String userName;
    String urlAvatar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);
        userName = getIntent().getStringExtra(Constants.USER_NAME);
        urlAvatar = getIntent().getStringExtra(Constants.URL_AVATAR);

        tvUserName.setText(userName);
        Util.loadImage(urlAvatar, ivAvatar);
        for (View view : views) {
            moveUp(view);
        }
    }

    private void moveUp(View view) {
        view.setTranslationY(500);

        ViewCompat.animate(view)
                .translationYBy(-500)
                .setDuration(700)
                .start();
    }
}
