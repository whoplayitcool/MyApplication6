package cn.bxw1.bxapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocationClient;

import java.util.ArrayList;
import java.util.List;

import cn.bxw1.bxapp.amap.CheckPermissionsActivity;
import cn.bxw1.bxapp.amap.Utils;
import cn.bxw1.bxapp.myapplication.R;
import cn.bxw1.bxapp.widget.FragmentTabHost;

public class MainActivity extends  CheckPermissionsActivity{
    private FragmentTabHost tabhost;//底部Tab
    private List<cn.bxw1.bxapp.bean.TabInfo> list;//tab列表
    private LayoutInflater inflater;
    public static final int REQUEST_CODE = 111;
    //AMAP




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initTab();
        initLocation();
        Toast.makeText(this, "店铺位置是"+locationClient.getLastKnownLocation(), Toast.LENGTH_SHORT).show();
        Log.e("BAG", "店铺位置是"+ Utils.getLocationStr(locationClient.getLastKnownLocation()));

    }
    public void initLocation(){
        //初始化client
        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = getDefaultOption();
        //设置定位参数
        locationClient.setLocationOption(locationOption);
        // 设置定位监听
        locationClient.setLocationListener(locationListener);
    }

    /**
     * 初始化Tab
     */
    public void initTab() {
        tabhost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        list = new ArrayList<>(5);
        inflater = LayoutInflater.from(this);

        cn.bxw1.bxapp.bean.TabInfo tab_home = new cn.bxw1.bxapp.bean.TabInfo(cn.bxw1.bxapp.fragment.HomeFragment.class, R.string.home, R.drawable.selector_icon_home);
//        TabInfo tab_hot= new TabInfo(HotFragment.class,R.string.hot,R.drawable.selector_icon_hot);
//        TabInfo tab_category= new TabInfo(GateFragment.class,R.string.category,R.drawable.selector_icon_category);
        cn.bxw1.bxapp.bean.TabInfo tab_category = new cn.bxw1.bxapp.bean.TabInfo(cn.bxw1.bxapp.fragment.CategorizeFragment.class, R.string.category, R.drawable.selector_icon_category);

        cn.bxw1.bxapp.bean.TabInfo tab_door = new cn.bxw1.bxapp.bean.TabInfo(cn.bxw1.bxapp.fragment.GateFragment.class, R.string.door, R.drawable.selector_icon_door);
        cn.bxw1.bxapp.bean.TabInfo tab_cart = new cn.bxw1.bxapp.bean.TabInfo(cn.bxw1.bxapp.fragment.CartFragment.class, R.string.cart, R.drawable.selector_icon_cart);
        cn.bxw1.bxapp.bean.TabInfo tab_mine = new cn.bxw1.bxapp.bean.TabInfo(cn.bxw1.bxapp.fragment.MineFragment.class, R.string.mine, R.drawable.selector_icon_mine);

        list.add(tab_home);
        list.add(tab_category);
        list.add(tab_door);

        list.add(tab_cart);
        list.add(tab_mine);
        //必须在添加TabSpec之前调用
        tabhost.setup(this, getSupportFragmentManager(), R.id.main_frame_content);

        for (cn.bxw1.bxapp.bean.TabInfo tab : list) {

            TabHost.TabSpec tabSpec = tabhost.newTabSpec(getString(tab.getTitle()));

            tabSpec.setIndicator(buildIndicator(tab));

            Bundle bundle = new Bundle();
            bundle.putString("title", getString(tab.getTitle()));
            tabhost.addTab(tabSpec, tab.getFragment(), bundle);

        }

        tabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        tabhost.setCurrentTab(0);
        tabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equals(getString(R.string.cart))) {
                    Toast.makeText(MainActivity.this, getString(R.string.cart), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 初始化Indicator
     *
     * @param tab tab实体类
     * @return
     */
    private View buildIndicator(cn.bxw1.bxapp.bean.TabInfo tab) {

        View view = inflater.inflate(R.layout.tab_indicator, null);
        ImageView img = (ImageView) view.findViewById(R.id.tab_img_icon);
        TextView text = (TextView) view.findViewById(R.id.tab_tv_indicator);

        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return view;
    }


}
