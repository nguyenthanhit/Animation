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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sg.vinova.myapplication.R;
import sg.vinova.myapplication.model.Food;
import sg.vinova.myapplication.util.Util;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {
    List<Food> foods;

    public CartAdapter() {
        foods = Util.foods();
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart_layout, null));
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.bind(foods.get(position));
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivFood)
        ImageView ivFood;

        CartViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Food food) {
            Util.loadImage(food.getCover(), ivFood);
        }
    }
}
