package th.ac.buapit.buaproid.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import th.ac.buapit.buaproid.Model.NewsModel;
import th.ac.buapit.buaproid.R;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.VersionViewHolder> {

    Context context;
    OnItemClickListener clickListener;
    private List<NewsModel> itemList;

    public NewsRecyclerViewAdapter(Context context, List<NewsModel> itemList) {
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
//        versionViewHolder.m_content.setText(itemList.get(position).getNewsContent());

        Glide.with(context)
                .load(itemList.get(position).getNewsImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(versionViewHolder.m_image);

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void clear(){
        itemList.clear();
        notifyDataSetChanged();
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

//    public void clear() {
//        itemList.clear();
//        notifyDataSetChanged();
//    }
//
//    // Add a list of items
//    public void addAll(List<TestModel> list) {
//        itemList.addAll(list);
//        notifyDataSetChanged();
//    }
}
