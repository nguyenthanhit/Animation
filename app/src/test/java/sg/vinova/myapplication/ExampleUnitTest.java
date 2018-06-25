package sg.vinova.myapplication;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Context context;

    @Before
    public void before() {
    }
    @Test
    public void addition_isCorrect() {

    }


    private String test(Context context) {
       return context.getString(R.string.app_name);
    }
}