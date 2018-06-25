package sg.vinova.myapplication.adapter;
/* *
 *  Created by JAY on 21/06/2018
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sg.vinova.myapplication.R;
import sg.vinova.myapplication.model.Food;
import sg.vinova.myapplication.model.Review;
import sg.vinova.myapplication.util.Util;

public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int HEADER = 1;
    private final int COMMENT = 2;

    private Food food;
    private List<Review> reviews;

    public DetailAdapter(Food food) {
        this.food = food;
        this.reviews = Util.reviews();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == HEADER)
            return new HeaderViewHolder(initView(parent, R.layout.item_header_layout));
        return new CommentViewHolder(initView(parent, R.layout.item_comment_layout));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).bind(food);
        } else
            ((CommentViewHolder) holder).bind(reviews.get(position));
    }

    @Override
    public int getItemCount() {
        return reviews.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return HEADER;
        return COMMENT;
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvUserName)
        TextView tvUserName;

        @BindView(R.id.tvStarNumber)
        TextView tvRating;

        @BindView(R.id.tvLikeNumber)
        TextView tvLikeNumber;

        @BindView(R.id.tvBuyNumber)
        TextView tvBuyNumber;

        HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Food food) {
            tvUserName.setText(food.getName());
            tvLikeNumber.setText(String.valueOf(food.getLikeNumber()));
            tvRating.setText(String.valueOf(food.getRating()));
            tvBuyNumber.setText(String.valueOf(food.getBuyNumber()));
        }
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvDate)
        TextView tvDate;

        @BindView(R.id.ivAvatar)
        ImageView ivAvatar;

        @BindView(R.id.tvComment)
        TextView tvComment;

        public CommentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(Review review) {
            Util.loadImage(review.getAvatar(), ivAvatar);
            tvDate.setText(review.getDate());
            tvComment.setText(review.getComment());
        }
    }

    private View initView(ViewGroup parent, int layoutId) {
        return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }
}
