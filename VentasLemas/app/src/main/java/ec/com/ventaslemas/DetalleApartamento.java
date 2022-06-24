package ec.com.ventaslemas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleApartamento extends AppCompatActivity {

    ImageView imgDepartamento;
    TextView txtNombreDepartamento;
    TextView txtPrecioDepartamento;
    TextView txtDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_apartamento);
        imgDepartamento = findViewById(R.id.imgDetalleApart);
        txtNombreDepartamento = findViewById(R.id.txtDescripcionCasa);
        txtPrecioDepartamento = findViewById(R.id.textPrecio);
        txtDetalle = findViewById(R.id.txtDetalle);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            /*int imgResources = extras.getInt("imagen");
            imgDepartamento.setImageResource(imgResources);*/
            //Utils.loadImage("https://teclemas.edu.ec/wp-content/uploads/2017/02/campuslife2-1.png", imgDepartamento);
            String strNombre = extras.getString("nombreDpto");
            txtNombreDepartamento.setText(strNombre);
            int strPrecio = extras.getInt("precioDpto");
            txtPrecioDepartamento.setText(strPrecio+"");
            String imagen = extras.getString("imagen");
            Utils.loadImage(imagen, imgDepartamento);
            String detalle = extras.getString("detalleDpto");
            txtDetalle.setText(detalle);
        }
    }
}