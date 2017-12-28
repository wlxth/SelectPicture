package com.cui.mrr.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by szares on 2017/11/3.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {
    public void setItemclickListener(ClickListener itemclickListener) {
        ItemclickListener = itemclickListener;
    }

    public void setLongClickListener(ClickListener longClickListener) {
        LongClickListener = longClickListener;
    }

    private ClickListener ItemclickListener;

    private ClickListener LongClickListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            ItemclickListener.onLongClick(getAdapterPosition(), view);
        }

        @Override
        public boolean onLongClick(View view) {
            LongClickListener.onLongClick(getAdapterPosition(), view);
            return true;
        }
    }

    public interface ClickListener {
        void onItemClick(int position, View v);

        void onLongClick(int position, View v);
    }
}
