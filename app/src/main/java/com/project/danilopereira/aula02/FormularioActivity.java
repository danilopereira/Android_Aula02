package com.project.danilopereira.aula02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome;
    private Spinner spCurso;
    private RadioGroup rbPeriodo;
    private Button btnParticipar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNome = (EditText) findViewById(R.id.etNome);
        spCurso = (Spinner) findViewById(R.id.spCurso);
        rbPeriodo = (RadioGroup) findViewById(R.id.rgPeriodo);
        btnParticipar = (Button) findViewById(R.id.btnParticipar);

        btnParticipar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormularioActivity.this, ConfirmacaoActivity.class);
                intent.putExtra(getString(R.string.label_nome), etNome.getText().toString());
                intent.putExtra(getString(R.string.label_curso), spCurso.getSelectedItem().toString());
                intent.putExtra(getString(R.string.label_periodo), rbPeriodo.getCheckedRadioButtonId() == R.id.rbManha ?
                getString(R.string.rbManha): getString(R.string.rbNoite));
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                FormularioActivity.this.finish();
            }
        });

    }
}
