package com.konifar.endlessscroll;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import java.util.List;

public class MainActivity extends FragmentActivity {

  private SampleListAdapter adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initToolbar();
    initListView();
  }

  private void initToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    toolbar.setTitle(R.string.app_name);
  }

  private void initListView() {
    adapter = new SampleListAdapter(this);
    ListView listView = (ListView) findViewById(R.id.list_view);
    listView.setAdapter(adapter);
    loadData(1);
  }

  private void loadData(int page) {
    List<String> samples = SampleModel.getSampleList(page, this);
    adapter.addAll(samples);
  }
}
