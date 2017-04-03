package th.ac.buapit.buaproid.ui.news;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import th.ac.buapit.buaproid.R;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.VersionViewHolder> {

    Context context;
    OnItemClickListener clickListener;
    private List<NewsModel> itemList;
    Realm mRealm;

    public NewsRecyclerViewAdapter(Context context, List<NewsModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public NewsRecyclerViewAdapter(List<NewsModel> mListNewsModel) {
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_news, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VersionViewHolder versionViewHolder, final int position) {
        versionViewHolder.mTitle.setText(itemList.get(position).getNewsTitle());
        versionViewHolder.mCat.setText(itemList.get(position).getNewsType());

        Glide.with(context)
                .load(itemList.get(position).getNewsImg())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(versionViewHolder.mImage);

        SimpleDateFormat sourceFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat destFormat = new SimpleDateFormat("dd MMM 'พ.ศ' yyyy"); //here 'a' for AM/PM

        Date date = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sourceFormat.parse(itemList.get(position).getNewsModified()));
            cal.add(Calendar.YEAR, 543);
            date = cal.getTime();
//            date = sourceFormat.parse(itemList.get(position).getNewsModified());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String formattedDate = destFormat.format(date);
        versionViewHolder.mDates.setText(formattedDate);

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public void clear() {
        itemList.clear();
        notifyDataSetChanged();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTitle, mDates, mCat;
        ImageView mImage;

        public VersionViewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.tv_news_title);
            mDates = (TextView) itemView.findViewById(R.id.tv_news_date);
            mCat = (TextView) itemView.findViewById(R.id.tv_news_cat);
            mImage = (ImageView) itemView.findViewById(R.id.image_news);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            clickListener.onItemClick(v, position);
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

