package com.lentimosystems.licio.futaa2.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidstudy.daraja.Daraja;
import com.androidstudy.daraja.DarajaListener;
import com.androidstudy.daraja.model.AccessToken;
import com.androidstudy.daraja.model.LNMExpress;
import com.androidstudy.daraja.model.LNMResult;
import com.androidstudy.daraja.util.TransactionType;
import com.lentimosystems.licio.futaa2.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PaymentActivity extends AppCompatActivity {


    @BindView(R.id.edtPhone)
    EditText editTextPhoneNumber;
    @BindView(R.id.btnEnter)
    Button sendButton;

    //Declare Daraja :: Global Variable
    Daraja daraja;

    String phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_payment);

        ButterKnife.bind(this);

        daraja = Daraja.with("1DMpTvYpFV31D4eza3efHJ3YdTx47ZZk", "PdlFTEwdtKGV55YB", new DarajaListener<AccessToken>() {
            @Override
            public void onResult(@NonNull AccessToken accessToken) {
                Log.i(PaymentActivity.this.getClass().getSimpleName(), accessToken.getAccess_token());
                Toast.makeText(PaymentActivity.this, "TOKEN : " + accessToken.getAccess_token(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String error) {
                Log.e(PaymentActivity.this.getClass().getSimpleName(), error);
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                {

                    //Get Phone Number from User Input
                    phoneNumber = editTextPhoneNumber.getText().toString().trim();

                    if (TextUtils.isEmpty(phoneNumber)) {
                        editTextPhoneNumber.setError("Please Provide a Phone Number");
                        return;
                    }


                    //TODO :: REPLACE WITH YOUR OWN CREDENTIALS  :: THIS IS SANDBOX DEMO
                    LNMExpress lnmExpress = new LNMExpress(
                            "174379",
                            "MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMTkwMzI4MTM1NDEx",  //https://developer.safaricom.co.ke/test_credentials
                            TransactionType.CustomerPayBillOnline,
                            "100",
                            "254705304841",
                            "174379",
                            phoneNumber,
                            "https://webhook.site/7a897fc4-28bc-48b3-8307-62a8c5af46d0",
                            "001ABC",
                            "Goods Payment"
                    );

                    daraja.requestMPESAExpress(lnmExpress,
                            new DarajaListener<LNMResult>() {
                                @Override
                                public void onResult(@NonNull LNMResult lnmResult) {
                                    Log.i(PaymentActivity.this.getClass().getSimpleName(), lnmResult.ResponseDescription);
                                }

                                @Override
                                public void onError(String error) {
                                    Log.i(PaymentActivity.this.getClass().getSimpleName(), error);
                                }
                            }

                    );
                }
            }
        });
    }


}
