package th.ac.buapit.buaproid.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import th.ac.buapit.buaproid.R;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView m_title;
    public TextView m_content;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        m_title = (TextView)itemView.findViewById(R.id.x_title);
        m_content = (TextView)itemView.findViewById(R.id.x_content);
    }
    @Override
    public void onClick(View view) {
    }
}
