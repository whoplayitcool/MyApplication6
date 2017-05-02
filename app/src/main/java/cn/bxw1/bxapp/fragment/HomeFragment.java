package cn.bxw1.bxapp.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.List;

import cn.bxw1.bxapp.adapter.RecyclerViewAdapter;
import cn.bxw1.bxapp.bean.BannerInfo;
import cn.bxw1.bxapp.myapplication.R;

/**
 * Package:cn.bxw1.bxapp.fragment
 * author:liuting
 * Date:2017/3/14
 * Desc:主页
 * 总结：AndroidImageSlider具体用法请参照：https://github.com/daimajia/AndroidImageSlider
 */

public class HomeFragment extends Fragment implements BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {
    private View view;//view
    private TextView tvTitle;//标题
    private String mTitle;//标题
    private SliderLayout mSlider;//滚动布局
    private List<BannerInfo> listBanner;//滚动广告列表
    private PagerIndicator indicator;//自定义的indicator
    private RecyclerView recyclerView;//商品分类
    private RecyclerViewAdapter adapter;//分类Adapter
    private static final int INIT_SLIDER_TYPE = 0;
    private Dialog dialog;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case INIT_SLIDER_TYPE:
                    initSlider();
                    dialog.dismiss();
                    break;
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_layout, container, false);
        initView();
        return view;
    }

    private void initView() {
        listBanner = new ArrayList<>();
        mTitle = (String) this.getArguments().getSerializable("title");
        tvTitle = (TextView) view.findViewById(R.id.home_tv_title);
        tvTitle.setText(mTitle);
        dialog = new ProgressDialog(getActivity());

        getBannerData();

        mSlider = (SliderLayout) view.findViewById(R.id.home_slider_ad);
        indicator = (PagerIndicator) view.findViewById(R.id.home_indicator_ad);

        initRecyclerView();
    }

    public void initRecyclerView() {

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_home_fragment);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new RecyclerViewAdapter(getActivity()));




    }

    /**
     * 初始化SliderLayout
     */
    private void initSlider() {
        if (listBanner != null) {
            for (BannerInfo bannerInfo : listBanner) {
                TextSliderView textSliderView = new TextSliderView(this.getActivity());
          //此处可以切换本地或者网络图片
                textSliderView.image(bannerInfo.getImgUri())
                        .description(bannerInfo.getName())
                        .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                        .setOnSliderClickListener(this);
                mSlider.addSlider(textSliderView);
            }
        }

        mSlider.setCustomIndicator(indicator);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setPresetTransformer(SliderLayout.Transformer.Default);//可以改变轮播
        mSlider.setDuration(3000);
        mSlider.addOnPageChangeListener(this);
        mSlider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    /**
     * 获取滚动广告的数据信息
     */
    private void getBannerData() {
        BannerInfo bannerInfo_01 = new BannerInfo();
        bannerInfo_01.setName("音箱狂欢");
//        bannerInfo_01.setImgUrl("http://7mno4h.com2.z0.glb.qiniucdn.com/5608f3b5Nc8d90151.jpg");
        bannerInfo_01.setImgUri(R.drawable.bg);
        BannerInfo bannerInfo_02 = new BannerInfo();
        bannerInfo_02.setName("手机国庆礼");
        bannerInfo_02.setImgUri(R.drawable.bg);
        bannerInfo_02.setImgUrl("http://7mno4h.com2.z0.glb.qiniucdn.com/5608eb8cN9b9a0a39.jpg");
        BannerInfo bannerInfo_03 = new BannerInfo();
        bannerInfo_03.setName("IT生活");
        bannerInfo_03.setImgUrl("http://7mno4h.com2.z0.glb.qiniucdn.com/5608cae6Nbb1a39f9.jpg");
        bannerInfo_03.setImgUri(R.drawable.bg);
        listBanner.add(bannerInfo_01);
        listBanner.add(bannerInfo_02);
        listBanner.add(bannerInfo_03);
        handler.sendEmptyMessage(INIT_SLIDER_TYPE);

        //Get 方法
//        String url ="http://112.124.22.238:8081/course_api/banner/query?type=1";
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Toast.makeText(getActivity(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if(response.isSuccessful()){
//                    Type type = new TypeToken<List<BannerInfo>>(){}.getType();
//                    Gson gson = new Gson();
//                    List<BannerInfo> list= gson.fromJson(response.body().string(),type);
//                    for (BannerInfo bannerInfo:list)
//                    {
//                        listBanner.add(bannerInfo);
//                    }
//                    handler.sendEmptyMessage(INIT_SLIDER_TYPE);
//                }else {
//                    Toast.makeText(getActivity(),"IOException",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        dialog.show();
//        String url ="http://112.124.22.238:8081/course_api/banner/query";
//        OkHttpClient client = new OkHttpClient();
//        RequestBody body = new FormBody.Builder()
//                .add("type","1")
//                .build();
//        Request request = new Request.Builder()
//                .url(url)
//                .post(body)
//                .build();
//        Log.e("TAG", "请求是："+request.toString());
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                dialog.dismiss();
//                Toast.makeText(getActivity(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if(response.isSuccessful()){
//                    Type type = new TypeToken<List<BannerInfo>>(){}.getType();
//                    Gson gson = new Gson();
//                    List<BannerInfo> list= gson.fromJson(response.body().string(),type);
//                    for (BannerInfo bannerInfo:list)
//                    {
//                        listBanner.add(bannerInfo);
//                    }
//                    handler.sendEmptyMessage(INIT_SLIDER_TYPE);
//                }else {
//                    dialog.dismiss();
//                    Toast.makeText(getActivity(),"IOException",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(getActivity(), slider.getDescription(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        mSlider.stopAutoCycle();
        super.onStop();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e("TAG", "pageScrolled");
    }

    @Override
    public void onPageSelected(int position) {
        Log.e("TAG", "pageSelected");
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.e("TAG", "pageScrollStateChanged");
    }
}
