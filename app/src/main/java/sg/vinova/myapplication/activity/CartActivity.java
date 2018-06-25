package sg.vinova.myapplication.activity;
/* *
 *  Created by JAY on 20/06/2018
 */

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import sg.vinova.myapplication.R;
import sg.vinova.myapplication.adapter.CartAdapter;

public class CartActivity extends AppCompatActivity {

    @BindView(R.id.rvCart)
    RecyclerView rvCart;

    @BindView(R.id.fabDummy)
    FloatingActionButton fabDummy;

    @BindView(R.id.parent)
    View parent;

    CartAdapter cartAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        cartAdapter = new CartAdapter();
        rvCart.setLayoutManager(new GridLayoutManager(this, 2));
        rvCart.setAdapter(cartAdapter);
        parent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                enterReveal();
                parent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    public void onBackPressed() {
        exitReveal();
    }

    public void enterReveal() {
        int x = (int) (fabDummy.getX() + fabDummy.getMeasuredWidth() / 2);
        int y = (int) (fabDummy.getY() + fabDummy.getMeasuredHeight() / 2);

        int finalRadius = Math.max(parent.getWidth(), parent.getHeight());

        ViewAnimationUtils.createCircularReveal(parent, x, y, 0, finalRadius).start();
    }

    public void exitReveal() {
        int x = (int) (fabDummy.getX() + fabDummy.getMeasuredWidth() / 2);
        int y = (int) (fabDummy.getY() + fabDummy.getMeasuredHeight() / 2);
        int startRadius = Math.max(parent.getWidth(), parent.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(parent, x, y, startRadius, fabDummy.getMeasuredWidth() / 2);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                parent.setVisibility(View.INVISIBLE);
                finish();
                overridePendingTransition(0, 0);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.start();

    }
}
