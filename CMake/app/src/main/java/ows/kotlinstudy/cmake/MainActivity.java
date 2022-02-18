package ows.kotlinstudy.cmake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ows.kotlinstudy.cmake.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'cmake' library on application startup.
    static {
        System.loadLibrary("cmake");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(String.valueOf(getSum(1,2)));
    }

    /**
     * A native method that is implemented by the 'cmake' native library,
     * which is packaged with this application.
     */
    public native int getSum(int num1, int num2);
}