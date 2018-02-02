package com.skylinelin.multiselection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.HashSet;
import java.util.Set;

/**
 * @author skylinelin
 * @date 2018/2/1
 * */

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox mCheckBoxMeizu;
    private CheckBox mCheckBoxSumsung;
    private CheckBox mCheckBoxHuawei;
    private CheckBox nCheckBoxXiaomi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initDate();
    }
    /**
     * 存储示例数据
     * */
    private Set<Phone> mPhones = new HashSet<>();

    /**
     * 添加示例数据
     * */
    private void initDate(){
        //魅族
        mPhones.add(new Phone("魅族","魅族note2"));
        mPhones.add(new Phone("魅族","魅族note3"));
        mPhones.add(new Phone("魅族","魅族note5"));
        mPhones.add(new Phone("魅族","魅族note6"));

        //三星
        mPhones.add(new Phone("三星","sumsung S3"));
        mPhones.add(new Phone("三星","sumsung S5"));
        mPhones.add(new Phone("三星","sumsung S6"));
        mPhones.add(new Phone("三星","sumsung S7"));

        //华伟
        mPhones.add(new Phone("华伟","Huawei P1"));
        mPhones.add(new Phone("华伟","Huawei P3"));
        mPhones.add(new Phone("华伟","Huawei P5"));
        mPhones.add(new Phone("华伟","Huawei P7"));

        //小米
        mPhones.add(new Phone("小米","mi 6"));
        mPhones.add(new Phone("小米","mi 7"));
        mPhones.add(new Phone("小米","红米 note2"));
        mPhones.add(new Phone("小米","红米 note6"));





    }


    private void initViews(){
        mCheckBoxMeizu = (CheckBox) findViewById(R.id.checkbox_meizu);
        mCheckBoxSumsung = (CheckBox) findViewById(R.id.checkbox_samsung);
        mCheckBoxHuawei = (CheckBox) findViewById(R.id.checkbox_huawei);
        nCheckBoxXiaomi = (CheckBox) findViewById(R.id.checkbox_xiaomi);

        mCheckBoxMeizu.setOnCheckedChangeListener(this);
        mCheckBoxSumsung.setOnCheckedChangeListener(this);
        mCheckBoxHuawei.setOnCheckedChangeListener(this);
        nCheckBoxXiaomi.setOnCheckedChangeListener(this);

        //按钮事件
        findViewById(R.id.search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Set<Phone> results = getFilteredPhones();
            }
        });
    }
    /**
     * 获取筛选过后的结果
     * */
    private Set<Phone> getFilteredPhones(){

        Set<Phone> results = new HashSet<>();
        if (mCheckBoxResIds.size() == 0){
            return results;
        }

        for (Phone phone : mPhones){
            String brand = phone.getBrand();
            int resId=-1;
            switch (brand){
                case "魅族":
                    resId = R.id.checkbox_meizu;
                    break;
                case "三星":
                    resId = R.id.checkbox_samsung;
                    break;
                case "华伟":
                    resId = R.id.checkbox_huawei;
                    break;
                case "小米":
                    resId = R.id.checkbox_xiaomi;
                    break;

                default:
                    resId = -1;
                    break;
            }
        }


    }

    private Set<Integer> mCheckBoxResIds = new HashSet<>();

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        Log.d("MainActivity","Checked"+b+" "+compoundButton.getId());

        if (b){
            mCheckBoxResIds.add(compoundButton.getId());
        }else {
            mCheckBoxResIds.remove(compoundButton.getId());
        }
    }
}
