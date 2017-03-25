package th.ac.buapit.buaproid.activities.fragment.moremenu.adapter.recyclerview;

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

import th.ac.buapit.buaproid.R;
import th.ac.buapit.buaproid.activities.fragment.moremenu.model.AboutSchoolModel;


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
        versionViewHolder.c_history.setText(itemList.get(position).getHistorySchool());
        versionViewHolder.c_under.setText(itemList.get(position).getUnderSchool());
        versionViewHolder.c_director.setText(itemList.get(position).getDirectSchool());
        versionViewHolder.c_total_student.setText(itemList.get(position).getTotalSchool());
        versionViewHolder.c_total_teacher.setText(itemList.get(position).getTotal1School());
        versionViewHolder.c_subject.setText(itemList.get(position).getSubjectSchool());

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
        TextView c_title, c_history, c_under, c_director, c_total_student, c_total_teacher, c_subject;
        ImageView c_image;

        public VersionViewHolder(View itemView) {
            super(itemView);

            c_title = (TextView) itemView.findViewById(R.id.tv_about_school_title);
            c_history = (TextView) itemView.findViewById(R.id.tv_about_school_history);
            c_under = (TextView) itemView.findViewById(R.id.tv_about_school_under);
            c_director = (TextView) itemView.findViewById(R.id.tv_about_school_director);
            c_total_student = (TextView) itemView.findViewById(R.id.tv_about_school_total_student);
            c_total_teacher = (TextView) itemView.findViewById(R.id.tv_about_school_total_teacher);
            c_subject = (TextView) itemView.findViewById(R.id.tv_about_school_subject);
            c_image = (ImageView) itemView.findViewById(R.id.iv_school_logo);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
        }
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
}

