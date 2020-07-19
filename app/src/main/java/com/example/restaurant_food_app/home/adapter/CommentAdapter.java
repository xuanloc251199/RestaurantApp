package com.example.restaurant_food_app.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.home.model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    Context mContext;
    List<Comment> mData;

    public CommentAdapter(Context mContext, List<Comment> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_comment,
                parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.mAvataCmt.setImageResource(mData.get(position).getAvtComment());
        holder.mShowNameCmt.setText(mData.get(position).getShowNameCmt());
        holder.mContentCmt.setText(mData.get(position).getContentCmt());
        holder.mTimeCmt.setText(mData.get(position).getTimeCmt());
        holder.mLikeCmt.setText(mData.get(position).getLikeCmt());
        holder.mReplyCmt.setText(mData.get(position).getReplyCmt());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mAvataCmt;
        private TextView mShowNameCmt, mContentCmt, mTimeCmt, mLikeCmt, mReplyCmt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mAvataCmt = itemView.findViewById(R.id.avt_cmt_id);
            mShowNameCmt = itemView.findViewById(R.id.showName_cmt_id);
            mContentCmt = itemView.findViewById(R.id.content_cmt_id);
            mTimeCmt = itemView.findViewById(R.id.time_cmt_id);
            mLikeCmt = itemView.findViewById(R.id.like_cmt_id);
            mReplyCmt = itemView.findViewById(R.id.reply_cmt_id);

        }
    }
}
