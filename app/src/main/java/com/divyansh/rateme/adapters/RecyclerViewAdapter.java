package com.divyansh.rateme.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.divyansh.rateme.R;
import com.divyansh.rateme.data.Rating;

import java.time.LocalDateTime;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<Rating> ratingList;

    public RecyclerViewAdapter(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Rating rating = ratingList.get(position);
        holder.postedOn.setText("Posted on - " + rating.getDate().toString());
        holder.name.setText("Name Of the Rating - " + rating.getName());
        holder.rating.setText("Rating Description - " + rating.getRating());
    }

    @Override
    public int getItemCount() {
        if (ratingList.size() == 0) return 0;
        return ratingList.size();
    }

    public void addRatings(List<Rating> ratingList) {
        this.ratingList = ratingList;
        notifyDataSetChanged();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.publish_date)
        TextView postedOn;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.rating)
        TextView rating;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
