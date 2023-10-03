// Generated by view binder compiler. Do not edit!
package com.example.mynewsapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.example.mynewsapp.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class NavheaderBinding implements ViewBinding {
  @NonNull
  private final LinearLayoutCompat rootView;

  private NavheaderBinding(@NonNull LinearLayoutCompat rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public LinearLayoutCompat getRoot() {
    return rootView;
  }

  @NonNull
  public static NavheaderBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static NavheaderBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.navheader, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static NavheaderBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new NavheaderBinding((LinearLayoutCompat) rootView);
  }
}
