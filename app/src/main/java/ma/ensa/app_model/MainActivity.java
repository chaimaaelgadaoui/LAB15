package ma.ensa.app_model;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import ma.ensa.app_model.classes.Etudiant;
import ma.ensa.app_model.service.EtudiantService;

public class MainActivity extends AppCompatActivity {

    private EditText nom, prenom, idEtudiant;
    private Button bn, load, delete;
    private TextView res;
    private EtudiantService es;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        es = new EtudiantService(this);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        idEtudiant = findViewById(R.id.id);
        bn = findViewById(R.id.bn);
        load = findViewById(R.id.load);
        delete = findViewById(R.id.delete);
        res = findViewById(R.id.res);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = nom.getText().toString();
                String p = prenom.getText().toString();
                if (!n.isEmpty() && !p.isEmpty()) {
                    es.create(new Etudiant(n, p));
                    Toast.makeText(MainActivity.this, "Étudiant ajouté", Toast.LENGTH_SHORT).show();
                    nom.setText("");
                    prenom.setText("");
                    actualiserLog();
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez remplir les champs", Toast.LENGTH_SHORT).show();
                }
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idStr = idEtudiant.getText().toString();
                if (!idStr.isEmpty()) {
                    Etudiant e = es.findById(Integer.parseInt(idStr));
                    if (e != null) {
                        res.setText(e.getNom() + " " + e.getPrenom());
                    } else {
                        res.setText("Étudiant non trouvé");
                    }
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idStr = idEtudiant.getText().toString();
                if (!idStr.isEmpty()) {
                    Etudiant e = es.findById(Integer.parseInt(idStr));
                    if (e != null) {
                        es.delete(e);
                        Toast.makeText(MainActivity.this, "Étudiant supprimé", Toast.LENGTH_SHORT).show();
                        res.setText("");
                        idEtudiant.setText("");
                        actualiserLog();
                    } else {
                        Toast.makeText(MainActivity.this, "ID introuvable", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        actualiserLog();
    }

    private void actualiserLog() {
        List<Etudiant> list = es.findAll();
        for (Etudiant e : list) {
            Log.d("EtudiantList", e.getId() + ": " + e.getNom() + " " + e.getPrenom());
        }
    }
}