package com.example.brom.listviewjsonapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by a17johpe on 2018-04-30.
 */

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.ViewHolder>{
    public List<Mountain> mDataset;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Mountain item);
    }

    private final OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public TextView mTextView2;
        public TextView mTextView3;
        public ViewHolder(View v) {
            super(v);
            mTextView = v.findViewById(R.id.text1);
            mTextView2 = v.findViewById(R.id.text4);
            mTextView3 = v.findViewById(R.id.text3);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MountainAdapter(List<Mountain> myDataset, OnItemClickListener inListener) {
        mDataset = myDataset;
        listener = inListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MountainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(mDataset.get(position).toString());
        holder.mTextView2.setText(mDataset.get(position).locationInfo());
        holder.mTextView3.setText(mDataset.get(position).heightInfo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(mDataset.get(position));
            }
        });
    }
    public void add(Mountain m) {
        mDataset.add(m);
    }


    public void clear () {
        mDataset.clear();
        //notifyItemChanged()
    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }




}
