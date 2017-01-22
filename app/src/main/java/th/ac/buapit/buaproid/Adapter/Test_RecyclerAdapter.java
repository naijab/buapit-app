package th.ac.buapit.buaproid.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import th.ac.buapit.buaproid.Model.TestModel;
import th.ac.buapit.buaproid.R;


public class Test_RecyclerAdapter extends RecyclerView.Adapter<Test_RecyclerAdapter.VersionViewHolder> {

    Context context;
    OnItemClickListener clickListener;
    private List<TestModel> itemList;

    public Test_RecyclerAdapter(Context context, List<TestModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_home, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VersionViewHolder versionViewHolder, final int position) {
        versionViewHolder.m_title.setText(itemList.get(position).getNewsTitle());
        versionViewHolder.m_content.setText(itemList.get(position).getNewsContent());

        Glide.with(context)
                .load(itemList.get(position).getNewsImg())
                .into(versionViewHolder.m_image);

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView m_title;
        TextView m_content;
        ImageView m_image;

        public VersionViewHolder(View itemView) {
            super(itemView);

            m_title = (TextView)itemView.findViewById(R.id.x_title);
            m_content = (TextView)itemView.findViewById(R.id.x_content);
            m_image = (ImageView)itemView.findViewById(R.id.title_img);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v, getPosition());
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}
