package android.example.alarm2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Alarm_adapter extends RecyclerView.Adapter<Alarm_adapter.AlarmViewHolder> {
    private List<Alarm_item> alarm_items;

    @NonNull
    @Override
    public AlarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlarmViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.alarm_list,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AlarmViewHolder holder, int position) {
        holder.time.setText(alarm_items.get(position).getTime());
        holder.date.setText(alarm_items.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return alarm_items.size();
    }

    Alarm_adapter(List<Alarm_item> alarm_items) {
        this.alarm_items = alarm_items;
    }

    class AlarmViewHolder extends RecyclerView.ViewHolder{
        private TextView time, date;

        public AlarmViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            date = itemView.findViewById(R.id.date);

        }
    }
}
