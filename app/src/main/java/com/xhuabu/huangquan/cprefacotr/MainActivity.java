package com.xhuabu.huangquan.cprefacotr;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.xhuabu.huangquan.lib_ui.adapter.RvAdapter;
import com.xhuabu.huangquan.lib_ui.holder.BannerHolder;
import com.xhuabu.huangquan.lib_ui.util.ToastUtils;
import com.xhuabu.huangquan.lib_ui.view.DividerItemDecoration;
import com.xhuabu.huangquan.lib_utils.LOG;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testRecyclerView(this);

    }

    private void testRecyclerView(final Context context) {
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL, true));

        List<Bean> datas = new ArrayList<Bean>();
        for(int i = 0 ; i<30;i++) {
            Bean bean = new Bean("name = " + i, i + 100);
            datas.add(bean);
        }


        RvAdapter<Bean> adapter = new RvAdapter<Bean>(this,datas,R.layout.item_rv) {

            @Override
            public void initEvent(ViewHolder holder, Bean object) {

                holder.setClickEvent(R.id.name, new ViewHolder.OnClickEvent<Bean>() {
                    @Override
                    public void onClick(View v, Bean object) {
                        ToastUtils.show(context, object.name);
                    }
                });
                holder.setClickEvent(R.id.age, new ViewHolder.OnClickEvent<Bean>() {
                    @Override
                    public void onClick(View v, Bean object) {
                        ToastUtils.show(context, object.age+"");
                    }
                });
            }

            @Override
            public void bindData(ViewHolder holder, Bean object) {

                holder.bindText(R.id.name,object.name);
                holder.bindText(R.id.age, object.age+"");
            }
        };

        adapter.setOnItemClick(new RvAdapter.OnItemOnClick() {
            @Override
            public void onClick(View itemView, int position) {
                ToastUtils.show(context, "pos = " + position);
            }
        });
        recyclerView.setAdapter(adapter);

        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, -2);
        addContentView(recyclerView ,params);

    }

    public void testBanner() {
        final BannerHolder holder = new BannerHolder(this);

        String[] data = {"http://bpic.588ku.com/element_origin_min_pic/00/00/00/005695020616b43.jpg","http://bpic.588ku.com/element_origin_min_pic/16/07/12/165784a7855b0a3.jpg","http://bpic.588ku.com/element_origin_min_pic/00/16/04/15571065a19acde.jpg"};
        holder.refreshHolderView(data);

        String[] titles = {"t1", "t2", "t3"};
        String[] links = {"k1", "k2", "k3"};

        holder.setLinkDataWithActivity(links,titles,JumpActivity.class);


        BannerHolder.OnItemClickListener listener = new BannerHolder.OnItemClickListener() {
            @Override
            public boolean OnItemClick(String title, String link) {

                LOG.v(TAG, "link====" + link + ",title=====" + title);
                return true;
            }
        };
        holder.setLinkDataWithListener(links,titles,listener);


        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, -2);
        addContentView(holder.getHolderView(),params);

/*        holder.getHolderView().postDelayed(new Runnable() {
            @Override
            public void run() {
                holder.setDotId(R.drawable.ic_dot_selected, R.drawable.ic_dot);
            }
        }, 6000);*/
    }
}
