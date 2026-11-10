package ao.co.isptec.aplm.exercise_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> {

    private ArrayList<String> tarefas;

    public TarefaAdapter(ArrayList<String> tarefas) {
        this.tarefas = tarefas;
    }

    public static class TarefaViewHolder extends RecyclerView.ViewHolder {

        TextView txtTarefa;

        public TarefaViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTarefa = itemView.findViewById(R.id.txtTarefa);
        }
    }

    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tarefa, parent, false);

        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        String tarefa = tarefas.get(position);

        holder.txtTarefa.setText(tarefa);
    }

    @Override
    public int getItemCount() {
        return tarefas.size();
    }
}