package com.example.library.widget.recycleview;

import android.view.View;

public interface OnItemClickListener<T> {

    void onItemClick(View itemView, int pos, T item);

}
