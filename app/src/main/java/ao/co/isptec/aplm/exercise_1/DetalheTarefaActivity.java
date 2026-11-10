package ao.co.isptec.aplm.exercise_1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetalheTarefaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_tarefa);

        // 1. Recuperar as tarefas enviadas pela MainActivity
        ArrayList<String> tarefas = getIntent()
                .getStringArrayListExtra("Dados");

        // 2. Encontrar o RecyclerView no XML
        RecyclerView rvTarefas = findViewById(R.id.rvTarefas);

        // 3. Definir a organização da lista
        rvTarefas.setLayoutManager(new LinearLayoutManager(this));

        // 4. Criar o Adapter e fornecer os dados
        TarefaAdapter adapter = new TarefaAdapter(tarefas);

        // 5. Associar o Adapter ao RecyclerView
        rvTarefas.setAdapter(adapter);
    }
}