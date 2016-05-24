package com.krystianklimek.flowerapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.krystianklimek.flowerapp.R;
import com.krystianklimek.flowerapp.helper.Constants;
import com.krystianklimek.flowerapp.model.Flower;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by: Krystian Klimek
 * Date: 23.05.2016.
 */

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {


    private final FlowerClickListener mListener;
    private List<Flower> mFlowers;

    public FlowerAdapter(FlowerClickListener listener) {
        this.mFlowers = new ArrayList<>();
        this.mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Flower currentFlower = mFlowers.get(position);

        holder.nameTextView.setText(currentFlower.getName());
        holder.priceTextView.setText(String.valueOf(currentFlower.getPrice()) + "€");

        Picasso
                .with(holder.itemView.getContext())
                .load(Constants.HTTP.PHOTO_URL + currentFlower.getPhoto())
                .into(holder.photoImageView);
    }

    @Override
    public int getItemCount() {
        return mFlowers.size();
    }

    public void addFlower(Flower flower) {
        mFlowers.add(flower);
        notifyDataSetChanged();
    }

    public Flower getSelectedFlower(int position) {
        return mFlowers.get(position);
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.photoImageView)
        ImageView photoImageView;
        @BindView(R.id.nameTextView)
        TextView nameTextView;
        @BindView(R.id.priceTextView)
        TextView priceTextView;

        Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getLayoutPosition());
        }
    }

    public interface FlowerClickListener {
        void onClick (int position);
    }
}
