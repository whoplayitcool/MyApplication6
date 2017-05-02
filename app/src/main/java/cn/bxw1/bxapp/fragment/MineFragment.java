package cn.bxw1.bxapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.bxw1.bxapp.LoginActivity;
import cn.bxw1.bxapp.myapplication.R;


/**
 * Package:cn.bxw1.bxapp.fragment
 * author:liuting
 * Date:2017/3/14
 * Desc:我的
 */

public class MineFragment extends Fragment {
    private View view;//view
    private TextView tvTitle;//标题
    private String mTitle;//标题

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_mine_layout,container,false);
        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button button=(Button)getActivity().findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        mTitle=this.getArguments().getString("title");
//        tvTitle =(TextView) view.findViewById(R.id.mine_tv_title);
//        tvTitle.setText(mTitle);
    }


}
