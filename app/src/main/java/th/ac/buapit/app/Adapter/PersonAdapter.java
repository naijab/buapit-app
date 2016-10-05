package th.ac.buapit.app.Adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import th.ac.buapit.app.Model.Person;
import th.ac.buapit.app.R;


public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Person> data= Collections.emptyList();
    Person current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public PersonAdapter(Context context, List<Person> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.card_row_person, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        Person current = data.get(position);
        myHolder.TxName.setText(current.personName);
        myHolder.TxPosi.setText(current.personPosition);
        myHolder.TxFact.setText(current.personFaction);
        //myHolder.TxTel.setText(current.personTel);

    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView TxName;
        TextView TxPosi;
        TextView TxFact;
        TextView TxTel;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            TxName = (TextView) itemView.findViewById(R.id.tv_person_name);
            TxPosi = (TextView) itemView.findViewById(R.id.tv_person_posi);
            TxFact = (TextView) itemView.findViewById(R.id.tv_person_fac);
            //TxTel = (TextView) itemView.findViewById(R.id.textPrice);
        }

    }


}
