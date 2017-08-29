package com.example.tzhiy.doublerecyclerviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tzhiy on 2017/7/16.
 */

public class TeamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements StickyRecyclerHeadersAdapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Category> categories;
    private List<Team> teams;
    public TeamAdapter(Context context, List<Category> categories){
        setCategories(categories);
        this.context = context;


    }

    public void setCategories(List<Category> categories){
        this.categories = categories;
        teams = new ArrayList<>();
        for (Category category : categories) {
            List<Team> teamList = category.getTeams();
           teams.addAll(teamList);
        }

        notifyDataSetChanged();
    }

    public List<Category> getCatagoryList(){
        return categories;
    }

    @Override
    public long getHeaderId(int position) {
        return getSortType(position);
    }

    public int getSortType(int position){
        int sum=0;
        int type=-1;
        for (Category category : categories) {
            if(position>=sum){
                type++;
            }else{
                return type;
            }
            sum+=category.getTeams().size();
        }
        return type;
    }

    @Override
    public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View headerView = LayoutInflater.from(context).inflate(R.layout.header_team_list,parent,false);
        return new HeaderViewHolder(headerView);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
        headerHolder.tvHeader.setText(categories.get(getSortType(position)).getCategoryName());
        holder.itemView.setBackgroundColor(getRandomColor());
    }

    private int getRandomColor() {

        SecureRandom rgen = new SecureRandom();
        return Color.HSVToColor(150, new float[]{
                rgen.nextInt(359), 1, 1
        });
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }


    @Override
    public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(context).inflate(R.layout.item_team,parent,false);
        return new ContentViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Team team = teams.get(position);
        ContentViewHolder conHolder = (ContentViewHolder) holder;
        conHolder.tv.setText(team.getName());
        Glide.with(context).load(team.getImagePath()).into(conHolder.iv);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        private TextView tvHeader;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            tvHeader = (TextView) itemView.findViewById(R.id.tvGoodsItemTitle);
        }
    }

    class ContentViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv;
        private TextView tv;

        public ContentViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.imageview_team);
            tv = (TextView) itemView.findViewById(R.id.textview_teamname);
        }
    }
}
