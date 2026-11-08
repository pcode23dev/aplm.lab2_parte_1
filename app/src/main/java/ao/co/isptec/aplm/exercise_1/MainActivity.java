package ao.co.isptec.aplm.exercise_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> tarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 1. Referenciar os componentes do XML
        EditText edtTarefa = findViewById(R.id.edtTarefa);
        Button btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(v -> {
            String tarefa = edtTarefa.getText().toString().trim();

            if (tarefa.isEmpty()) {
                Toast.makeText(this, "Digite uma tarefa!", Toast.LENGTH_SHORT).show();
                return;
            }

            tarefas.add(tarefa);
            edtTarefa.setText("");

            // Criar um Intent para abrir a segunda Activity
            Intent intent = new Intent(MainActivity.this, DetalheTarefaActivity.class);

            intent.putStringArrayListExtra("Dados", tarefas);

            // Abrir a segunda Activity
            startActivity(intent);
        });

    }

}