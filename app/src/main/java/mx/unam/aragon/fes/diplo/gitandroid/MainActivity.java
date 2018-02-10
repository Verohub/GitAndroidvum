package mx.unam.aragon.fes.diplo.gitandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button miBoton,miSegBoton;
private TextView miVista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBoton=findViewById(R.id.button);
        miSegBoton=findViewById(R.id.button2);
        miVista = findViewById(R.id.textView);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miVista.setText("Hola GitHub");
            }
        });
        miSegBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miVista.setText("Diplomado Android");
            }
        });


    }
}
