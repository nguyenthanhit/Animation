package sg.vinova.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sg.vinova.myapplication.R;
import sg.vinova.myapplication.adapter.FoodAdapter;
import sg.vinova.myapplication.model.Food;
import sg.vinova.myapplication.util.Constants;

public class MainActivity extends AppCompatActivity implements FoodAdapter.ClickItemListener, FoodAdapter.AvatarListener {

    @BindView(R.id.rvFood)
    RecyclerView rvFood;

    @BindView(R.id.fbCart)
    FloatingActionButton fabCart;

    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        foodAdapter = new FoodAdapter(this, this);
        rvFood.setLayoutManager(new GridLayoutManager(this, 2));
        rvFood.setAdapter(foodAdapter);
    }


    @OnClick(R.id.fbCart)
    public void goToCart() {
        startActivity(new Intent(this, CartActivity.class));
    }

    @Override
    public void onItemClick(ImageView view, Food food) {
        Intent intent = new Intent(this, FoodDetailActivity.class);
        intent.putExtra(Constants.FOOD, food);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view,
                getString(R.string.food_detail_transition));
        startActivity(intent, options.toBundle());
    }

    @Override
    public void onAvatarClick(ImageView view, Food food) {
        Intent intent = new Intent(this, UserDetailActivity.class);
        intent.putExtra(Constants.URL_AVATAR, food.getAvatar());
        intent.putExtra(Constants.USER_NAME, food.getName());

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, view,
                getString(R.string.user_detail_transition));
        startActivity(intent, options.toBundle());
    }
}
