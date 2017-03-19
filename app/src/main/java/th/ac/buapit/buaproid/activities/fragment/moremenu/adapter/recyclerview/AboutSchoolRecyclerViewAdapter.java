package th.ac.buapit.buaproid.activities.fragment.moremenu.adapter.recyclerview;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.AboutSchoolModel;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.PersonModel;


public class AboutSchoolRecyclerViewAdapter extends RecyclerView.Adapter<AboutSchoolRecyclerViewAdapter.VersionViewHolder> {

    Context context;
    OnItemClickListener clickListener;
    private List<AboutSchoolModel> itemList;

    public AboutSchoolRecyclerViewAdapter(Context context, List<AboutSchoolModel> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    public AboutSchoolRecyclerViewAdapter(List<AboutSchoolModel> mListAboutSchoolModel) {
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_about_school, viewGroup, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final VersionViewHolder versionViewHolder, final int position) {
        versionViewHolder.c_title.setText(itemList.get(position).getNameSchool());
        versionViewHolder.c_position.setText(itemList.get(position).getHistorySchool());

        Glide.with(context)
                .load(itemList.get(position).getLogoSchool())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(versionViewHolder.c_image);
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
        TextView c_title, c_position;
        ImageView c_image;

        public VersionViewHolder(View itemView) {
            super(itemView);

            c_title = (TextView) itemView.findViewById(R.id.a_title);
            c_position = (TextView) itemView.findViewById(R.id.a_history);
            c_image = (ImageView) itemView.findViewById(R.id.a_logo);

//            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
//            clickListener.onItemClick(v, position);
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

