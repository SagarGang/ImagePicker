package com.nj.imagepickerlib;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nj.imagepicker.ImagePicker;
import com.nj.imagepicker.listener.ImageResultListener;
import com.nj.imagepicker.result.ImageResult;
import com.nj.imagepicker.utils.DialogConfiguration;


/**
 * A simple {@link Fragment} subclass.
 */
public class ImageOptionFromFragment extends Fragment {


    private ImageView ivImage;

    public ImageOptionFromFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_option_from, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ivImage = (ImageView) view.findViewById(R.id.iv_image);
        view.findViewById(R.id.button_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    public void show() {
        ImagePicker.build(new DialogConfiguration()
                .setTitle("Choose")
                .setOptionOrientation(LinearLayoutCompat.HORIZONTAL), new ImageResultListener() {
            @Override
            public void onImageResult(ImageResult imageResult) {
                ivImage.setImageBitmap(imageResult.getBitmap());
            }
        }).show(getChildFragmentManager());
    }


}
