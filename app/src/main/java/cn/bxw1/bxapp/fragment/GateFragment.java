package cn.bxw1.bxapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import cn.bxw1.bxapp.myapplication.R;

import static cn.bxw1.bxapp.MainActivity.REQUEST_CODE;

/**
 * Package:cn.bxw1.bxapp.fragment
 * author:liuting
 * Date:2017/3/14
 * Desc:分类
 */

public class GateFragment extends Fragment {
    private View view;//view
    private TextView tvTitle;//标题
    private String mTitle;//标题
    private Button open;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_gate_layout,container,false);
        open = (Button) view.findViewById(R.id.open);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                Log.e("TAG", "开始扫描");

            }
        });
        initView();
        return view;
    }

    private void initView() {
        mTitle=getArguments().getString("title");
        tvTitle =(TextView) view.findViewById(R.id.category_tv_title);
        tvTitle.setText(mTitle);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("TAG", "扫描完成requestCode="+requestCode);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result+"发送解析结果至后台", Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
