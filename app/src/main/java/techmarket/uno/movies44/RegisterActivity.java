package techmarket.uno.movies44;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextEmailAddress;
    private EditText editTextPassword;
    private Button buttonRegister;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Objects.requireNonNull(getSupportActionBar()).hide();
        editTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);
        db = FirebaseFirestore.getInstance();

//        Map<String, Object> user = new HashMap<>();
//        user.put("first", "Alan");
//        user.put("middle", "Mathison");
//        user.put("last", "Turing");
//        user.put("born", 1912);
//
//        db.collection("users")
//                .add(user)
//        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//                Toast.makeText(RegisterActivity.this, "Added", Toast.LENGTH_SHORT).show();
//                Log.i("test","added with ID" + documentReference);
//            }
//        })
//        .addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(RegisterActivity.this, "Not Added", Toast.LENGTH_SHORT).show();
//                Log.i("test","error with ID" + e);
//            }
//        });
//        db.collection("users")
//                .get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if (task.isSuccessful()){
//                            for (QueryDocumentSnapshot document : Objects.requireNonNull(task.getResult())){
//                                //Log.i("test", document.getId() + "=>" + document.getData());
//                                Map<String, Object> user = document.getData();
//                                Log.i("test",user.get("first").toString());
//                                Log.i("test",user.get("last").toString());
//                                Log.i("test",user.get("born").toString());
//                            }
//                        }else{
//                            Log.i("test", "Error: " + task.getException());
//                        }
//                    }
//                });
        db.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                     if(value !=null){
                         for (QueryDocumentSnapshot document : value) {
                             //Log.i("test", document.getId() + "=>" + document.getData());
                             Map<String, Object> user = document.getData();
                             Log.i("test", user.get("first").toString());
                             Log.i("test", user.get("last").toString());
                             Log.i("test", user.get("born").toString());
                         }
                     }else{
                         Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                     }}

        });

    }


    public void onClickAlreadyRegistered(View view) {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}