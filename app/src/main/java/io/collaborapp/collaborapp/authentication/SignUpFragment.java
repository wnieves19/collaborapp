package io.collaborapp.collaborapp.authentication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.collaborapp.collaborapp.R;


public class SignUpFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.confirmPassword)
    EditText mPasswordConfirm;

    private OnSignUpRequestListener onSignUpRequestListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        view.findViewById(R.id.sign_up).setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onSignUpRequestListener = (OnSignUpRequestListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //TODO: Validate mPassword & mPasswordConfirm are the same
            case R.id.sign_up:
                onSignUpRequestListener.onSignUpRequest(mEmail.getText().toString(), mPassword.getText().toString());
                break;
        }
    }
    public interface OnSignUpRequestListener{
        void onSignUpRequest(String email, String password);
    }
}
