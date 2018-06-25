package sg.vinova.myapplication.adapter;
/* *
 *  Created by JAY on 20/06/2018
 */

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sg.vinova.myapplication.R;
import sg.vinova.myapplication.model.Food;
import sg.vinova.myapplication.util.Util;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Food> foods;
    private ClickItemListener itemListener;
    private AvatarListener avatarListener;

    public FoodAdapter(ClickItemListener listener, AvatarListener avatarListener) {
        foods = Util.foods();
        this.itemListener = listener;
        this.avatarListener = avatarListener;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, null));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        holder.bind(foods.get(position));

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivAvatar)
        ImageView ivAvatar;

        @BindView(R.id.ivFoodCover)
        ImageView ivFoodCover;

        @BindView(R.id.tvName)
        TextView tvName;

        @BindView(R.id.rbRating)
        RatingBar rbRating;

        Food food;

        FoodViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(v -> itemListener.onItemClick(ivFoodCover, food));
            ivAvatar.setOnClickListener(v -> avatarListener.onAvatarClick(ivAvatar, food));
        }

        void bind(Food food) {
            this.food = food;
            tvName.setText(food.getName());
            rbRating.setRating(food.getRating());
            Util.loadImage(food.getCover(), ivFoodCover);
            Util.loadImage(food.getAvatar(), ivAvatar);
        }

    }

    public interface ClickItemListener {
        void onItemClick(ImageView view, Food food);
    }

    public interface AvatarListener {
        void onAvatarClick(ImageView view, Food food);
    }
}
