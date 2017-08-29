package com.example.tzhiy.doublerecyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by tzhiy on 2017/7/16.
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Category> categories;
    public CategoryAdapter(Context context, List<Category> categories){
        this.context = context;
        this.categories=categories;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View categoryView = View.inflate(context,R.layout.item_category,null);

        return new CategoryViewHolder(categoryView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Category category = categories.get(position);
        String categoryName = category.getCategoryName();
        boolean isSelected = category.isSelected();
        CategoryViewHolder categoryViewHolder = ((CategoryViewHolder)holder);

        if(isSelected){
            categoryViewHolder.tv.setSelected(true);
        }else{
            categoryViewHolder.tv.setSelected(false);
        }

       categoryViewHolder.tv.setText(categoryName);

        ((CategoryViewHolder) holder).tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=onCategoryItemClickListener){
                    onCategoryItemClickListener.onCategoryItemClick(v,position);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView tv;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tv= (TextView) itemView.findViewById(R.id.textview_categoryname);
        }
    }
    private OnCategoryItemClickListener onCategoryItemClickListener;
    public interface OnCategoryItemClickListener{
        void onCategoryItemClick(View v, int position);
    }

    public void setOnCategoryItemClickListener(OnCategoryItemClickListener onCategoryItemClickListener){
        this.onCategoryItemClickListener = onCategoryItemClickListener;
    }
}
