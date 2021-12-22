package com.example.bkd0708k11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.example.bkd0708k11.adapters.AdapterEmployee;
import com.example.bkd0708k11.domains.Employee;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ActivityListEmployee extends AppCompatActivity {
    RecyclerView rcEmployee;
    ArrayList<Employee> employees = new ArrayList<>();
    AdapterEmployee adapterEmployee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_employee);
        rcEmployee = findViewById(R.id.rcEmployee);
        adapterEmployee = new AdapterEmployee(ActivityListEmployee.this, employees);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ActivityListEmployee.this, LinearLayoutManager.VERTICAL, false);
        rcEmployee.setLayoutManager(linearLayoutManager);
        rcEmployee.setAdapter(adapterEmployee);

        new GetEmployeesAsyncTask("http://192.168.1.5/employee_services/GetData.php").execute();
    }

    public class GetEmployeesAsyncTask extends AsyncTask<Void, Long, String> {
        String url;

        public GetEmployeesAsyncTask(String url) {
            this.url = url;
        }

        @Override
        protected String doInBackground(Void... voids) {

            try {
                URL url = new URL(this.url);
                URLConnection urlConnection = url.openConnection();//mở kết nối đến server
                InputStream inputStream = urlConnection.getInputStream();
                BufferedReader stringBuffer = new BufferedReader(new InputStreamReader(inputStream));
                String line = null;
                StringBuilder stringBuilder = new StringBuilder();
                while ((line = stringBuffer.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }
                stringBuffer.close();
                return stringBuilder.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray jsonArray = new JSONArray(s);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    System.out.println(jsonObject.getString("name"));
                    System.out.println(jsonObject.getString("address"));
                    String id = jsonObject.getString("id");
                    String name = jsonObject.getString("name");
                    String address = jsonObject.getString("address");
                    String salary = jsonObject.getString("salary");
                    Employee employee = new Employee(id, name, address, salary);
                    employees.add(employee);
                }
                adapterEmployee.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(ActivityListEmployee.this, "Bắt đầu tải dữ liệu",
                    Toast.LENGTH_LONG).show();
        }
    }

}