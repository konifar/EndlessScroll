package com.konifar.endlessscroll.sample;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class SampleListAdapter<String> extends ArrayAdapter<String> {

  public SampleListAdapter(Context context) {
    super(context, R.layout.item_sample);
  }

  @Override
  public View getView(int pos, View view, ViewGroup parent) {
    ViewHolder holder;

    if (view == null) {
      view = LayoutInflater.from(getContext()).inflate(R.layout.item_sample, parent, false);
      holder = new ViewHolder(view);
      view.setTag(holder);
    } else {
      holder = (ViewHolder) view.getTag();
    }

    holder.textTitle.setText(getItem(pos) + "");

    return view;
  }

  public void addAll(List<String> items) {
    if (items == null) return;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
      super.addAll(items);
    } else {
      for (String item : items) {
        super.add(item);
      }
    }
  }

  static class ViewHolder {
    TextView textTitle;

    ViewHolder(View view) {
      this.textTitle = (TextView) view.findViewById(R.id.text_title);
    }
  }
}
