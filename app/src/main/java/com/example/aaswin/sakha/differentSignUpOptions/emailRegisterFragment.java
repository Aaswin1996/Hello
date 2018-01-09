package com.example.aaswin.sakha.differentSignUpOptions;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aaswin.sakha.LoginActivity;
import com.example.aaswin.sakha.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

/**
 * Created by aaswin on 20/12/17.
 */

public class emailRegisterFragment extends Fragment {
    private EditText email;
    private EditText password;
    private Button login;
    private TextView signup;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    //private ProgressBar progessBar;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.email_register_frag, container, false);
        mAuth = FirebaseAuth.getInstance();
        email = (EditText) view.findViewById(R.id.email);
        password = (EditText) view.findViewById(R.id.password);
        login = (Button) view.findViewById(R.id.login);
        signup = (TextView) view.findViewById(R.id.signup);
       // progessBar = (ProgressBar) view.findViewById(R.id.progressBar);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = email.getText().toString().trim();
                String key = password.getText().toString().trim();


                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(getActivity(), "please enter username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(key)) {
                    Toast.makeText(getActivity(), "please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                    email.setError("please enter a valid email");
                    email.requestFocus();
                    return;
                }
                if (key.length() < 6) {
                    password.setError("password should be 6 letter long");
                    password.requestFocus();
                    return;
                }
                //progessBar.setVisibility(View.VISIBLE);
                mAuth.createUserWithEmailAndPassword(username, key)
                        .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                      //          progessBar.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(getActivity(), "Signup Complete", Toast.LENGTH_SHORT).show();

                                    Intent i = new Intent(getActivity(), LoginActivity.class);
                                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    getActivity().finish();
                                    startActivity(i);

                                } else {
                                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                        Toast.makeText(getActivity(), "already registered", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_LONG).show();


                                    }
                                }

                                // ...
                            }
                        });


            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);

            }
        });
        return  view;
    }



}



