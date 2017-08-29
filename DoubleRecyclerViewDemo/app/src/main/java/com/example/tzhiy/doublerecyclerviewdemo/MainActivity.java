package com.example.tzhiy.doublerecyclerviewdemo;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.OnCategoryItemClickListener {
    private RecyclerView rightRecyclerView;
    private RecyclerView leftRecyclerView;
    private LinearLayoutManager rightLayoutManager;
    private LinearLayoutManager leftLayoutManager;
    private CategoryAdapter categoryAdapter;
    private TeamAdapter teamAdapter;

    private List<Category> categoryList;
    private int lastSelectedCategory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

    }

    private void initData() {
        categoryList = new ArrayList<>();
        List<Team> teamList1 = new ArrayList<>();
        teamList1.add(new Team("多特蒙德","http://img1.imgtn.bdimg.com/it/u=1400488354,545185599&fm=21&gp=0.jpg"));
        teamList1.add(new Team("拜仁慕尼黑","http://img5.imgtn.bdimg.com/it/u=1016826229,3053766616&fm=21&gp=0.jpg"));
        teamList1.add(new Team("沃尔夫斯堡","http://img2.imgtn.bdimg.com/it/u=1102871345,1624426389&fm=15&gp=0.jpg"));
        teamList1.add(new Team("门兴","http://c.hiphotos.baidu.com/baike/c0%3Dbaike80%2C5%2C5%2C80%2C26/sign=5d24504035fae6cd18b9a3336eda6441/eaf81a4c510fd9f91d25e41e252dd42a2834a493.jpg"));
        Category c1 = new Category("德甲",teamList1);
        c1.setSelected(true);

        List<Team> teamList2 = new ArrayList<>();
        teamList2.add(new Team("巴塞罗那","http://www.sinaimg.cn/lf/sports/logo85/130.png"));
        teamList2.add(new Team("皇家马德里","http://www.sinaimg.cn/lf/sports/logo85/157.png"));
        teamList2.add(new Team("马德里竞技","http://www.sinaimg.cn/lf/sports/logo85/162.png"));
        Category c2 = new Category("西甲",teamList2);

        List<Team> teamList3 = new ArrayList<>();
        teamList3.add(new Team("尤文图斯","http://www.sinaimg.cn/lf/sports/logo85/108.png"));
        teamList3.add(new Team("国际米兰","http://www.sinaimg.cn/lf/sports/logo85/103.png"));
        teamList3.add(new Team("AC米兰","http://www.sinaimg.cn/lf/sports/logo85/104.png"));
        teamList3.add(new Team("罗马","http://www.sinaimg.cn/lf/sports/logo85/111.png"));
        Category c3 = new Category("意甲",teamList3);

        List<Team> teamList4 = new ArrayList<>();
        teamList4.add(new Team("曼联","http://www.sinaimg.cn/lf/sports/logo85/52.png"));
        teamList4.add(new Team("曼城","http://www.sinaimg.cn/lf/sports/logo85/216.png"));
        teamList4.add(new Team("切尔西","http://www.sinaimg.cn/lf/sports/logo85/60.png"));
        teamList4.add(new Team("阿森纳","http://www.sinaimg.cn/lf/sports/logo85/61.png"));
        teamList4.add(new Team("莱斯特成","http://www.sinaimg.cn/lf/sports/logo85/92.png"));
        Category c4 = new Category("英超",teamList4);

        List<Team> teamList5 = new ArrayList<>();
        teamList5.add(new Team("北京国安","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127115830.png"));
        teamList5.add(new Team("广州恒大","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127124548.png"));
        teamList5.add(new Team("山东鲁能","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127115709.png"));
        teamList5.add(new Team("江苏苏宁","http://www.sinaimg.cn/ty/2016/0108/U6521P6DT20160108153302.png"));
        teamList5.add(new Team("上海上港","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127122231.png"));
        Category c5 = new Category("中超",teamList5);


        categoryList.add(c1);
        categoryList.add(c2);
        categoryList.add(c3);
        categoryList.add(c4);
        categoryList.add(c5);
        for (int i=0;i<10;i++){
            List<Team> teamList = new ArrayList<>();
            teamList.add(new Team("北京国安","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127115830.png"));
            teamList.add(new Team("广州恒大","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127124548.png"));
            teamList.add(new Team("山东鲁能","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127115709.png"));
            teamList.add(new Team("江苏苏宁","http://www.sinaimg.cn/ty/2016/0108/U6521P6DT20160108153302.png"));
            teamList.add(new Team("上海上港","http://www.sinaimg.cn/ty/2015/0127/U6521P6DT20150127122231.png"));
            Category c = new Category("中超",teamList);
            categoryList.add(c);
        }
    }

    private void initView() {
        rightRecyclerView = (RecyclerView) findViewById(R.id.right_recycler);
        leftRecyclerView = (RecyclerView) findViewById(R.id.left_recycler);
        leftLayoutManager = new LinearLayoutManager(this);
        rightLayoutManager = new LinearLayoutManager(this);
        rightRecyclerView.setLayoutManager(rightLayoutManager);
        leftRecyclerView.setLayoutManager(leftLayoutManager);

        categoryAdapter = new CategoryAdapter(this,categoryList);
        teamAdapter = new TeamAdapter(this,categoryList);

        rightRecyclerView.setAdapter(teamAdapter);
        leftRecyclerView.setAdapter(categoryAdapter);

        categoryAdapter.setOnCategoryItemClickListener(this);

        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(teamAdapter);
        rightRecyclerView.addItemDecoration(headersDecor);

        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.M){
            rightRecyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    int firstVisibleItem = rightLayoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItem = rightLayoutManager.findLastVisibleItemPosition();
                    if(lastVisibleItem!=rightLayoutManager.getItemCount()-1){
                        int sortType = teamAdapter.getSortType(firstVisibleItem);
                        changeSelected(sortType);
                    }else{
                        changeSelected(categoryAdapter.getItemCount()-1);
                    }
                    if(needMove){
                        needMove=false;
                        int i = movePosition - rightLayoutManager.findFirstVisibleItemPosition();
                        if(i>=0&&i<rightRecyclerView.getChildCount()){
                            int top = rightRecyclerView.getChildAt(i).getTop();
                            rightRecyclerView.scrollBy(0,top-dip2px(MainActivity.this,28));
                        }
                    }
                }
            });
        }else{
            rightRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    int firstVisibleItem = rightLayoutManager.findFirstVisibleItemPosition();
                    int lastVisibleItem = rightLayoutManager.findLastVisibleItemPosition();
                    if(lastVisibleItem!=rightLayoutManager.getItemCount()-1){
                        int sortType = teamAdapter.getSortType(firstVisibleItem);
                        changeSelected(sortType);
                    }else{
                        changeSelected(categoryAdapter.getItemCount()-1);
                    }
                    if(needMove){
                        needMove=false;
                        int i = movePosition - rightLayoutManager.findFirstVisibleItemPosition();
                        if(i>=0&&i<=rightRecyclerView.getChildCount()-1){
                            int top = rightRecyclerView.getChildAt(i).getTop();
                            rightRecyclerView.smoothScrollBy(0,top-dip2px(MainActivity.this,28));
                        }
                    }
                }
            });
        }



    }



    /**
     * 左侧菜单栏点击事件
     */

    @Override
    public void onCategoryItemClick(View v, int position) {

        changeSelected(position);
        moveToFirstPosition(position);
    }


    private int movePosition;
    private boolean needMove;

    private void moveToFirstPosition(int position) {
        movePosition=0;
        for (int i = 0; i < position; i++) {
            movePosition+=teamAdapter.getCatagoryList().get(i).getTeams().size();
        }

        moveToPosition(movePosition);
    }

    private void moveToPosition(int position) {
        int firstVisibleItem = rightLayoutManager.findFirstVisibleItemPosition();
        int lastVisibleItem = rightLayoutManager.findLastVisibleItemPosition();
        if(movePosition<=firstVisibleItem){
            rightRecyclerView.scrollToPosition(position);
        }else if(movePosition<=lastVisibleItem){
            int top = rightRecyclerView.getChildAt(position - firstVisibleItem).getTop();
            rightRecyclerView.scrollBy(0,top-dip2px(MainActivity.this,28));
        }else{
            rightRecyclerView.scrollToPosition(position);
            movePosition=position;
            needMove=true;
        }
    }

    /**
     * 左侧菜单点击切换
     * @param position
     */

    private void changeSelected(int position) {
        if(position==lastSelectedCategory){
            return;
        }else{
            Category category = categoryList.get(position);
            category.setSelected(true);
            categoryList.get(lastSelectedCategory).setSelected(false);
            Toast.makeText(this, "点击的是"+position+"/"+category.getCategoryName(), Toast.LENGTH_SHORT).show();
            leftRecyclerView.scrollToPosition(position);
        }

        lastSelectedCategory =position;
        categoryAdapter.notifyDataSetChanged();
    }

    public int dip2px(Context context,float dp){
        float density = getResources().getDisplayMetrics().density;
        return (int) (dp*density+0.5f);
    }

}
