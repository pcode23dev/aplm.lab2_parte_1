package ao.co.isptec.aplm.exercise_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DetalheTarefaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhe_tarefa);

        TextView textView = findViewById(R.id.txtTarefaRecebida);

        ArrayList<String> dados = getIntent().getStringArrayListExtra("Dados");
        StringBuilder listaFormatada = new StringBuilder();

        if (dados != null && !dados.isEmpty()) {
            for (int i = 0; i < dados.size(); i++) {

                listaFormatada.append(i + 1)
                        .append(". ")
                        .append(dados.get(i))
                        .append("\n");

            }

            textView.setText(listaFormatada.toString());
        } else {
            Toast.makeText(this, "Nenhuma tarefa encontrada.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DetalheTarefaActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }
}