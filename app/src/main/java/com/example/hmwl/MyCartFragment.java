package com.example.hmwl;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {

    public MyCartFragment(){
        //Required empty public constructor
    }

    private RecyclerView cartItemsRecyclerView;
//    private Dialog loadingDialog;
    public static CartAdapter cartAdapter;
    private Button continueBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        ////loading dialog
//        loadingDialog = new Dialog(getContext());
//        loadingDialog.setContentView(R.layout.loading_progress_dialog);
//        loadingDialog.setCancelable(false);
//        loadingDialog.getWindow().setBackgroundDrawable(getContext().getDrawable(R.drawable.slider_background));
//        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        loadingDialog.show();
        ////loading dialog

        cartItemsRecyclerView = view.findViewById(R.id.cart_items_recyclerview);
        continueBtn = view.findViewById(R.id.cart_continue_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        if (DBqueries.cartItemModelList.size() == 0){
            DBqueries.cartList.clear();
            DBqueries.loadCartList(getContext(),true);
        }

//        List<CartItemModel> cartItemModelList = new ArrayList<>();
//        cartItemModelList.add(new CartItemModel(1,"Price (3 Items)", "Rs.2500/-","Free","You saved Rs.501/- in this order","2500/-"));

        cartAdapter = new CartAdapter(DBqueries.cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(getContext(), AddAddressActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });
        return view;
    }
}