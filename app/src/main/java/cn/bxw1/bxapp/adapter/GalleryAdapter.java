//package cn.bxw1.bxapp.adapter;
//
//import android.content.Context;
//import android.graphics.Paint;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.who.x1.my.R;
//import com.who.x1.my.bean.HomeBean;
//
//import java.util.List;
//
///**
// * Created by x1 on 2016/8/29.
// */
//public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
//    private LayoutInflater mInflater;
//    private Context mcontext;
////    private List<HomeBean.ResultBean.SaleSpecialListAllBean> mDatas;
//    private List<HomeBean.ResultBean.SaleSpecialListAllBean.ProductListBean> mDatas;
//
//    public GalleryAdapter(Context context, List<HomeBean.ResultBean.SaleSpecialListAllBean.ProductListBean> datats) {
//        mInflater = LayoutInflater.from(context);
//        mcontext=context;
//        mDatas = datats;
//
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        ImageView mImg;
//        TextView tv_it4_inner_name,tv_it4_inner_realprice,tv_it4_inner_price;
//
//
//        public ViewHolder(View arg0) {
//            super(arg0);
//            tv_it4_inner_name = (TextView) itemView.findViewById(R.id.tv_it4_inner_name);
//            tv_it4_inner_price = (TextView) itemView.findViewById(R.id.tv_it4_inner_price);
//            tv_it4_inner_realprice = (TextView) itemView.findViewById(R.id.tv_it4_inner_realprice);
//        }
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return mDatas.size();
//    }
//
//    /**
//     * 创建ViewHolder
//     */
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
//        View view = mInflater.inflate(R.layout.activity_recycler_item,
//                viewGroup, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//
//        viewHolder.mImg = (ImageView) view
//                .findViewById(R.id.id_index_gallery_item_image);
//        return viewHolder;
//    }
//
//    /**
//     * 设置值
//     */
//    @Override
//    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
//        String url=mDatas.get(i).getIMAGEURL_BOUTIQUE();
//        Glide.with(mcontext).load(url).centerCrop().into(viewHolder.mImg);
//        viewHolder.tv_it4_inner_name.setText(mDatas.get(i).getProduct_oneWord());
//        viewHolder.tv_it4_inner_price.setText("￥"+mDatas.get(i).getSALE_PRICE());
//        viewHolder.tv_it4_inner_realprice.setText("￥"+mDatas.get(i).getPRICE());
//        viewHolder.tv_it4_inner_realprice.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG );
//
//
//
//
//
//    }
//
//}