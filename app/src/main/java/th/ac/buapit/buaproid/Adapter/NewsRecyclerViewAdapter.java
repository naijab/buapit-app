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
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

    public NewsRecyclerViewAdapter(List<NewsModel> mListNewsModel) {
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_home, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VersionViewHolder versionViewHolder, final int position) {
        versionViewHolder.mTitle.setText(itemList.get(position).getNewsTitle());
//        versionViewHolder.mDates.setText(itemList.get(position).getNewsModified());
//        versionViewHolder.m_content.setText(itemList.get(position).getNewsContent());

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

        versionViewHolder.mLove.setOnLikeListener(new OnLikeListener() {
                @Override
                public void liked(LikeButton likeButton) {
//                    Toast toastF = Toast.makeText ("Like True"
//                            + itemList.get(position).getNewsModified(), Toast.LENGTH_SHORT );
//                    toastF.show ();
                    int likenum = 0;
                    int sum = 0;
                    sum = likenum + 1;
                    versionViewHolder.mLikeNum.setText(String.valueOf(sum));
                    versionViewHolder.mLove.setLiked(true);
                }

                @Override
                public void unLiked(LikeButton likeButton) {

                    int likenum = 1;
                    int sum = 0;
                    sum = likenum - 1;
                    versionViewHolder.mLikeNum.setText(String.valueOf(sum));

                    versionViewHolder.mLove.setLiked(false);
                }
            });


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
        TextView mTitle;
        TextView mDates;
        TextView mLikeNum;
        ImageView mImage;
        LikeButton mLove;

        public VersionViewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.x_title);
            mDates = (TextView) itemView.findViewById(R.id.x_date);
            mImage = (ImageView) itemView.findViewById(R.id.title_img);
            mLove = (LikeButton) itemView.findViewById(R.id.love_button_item_recyclerview_home);
            mLikeNum = (TextView) itemView.findViewById(R.id.num_love_button_item_recyclerview_home);

            itemView.setOnClickListener(this);
//            mLove.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            clickListener.onItemClick(v, position);

//            mLove.setOnLikeListener(new OnLikeListener() {
//                @Override
//                public void liked(LikeButton likeButton) {
//                    Toast toastF = Toast.makeText (getActivity(), "Like True"
//                            + mNewModel.get(position).getNewsImg(), Toast.LENGTH_SHORT );
//                    toastF.show ();
//                    mLove.setLiked(true);
//                }
//
//                @Override
//                public void unLiked(LikeButton likeButton) {
//                    Toast toastF = Toast.makeText (getActivity(), "Like False", Toast.LENGTH_SHORT );
//                    toastF.show ();
//                    mLove.setLiked(false);
//                }
//            });

        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

