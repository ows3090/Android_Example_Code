package ows.kotlinstudy.ndk_build;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    static {
        System.loadLibrary("native-lib");
    }

    public native int plus(int num1, int num2);
    public native int minus(int num1, int num2);
    public native int multi(int num1, int num2);
    public native double div(int num1, int num2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int num1 = 10;
        int num2 = 20;
        Log.d(TAG, "num1 + num2 = "+plus(num1, num2));
        Log.d(TAG, "num1 - num2 = "+minus(num1, num2));
        Log.d(TAG, "num1 * num2 = "+multi(num1, num2));
        Log.d(TAG, "num1 / num2 = "+div(num1, num2));
    }
}