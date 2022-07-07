package ec.com.micasaapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import ec.com.micasaapp.R;
import ec.com.micasaapp.utils.Utils;

public class DetalleActivity extends AppCompatActivity {

    ImageView imgDepartamento;
    TextView txtNombreDepartamento;
    TextView txtPrecioDepartamento;
    TextView txtDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        imgDepartamento = findViewById(R.id.imgDetalleApart);
        txtNombreDepartamento = findViewById(R.id.txtDescripcionCasa);
        txtPrecioDepartamento = findViewById(R.id.textPrecio);
        txtDetalle = findViewById(R.id.txtDetalle);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String urlImagen = extras.getString("imagen");
            Utils.loadImage(urlImagen, imgDepartamento);
            String strNombre = extras.getString("nombreDpto");
            txtNombreDepartamento.setText(strNombre);
            int strPrecio = extras.getInt("precioDpto");
            txtPrecioDepartamento.setText(strPrecio+"");
            String detalle = extras.getString("detalleDpto");
            txtDetalle.setText(detalle);
        }

    }
}