package imc.cursoandroid.gdgcali.com.imccalculator.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import imc.cursoandroid.gdgcali.com.imccalculator.R;
import imc.cursoandroid.gdgcali.com.imccalculator.adapter.ResultAdapter;
import imc.cursoandroid.gdgcali.com.imccalculator.adapter.ResultRecyclerAdapter;
import imc.cursoandroid.gdgcali.com.imccalculator.model.ResultModel;
import imc.cursoandroid.gdgcali.com.imccalculator.util.EnvironmentFields;

public class MainActivity extends Activity {
    Context context;

    double dPeso, dAltura, dIMC;
    ResultAdapter adapter;
    ResultRecyclerAdapter adapterRecycler;
    List<ResultModel> lstResult;

    @BindView(R.id.id_et_peso)
    EditText peso;

    @BindView(R.id.id_et_altura)
    EditText altura;

    @BindView(R.id.id_btn_calcular)
    Button btnCalcular;

    @BindView(R.id.id_btn_cancelar)
    Button btnCancelar;

    @BindView(R.id.id_howisicm)
    Button btnHoIs;

//    @BindView(R.id.id_lstview)
//    ListView lvResults;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_rv);

        ButterKnife.bind(this);
        context = this;
        lstResult = new ArrayList<>();
    }

    @OnClick(R.id.id_btn_calcular)
    public void calcular() {
        Toast.makeText(context, "Calculando...", Toast.LENGTH_LONG).show();
        dPeso = Double.parseDouble(peso.getText().toString());
        dAltura = Double.parseDouble(altura.getText().toString());
        dIMC = dPeso / dAltura * dAltura;
        ResultModel resultModel = new ResultModel(dPeso, dAltura, dIMC);
        lstResult.add(resultModel);
//        adapter = new ResultAdapter(lstResult, context);
//        lvResults.setAdapter(adapter);

        adapterRecycler = new ResultRecyclerAdapter(lstResult, context);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapterRecycler);


        peso.setText("");
        altura.setText("");
    }

    @OnClick(R.id.id_howisicm)
    public void howIs() {
        Toast.makeText(context, "Abriendo otro activity...", Toast.LENGTH_LONG).show();
        Intent intNext = new Intent(this, DetailActivity.class);
        Bundle bdParams = new Bundle();
        bdParams.putString(EnvironmentFields.K_PARAMS_NAME, "Tu Nombre");
        bdParams.putDouble(EnvironmentFields.K_PARAMS_IMC, dIMC);
        intNext.putExtras(bdParams);

//        intNext.putExtra(EnvironmentFields.K_PARAMS_NAME, "Hola");
        startActivity(intNext);

    }
}
