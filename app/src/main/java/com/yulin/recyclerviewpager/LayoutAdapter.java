/*
 * Copyright (C) 2014 Lucas Rocha
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yulin.recyclerviewpager;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.SimpleViewHolder> {
    private static final int DEFAULT_ITEM_COUNT = 100;

    private final Context mContext;
    private final RecyclerView mRecyclerView;
    private final List<Integer> mItems;
    private int mCurrentItemId = 0;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTxt;
        public final ImageView mImg;

        public SimpleViewHolder(View view) {
            super(view);
            mTxt = (TextView) view.findViewById(R.id.id_txt);
            mImg = (ImageView) view.findViewById(R.id.id_img);
        }
    }

    public LayoutAdapter(Context context, RecyclerView recyclerView) {
       this(context, recyclerView, DEFAULT_ITEM_COUNT);
    }

    public LayoutAdapter(Context context, RecyclerView recyclerView, int itemCount) {
        mContext = context;
        mItems = new ArrayList<>(itemCount);
        for (int i = 0; i < itemCount; i++) {
            addItem(i);
        }

        mRecyclerView = recyclerView;
    }

    public void addItem(int position) {
        final int id = mCurrentItemId++;
        mItems.add(position, id);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.mTxt.setText("RecyclerViewPager Item:" + position);
                holder.mImg.setImageResource(R.mipmap.vp_1);
                break;
            case 1:
                holder.mTxt.setText("RecyclerViewPager Item:" + position);
                holder.mImg.setImageResource(R.mipmap.vp_2);
                break;
            case 2:
                holder.mTxt.setText("RecyclerViewPager Item:" + position);
                holder.mImg.setImageResource(R.mipmap.vp_3);
                break;
            case 3:
                holder.mTxt.setText("RecyclerViewPager Item:" + position);
                holder.mImg.setImageResource(R.mipmap.vp_4);
                break;
            case 4:
                holder.mTxt.setText("RecyclerViewPager Item:" + position);
                holder.mImg.setImageResource(R.mipmap.vp_5);
                break;
        }

        final View itemView = holder.itemView;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "请赐我一张福", Toast.LENGTH_SHORT).show();
            }
        });
        final int itemId = mItems.get(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
