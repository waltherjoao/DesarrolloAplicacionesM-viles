package ec.com.ventaslemas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
Para poder ingresar a esta aplicación las credenciales son las siguientes:
login: admin
pass: admin
*/

public class MainActivity extends AppCompatActivity {

    Button btnEnviar;
    EditText edtLogin;
    EditText edtPass;

    String login, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnEnviar = findViewById(R.id.btnEnviar);
        edtLogin = findViewById(R.id.edtNombre);
        edtPass = findViewById(R.id.edtPass);
        login = SharedPreferencesManager.getValorEsperado(MainActivity.this, ValoresConstantes.NOMBRE_PREFERENCIA, ValoresConstantes.VALOR_LOGIN);
        password = SharedPreferencesManager.getValorEsperado(MainActivity.this, ValoresConstantes.NOMBRE_PREFERENCIA, ValoresConstantes.VALOR_PASSWORD);
        if(login != null && password != null){
            /*Intent intent = new Intent(MainActivity.this, Home.class);*/
            Intent intent = new Intent(MainActivity.this, ViviendaActivity.class);
            startActivity(intent);
            finish();
            edtLogin.setText(login);
            edtPass.setText(password);
        }

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login = edtLogin.getText().toString();
                password = edtPass.getText().toString();
                boolean continuar = metodoValidacionFormulario();
                if(continuar){
                    SharedPreferencesManager.setValor(MainActivity.this, ValoresConstantes.NOMBRE_PREFERENCIA, login, ValoresConstantes.VALOR_LOGIN);
                    SharedPreferencesManager.setValor(MainActivity.this, ValoresConstantes.NOMBRE_PREFERENCIA, password, ValoresConstantes.VALOR_PASSWORD);

                    //Intent intent = new Intent(MainActivity.this, Home.class);
                    Intent intent = new Intent(MainActivity.this, ViviendaActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean metodoValidacionFormulario() {
        if(login.isEmpty()){
            llamarAlert("No ha digitado el login");
            return false;
        } else if (password.isEmpty()) {
            llamarAlert("No ha digitado la contraseña");
            return false;
        } else if(login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
            return true;
        }
        llamarAlert("Las credenciales son incorrectas, favor ingresar las correctas");
        return false;
    }

    private void llamarAlert(String texto) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.error));
        builder.setMessage(texto);
        builder.setPositiveButton("Aceptar", null);
        builder.create().show();
    }


}