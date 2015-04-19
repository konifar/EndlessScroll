package com.konifar.endlessscroll.sample;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class SampleModel {

  private static final int PER = 20;

  public static List<String> getSampleList(int page, Context context) {
    List<String> list = new ArrayList<>(PER);

    for (int i = 0; i < PER; i++) {
      int num = (page - 1) * PER + i + 1;
      list.add(context.getString(R.string.list_title, num));
    }

    return list;
  }
}
