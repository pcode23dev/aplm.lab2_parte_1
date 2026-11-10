package ao.co.isptec.aplm.exercise_1;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CICLO_VIDA";

    ArrayList<String> tarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate executado");

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
        Button btnAdd = findViewById(R.id.btnAdd);
        TextView txtTotalTarefa = findViewById(R.id.txtTotalTarefa);

        btnAdd.setOnClickListener(v -> {
            String tarefa = edtTarefa.getText().toString().trim();

            if (tarefa.isEmpty()) {
                Toast.makeText(this, "Digite uma tarefa!", Toast.LENGTH_SHORT).show();
                return;
            }
            tarefas.add(tarefa);
            txtTotalTarefa.setText(String.valueOf(tarefas.size()));
            edtTarefa.setText("");
        });

        btnEnviar.setOnClickListener(v -> {
            if (tarefas.size()==0) {
                Toast.makeText(this, "Digite uma tarefa!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Criar um Intent para abrir a segunda Activity
            Intent intent = new Intent(MainActivity.this, DetalheTarefaActivity.class);
            intent.putStringArrayListExtra("Dados", tarefas);
            // Abrir a segunda Activity
            startActivity(intent);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart executado");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume executado");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause executado");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop executado");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart executado");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy executado");
    }

}