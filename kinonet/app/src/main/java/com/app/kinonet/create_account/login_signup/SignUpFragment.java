package com.app.kinonet.create_account.login_signup;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.kinonet.BottomNavActivity;
import com.app.kinonet.R;
import com.app.kinonet.create_account.UserActivity;
import com.app.kinonet.create_account.VerifyActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpFragment extends Fragment {

    private FirebaseAuth mAuth;
    public SignUpFragment() {
        // Required empty public constructor
    }
    EditText etEmail, etPass;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        TextView txtSignUpNext = view.findViewById(R.id.txt_next);
        etEmail = view.findViewById(R.id.et_email);
        etPass = view.findViewById(R.id.et_password);
        txtSignUpNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String email = etEmail.getText().toString();
                String password = etPass.getText().toString();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d("norm", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(getActivity(), BottomNavActivity.class);
                                    startActivity(intent);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("plox", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getActivity(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }


                            }
                        });


            }
        });

        return view;
    }

}
