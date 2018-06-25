package sg.vinova.myapplication.activity;
/* *
 *  Created by JAY on 21/06/2018
 */

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sg.vinova.myapplication.R;

public class DemoActivity extends AppCompatActivity {

    @BindView(R.id.btnMove)
    Button btnMove;

    @BindView(R.id.ivAndroid)
    ImageView ivAndroid;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        // value animator
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 500f);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(animator -> {
            float value = (float) animator.getAnimatedValue();
            ivAndroid.setTranslationY(value);
        });

        // set in code

        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(ivAndroid, "translationX", 0f, 500f);
        objectAnimatorX.setDuration(300);


        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(ivAndroid, "translationY", 0f, 500f);
        objectAnimatorY.setDuration(300);


        ObjectAnimator fade = ObjectAnimator.ofFloat(ivAndroid, "alpha", 1f, 0f);
        fade.setDuration(300);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorX, objectAnimatorY);
        animatorSet.play(fade).after(300);

        // set in xml
        ObjectAnimator animatorXML = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.object_animator);
        animatorXML.setTarget(ivAndroid);


        btnMove.setOnClickListener(view -> {
                   // objectAnimatorX.start();
                  //    animatorSet.start();
                    //     animatorXML.start();
                    //    valueAnimator.start();
                    //    objectAnimator.start()
                    //    animate set
//                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_anim);
//                    ivAndroid.startAnimation(anim);
                }
        );
    }
}
