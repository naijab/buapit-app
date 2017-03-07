package th.ac.buapit.buaproid.Adapter.Realm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import io.realm.Realm;
import io.realm.RealmResults;
import th.ac.buapit.buaproid.Model.RealmObject.NewsRealmModel;
import th.ac.buapit.buaproid.R;


public class NewsRealmRecyclerViewAdapter extends RecyclerView.Adapter<NewsRealmRecyclerViewAdapter.VersionViewHolder> {

    Context context;
    OnItemClickListener clickListener;
    private Realm mRealm;
    private RealmResults<NewsRealmModel> mResults;

    public NewsRealmRecyclerViewAdapter(Context context, Realm realm, RealmResults<NewsRealmModel> results) {
        this.mRealm = realm;
        this.setResults(results);
        this.context = context;
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_fav, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VersionViewHolder versionViewHolder, final int position) {
        versionViewHolder.c_title.setText(mResults.get(position).getRealmNewsTitle());

        Glide.with(context)
                .load(mResults.get(position).getRealmNewsImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(versionViewHolder.c_image);
//        versionViewHolder.m_content.setText(itemList.get(position).getNewsContent());

    }

    public void setResults(RealmResults<NewsRealmModel> results) {
        this.mResults = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.mResults.size();
    }

    public void clear() {
        mResults.clear();
        notifyDataSetChanged();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView c_title;
        TextView c_content;
        ImageView c_image;

        public VersionViewHolder(View itemView) {
            super(itemView);

            c_title = (TextView) itemView.findViewById(R.id.title_recyclerview_fav);
//            c_content = (TextView) itemView.findViewById(R.id.c_content);
            c_image = (ImageView) itemView.findViewById(R.id.image_recyclerview_fav);

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

