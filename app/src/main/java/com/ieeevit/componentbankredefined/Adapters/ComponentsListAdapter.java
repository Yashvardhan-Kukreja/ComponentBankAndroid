package com.ieeevit.componentbankredefined.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ieeevit.componentbankredefined.Classes.Component;
import com.ieeevit.componentbankredefined.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Yash 1300 on 12-12-2017.
 */

public class ComponentsListAdapter extends ArrayAdapter {

    @BindView(R.id.componentsListComponentName) TextView name;
    @BindView(R.id.componentsListComponentAvailability) TextView available;
    @BindView(R.id.componentsListComponentDate) TextView date;

    Context context;
    List<Component> components;
    List<String> dates;

    int choice;

    public ComponentsListAdapter(@NonNull Context context, List<Component> components, List<String> dates,int choice) {
        super(context, R.layout.adapter_components_list, components);
        this.context = context;
        this.components = components;
        this.dates = dates;
        this.choice = choice;
    }

    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = ((LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.adapter_components_list, parent, false);
        ButterKnife.bind(this, v);

        name.setText(components.get(position).getName()); // The name of the component
        date.setVisibility(View.INVISIBLE);
        if (choice == 0){
            date.setVisibility(View.VISIBLE);
            available.setText("Quantity\n"+components.get(position).getQuantity()); // The availability of that component
            date.setText(dates.get(position).toString());
        } else {
            date.setVisibility(View.INVISIBLE);
            available.setText("Available\n"+components.get(position).getQuantity());
            name.setTextSize(20.0f);// The availability of that component
        }
        available.setTextColor(Color.parseColor("#ffffff"));
        return v;
    }
}
