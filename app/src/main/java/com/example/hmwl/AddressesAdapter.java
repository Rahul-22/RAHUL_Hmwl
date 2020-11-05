package com.example.hmwl;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//import static com.example.mymall.DeliveryActivity.SELECT_ADDRESS;
//import static com.example.mymall.MyAccountFragment.MANAGE_ADDRESS;
//import static com.example.mymall.MyAddressesActivity.refreshItem;

public class AddressesAdapter extends RecyclerView.Adapter<AddressesAdapter.Viewholder> {

    private List<AddressesModel> addressesModelList;

    public AddressesAdapter(List<AddressesModel> addressesModelList) {
        this.addressesModelList = addressesModelList;
    }

    @NonNull
    @Override
    public AddressesAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.addresses_item_layout,viewGroup,false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressesAdapter.Viewholder viewholder, int position) {

        String username = addressesModelList.get(position).getFullname();
        String address = addressesModelList.get(position).getAddress();
        String pincode = addressesModelList.get(position).getPincode();
//        Boolean selected = addressesModelList.get(position).getSelected();
//        String mobileNo = addressesModelList.get(position).getMobileNo();

        viewholder.setData(username,address,pincode);
    }

    @Override
    public int getItemCount() {
        return addressesModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {


        private TextView fullname;
        private TextView address;
        private TextView pincode;
//        private TextView editIcon, removeIcon;
//        private ImageView icon;// ye wo checkmark ka symbol h;
//        private LinearLayout optionContainer;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            fullname = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            pincode = itemView.findViewById(R.id.pincode);
//            icon = itemView.findViewById(R.id.icon_view);
//            editIcon = itemView.findViewById(R.id.edit_icon);
//            removeIcon = itemView.findViewById(R.id.remove_icon);
//            optionContainer = itemView.findViewById(R.id.option_container);
        }

        private void setData(String username, String userAddress, String userPincode) {
            fullname.setText(username);
            address.setText(userAddress);
            pincode.setText(userPincode);
        }
    }
}