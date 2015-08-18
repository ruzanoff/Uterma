package ru.opi_opi.uterma;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class ToAsk extends Activity {
    HttpClient client = new DefaultHttpClient();
    HttpGet request = new HttpGet("http://opi-opi.ru/api.php?w=1");
    private MyTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_ask);
        task = new MyTask();
    }

    public void onShowMessage(View view) throws ExecutionException, InterruptedException {

        task.execute();
        String text = task.get();
        Toast.makeText(this, task.get(), Toast.LENGTH_SHORT).show();

    }

    class MyTask extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {
            //
            HttpResponse response;
            try {
                response = client.execute(request);

                Log.d("Ответ GET запроса", response.toString());
            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //
            return "Hello";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

    }
}
