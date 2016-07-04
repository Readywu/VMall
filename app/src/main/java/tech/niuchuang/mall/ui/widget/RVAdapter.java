package tech.niuchuang.mall.ui.widget;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.niuchuang.mall.R;
import tech.niuchuang.mall.entity.Person;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    List<Person> persons;

    public RVAdapter(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personName.setText(persons.get(i).getFirstName());
        personViewHolder.personAge.setText(persons.get(i).getLastName());
        personViewHolder.personPhoto.setImageResource(persons.get(i).getIconResId());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return this.persons.size();

    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_text_view, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.cv)
        CardView cv;
        @BindView(R.id.person_name)
        TextView personName;
        @BindView(R.id.person_age)
        TextView personAge;
        @BindView(R.id.person_photo)
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}