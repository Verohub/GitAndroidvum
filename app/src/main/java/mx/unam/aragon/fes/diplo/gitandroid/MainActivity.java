package mx.unam.aragon.fes.diplo.gitandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
private Button miBoton,miSegBoton,miTerBoton;
private Bitmap imgdescarga;
private ImageView miimagen;
private TextView miVista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miBoton=findViewById(R.id.button);
        miSegBoton=findViewById(R.id.button2);
        miVista = findViewById(R.id.textView);
        miTerBoton = findViewById(R.id.button3);
        miimagen=findViewById(R.id.imageView2);


        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miVista.setText("Hola GitHub");
                Toast.makeText(MainActivity.this,"Se cambio el mensaje del textView", Toast.LENGTH_SHORT).show();
            }
        });
        miSegBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                miVista.setText("Diplomado Androidddd");
            }
        });

        miTerBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://vignette.wikia.nocookie.net/toontown/images/8/82/Toony_Toons.png/revision/latest?cb=20110313052410";
                try{
                    new Descargarimag().execute(new URL(url));
                }
                catch (Exception e){
                    android.util.Log.e("diplo tag","error al descargar imageneee");

                }
            }
        });


    }

    class Descargarimag extends AsyncTask<URL, Integer,Bitmap> {
        @Override
        protected Bitmap doInBackground(URL... urls) {
            try{
                Log.i("diplo tag","iniciando descarga...");
                imgdescarga= BitmapFactory.decodeStream(urls[0].openConnection().getInputStream());
            }
            catch (Exception e){
                Log.e ("diplo","Error:" + e.toString());
            }
            return  imgdescarga;
        }
    @Override
    protected  void  onProgressUpdate(Integer... values){
            super.onProgressUpdate(values[0]);
            Log.i("diplo tag" , ""+ values[0]);
}

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            //establecer el imageView sobre el layout
            miimagen.setImageBitmap(imgdescarga);
            super.onPostExecute(bitmap);
        }
    }


}
