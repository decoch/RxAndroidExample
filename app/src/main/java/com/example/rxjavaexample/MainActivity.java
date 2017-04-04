package com.example.rxjavaexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.rxjavaexample.entity.WeatherEntity;
import com.example.rxjavaexample.service.WeatherApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.converter.GsonConverter;

public class MainActivity extends AppCompatActivity {

    private static final String END_POINT = "http://weather.livedoor.com";

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.textview0)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Stream example
        List<Integer> res = Observable.just(1, 2, 3, 4, 5, 6) // IterableなオブジェクトからObservableを生成
                .filter(i -> i % 2 == 0)          // Stream APIのfilter相当
                .map(i -> i * 2)                  // Stream APIのmap相当
                .skip(1)                          // Stream APIのskip相当
                .take(3)                          // Stream APIのlimit相当 ※同様の処理のlimit()も存在する
                .toList()                         // ストリームをListに変換
                .blockingGet();
        Log.d(TAG, res.toString());

        // Optional example
//        Observables.ofNullable("1,2,3,4")
//                .flatMap(str-> Observable.from(asList(str.split(","))))
//                .map(Integer::parseInt)
//                .filter(i -> i % 2 == 0)
//                .subscribe(System.out::println);

        // Rest example
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        // RestAdapterを作成する
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(END_POINT)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog("=NETWORK="))
                .build();

        // 天気予報情報を取得する
        //http://weather.livedoor.com/area/forecast/200010
//        WeatherApi api =  adapter.create(WeatherApi.class);
//        api.getWeather("200010")
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<WeatherEntity>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                    }
//
//                    @Override
//                    public void onNext(WeatherEntity value) {
//                        Log.e(TAG, "onNext(" + value + ")");
//                        textView.setText(textView.getText() + ", " + value); // 追加
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e(TAG, "onError()", e);
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "onCompleted()");
//                        textView.setText(textView.getText() + ", " + "onCompleted()"); // 追加
//                    }
//                });
    }
}
