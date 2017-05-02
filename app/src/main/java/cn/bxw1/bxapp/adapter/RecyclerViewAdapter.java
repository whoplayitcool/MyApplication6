package cn.bxw1.bxapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.bxw1.bxapp.myapplication.R;


/**
 * Created by x1 on 2016/8/27.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mLayoutInflater;
//    private GalleryAdapter galleryAdapter;
    private Context context;

//    private HomeBean homeBean;
//    private HomeBean.ActiveBeanBean activeBeanBean;
//    private HomeBean.ResultBean resultBean;
//    private List<HomeBean.ResultBean.IndexImgListBean> indexImgListBean;
//    private List<HomeBean.ResultBean.SaleSpecialListAllBean> saleSpecialListAllBean;
//    private List<HomeBean.ResultBean.IndexProductListBean> indexProductListBeen;
//    private List<HomeBean.ResultBean.SaleSpecialListAllBean.ProductListBean> productListBeen;

//    private String[] titles;
    //建立枚举 2个item 类型

    public int ITEM1 = 1;
    public int ITEM2 = 2;
    public int ITEM3 = 3;
    public int ITEM4 = 4;
    public int ITEM5 = 5;
    public int ITEM6 = 6;
    public int ITEM7 = 7;


//    public RecyclerViewAdapter(Context context, HomeBean data) {
//        this.homeBean = data;
//        this.context = context;
//        Log.e("TAG", "adapter已加载！！！！！！！！！！！！！！！！！！！！");
//        //得到类型2数据
//        activeBeanBean = data.getActiveBean();
//        //得到result数据，其中包括其他类型的数据
//        resultBean = data.getResult();
//        //得到类型3数据集合
//        indexImgListBean = resultBean.getIndexImgList();
//        //得到类型4数据集合
//        saleSpecialListAllBean = resultBean.getSaleSpecialListAll();
//        //得到类型6的数据集合
//        indexProductListBeen = resultBean.getIndexProductList();
//
////        productListBeen=homeBean.getResult().getSaleSpecialListAll().;
////
////        galleryAdapter=new GalleryAdapter(context,productListBeen);
//
//        Log.e("TAG", "mLayoutInflater+++++++++++++"+mLayoutInflater);
//
//        mLayoutInflater = LayoutInflater.from(context);
//    }
    public RecyclerViewAdapter(Context contet){
        this.context=contet;

        mLayoutInflater = LayoutInflater.from(context);
        Log.e("TAG", "本地模拟加载器"+mLayoutInflater);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        加载Item View的时候根据不同TYPE加载不同的布局
//        if (viewType == ITEM_TYPE.ITEM1.ordinal()) {
//            return new Item1ViewHolder(mLayoutInflater.inflate(R.layout.item1, parent, false));
//        } else {
//            return new Item2ViewHolder(mLayoutInflater.inflate(R.layout.item2, parent, false));
//        }

        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            //4个button
            case 1:
                holder = new Item1ViewHolder(mLayoutInflater.inflate(R.layout.item1, parent, false));
                break;
            //活动图片，时有时无
            case 2:
                holder = new Item2ViewHolder(mLayoutInflater.inflate(R.layout.item2, parent, false));
                break;
            //3图布局
            case 3:
                holder = new Item3ViewHolder(mLayoutInflater.inflate(R.layout.item3, parent, false));
                break;
            //大图加viewpager
            case 4:
                holder = new Item4ViewHolder(mLayoutInflater.inflate(R.layout.item4, parent, false));
                break;
            case 5:
                holder= new Item5ViewHolder(mLayoutInflater.inflate(R.layout.item5,parent,false));
                break;
//            //热卖单品
//            case 5:
//                holder = new Item5ViewHolder(mLayoutInflater.inflate(R.layout.item3, parent, false));
//                break;
//            //精选单品
//            case 6:
//                holder = new Item6ViewHolder(mLayoutInflater.inflate(R.layout.item5, parent, false));
//                break;
//            //标题栏
//            case 7:
//                holder = new Item7ViewHolder(mLayoutInflater.inflate(R.layout.item4, parent, false));
//                break;
            default:
//                holder = new Item2ViewHolder(mLayoutInflater.inflate(R.layout.item_t2, parent, false));
                break;
        }
//        Log.e("TAG", "homebean_______________________" + homeBean);
        Log.e("TAG", "holder"+holder);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof Item1ViewHolder) {

            ((Item1ViewHolder) holder).home_item1_tv_shopname.setText("根据位置显示店名");
            ((Item1ViewHolder) holder).home_item1_bt_tabshop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(context, "跳转至店铺选择页面", Toast.LENGTH_SHORT).show();




//                    Toast.makeText(context, "店铺"+aMapLocationClient.getLastKnownLocation().getLocationDetail(), Toast.LENGTH_SHORT).show();





                    

                }
            });
            ((Item1ViewHolder) holder).home_item1_tv_tabshop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "跳转至店铺选择页面", Toast.LENGTH_SHORT).show();

                }
            });
            Log.e("TAG", "onbind");

            
        }
        if(holder instanceof Item2ViewHolder) {
            ((Item2ViewHolder) holder).home_item2_ll_bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "跳转至熟食页面", Toast.LENGTH_SHORT).show();
                }
            });
            
        }
        if(holder instanceof Item3ViewHolder) {
            ((Item3ViewHolder) holder).home_item3_iv_bestsell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "跳转至热卖页面", Toast.LENGTH_SHORT).show();

                }
            });

        }
        if(holder instanceof Item4ViewHolder) {

        }
        if(holder instanceof Item5ViewHolder) {

        }





    }

    //设置ITEM类型，可以自由发挥，这里设置item position单数显示item1 偶数显示item2
    @Override
    public int getItemViewType(int position) {
//Enum类提供了一个ordinal()方法，返回枚举类型的序数，这里ITEM_TYPE.ITEM1.ordinal()代表0， ITEM_TYPE.ITEM2.ordinal()代表1
        //得到类型2数据


        int viewtype = 0;
        switch (position) {
            case  0:viewtype=ITEM2;
        
                break;
            case  1:viewtype=ITEM1;

                break;
            case  2:viewtype=ITEM3;

                break;
            case  3:viewtype=ITEM4;

                break;
            case  4:viewtype=ITEM5;

                break;
            default:viewtype=ITEM1;
                break;
        }
        Log.e("TAG", "viewtype======"+viewtype);
        return viewtype;

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    //门店切换条目
    public static class Item1ViewHolder extends RecyclerView.ViewHolder {
        TextView home_item1_tv_shopname;
        TextView home_item1_tv_tabshop;
        Button home_item1_bt_tabshop;

        public Item1ViewHolder(View itemView) {
            super(itemView);
            home_item1_tv_shopname= (TextView) itemView.findViewById(R.id.home_item1_tv_shopname);
            home_item1_tv_tabshop=(TextView)itemView.findViewById(R.id.home_item1_tv_tabshop);
            home_item1_bt_tabshop=(Button)itemView.findViewById(R.id.home_item1_bt_tabshop);
        }
    }

    ////button group 暂时完成第一个图标的点击事件
    public static class Item2ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout home_item2_ll_bt1;

        public Item2ViewHolder(View itemView) {
            super(itemView);
//            mTextView = (TextView) itemView.findViewById(R.id.tv_item2_text);
            home_item2_ll_bt1=(LinearLayout)itemView.findViewById(R.id.home_item2_ll_bt1);
        }
    }

    //热卖商品加水平展示
    public static class Item3ViewHolder extends RecyclerView.ViewHolder {
        ImageView home_item3_iv_bestsell;
        RecyclerView home_item3_rv_bestsell;

        public Item3ViewHolder(View itemView) {
            super(itemView);
            home_item3_iv_bestsell=(ImageView)itemView.findViewById(R.id.home_item3_iv_bestsell);
            home_item3_rv_bestsell=(RecyclerView)itemView.findViewById(R.id.home_item3_rv_bestsell);


        }
    }

    //上新加垂直展示
    public static class Item4ViewHolder extends RecyclerView.ViewHolder {
        ImageView home_item4_iv_new;
        RecyclerView home_item4_rv_new;


        public Item4ViewHolder(View itemView) {
                super(itemView);
            home_item4_iv_new=(ImageView)itemView.findViewById(R.id.home_item4_iv_new);
            home_item4_rv_new=(RecyclerView)itemView.findViewById(R.id.home_item4_rv_new);


        }
    }

    //超值商品
    public static class Item5ViewHolder extends RecyclerView.ViewHolder {
        ImageView home_item5_iv_worth;
       RecyclerView home_item5_rv_worth;

        public Item5ViewHolder(View itemView) {
            super(itemView);
            home_item5_iv_worth=(ImageView)itemView.findViewById(R.id.home_item5_iv_worth);
            home_item5_rv_worth=(RecyclerView)itemView.findViewById(R.id.home_item5_rv_worth);



        }
    }
//
//    //精选单品
//    public static class Item6ViewHolder extends RecyclerView.ViewHolder {
//        ImageView iv_it6_left;
//        ImageView iv_it6_right;
//        TextView tv_it6_price_left;
//        TextView tv_it6_price_right;
//        TextView tv_midcut;
//        TextView tv_midcut2;
//
//        public Item6ViewHolder(View itemView) {
//            super(itemView);
//            iv_it6_left = (ImageView) itemView.findViewById(R.id.iv_it6_left);
//            iv_it6_right = (ImageView) itemView.findViewById(R.id.iv_it6_right);
//            tv_it6_price_left = (TextView) itemView.findViewById(R.id.tv_it6_price_left);
//            tv_it6_price_right = (TextView) itemView.findViewById(R.id.tv_it6_price_right);
//            tv_midcut = (TextView) itemView.findViewById(R.id.tv_midcut);
//            tv_midcut2 = (TextView) itemView.findViewById(R.id.tv_midcut2);
//
//        }
//    }
//
//    public static class Item7ViewHolder extends RecyclerView.ViewHolder {
//        TextView tv_it7;
//
//        //标题栏
//        public Item7ViewHolder(View itemView) {
//            super(itemView);
//            tv_it7 = (TextView) itemView.findViewById(R.id.tv_it7);
//
//        }
//    }

}