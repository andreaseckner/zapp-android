package com.example.othregensburg.zapp.music.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.othregensburg.zapp.R;
import com.example.othregensburg.zapp.music.controller.AlbumAdapter;
import com.example.othregensburg.zapp.music.model.DsAlbum;
import com.example.othregensburg.zapp.utils.Args;

import java.util.ArrayList;


public class MyMusicFragment extends Fragment {

    private ArrayList<Object> mContent;
    private AlbumAdapter mAlbumAdapter;

    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;

    public static MyMusicFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString(Args.TOOLBAR_TITLE, title);
        MyMusicFragment fragment = new MyMusicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /*
     * Lifecycle methods
     */

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_music, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    /*
     * Private methods
     */

    private void init() {
        mContent = new ArrayList<>();
        setupUiComponents();
        setupToolbar();
        setupRecyclerView();
        loadContent();
    }

    @SuppressWarnings("ConstantConditions")
    private void setupUiComponents() {
        mProgressBar = (ProgressBar) getView().findViewById(R.id.fragment_my_music_progress_bar);
        mRecyclerView = (RecyclerView) getView().findViewById(R.id.fragment_my_music_recycler_view);
    }

    /**
     * Set the passed title for the toolbar
     */
    private void setupToolbar() {
        String title = getArguments().getString(Args.TOOLBAR_TITLE);
        // We have a Toolbar in place so we don't need to care about the NPE warning
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAlbumAdapter = new AlbumAdapter(getActivity(), mContent);
        mRecyclerView.setAdapter(mAlbumAdapter);
    }

    // Mockup method - usually you would fetch the data from the internet for example
    private void loadContent() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                generateDummyData();
                generatePalette();
                showContentWithDelay(1000);
            }
        }, 1000);
    }

    private void generateDummyData() {
        // dummy object to show header - see AlbumAdapter#getViewType
        mContent.add(new Object());

        // dummy album data
        DsAlbum dsAlbumSupermodel = new DsAlbum("Supermodel", "Foster the People", R.drawable.cover_foster_the_people);
        DsAlbum dsAlbumHalcyonDays = new DsAlbum("Halcyon Days", "Ellie Goulding", R.drawable.cover_ellie_goulding);
        DsAlbum dsAlbumTheTruthAboutLove = new DsAlbum("The Truth About Love", "P!nk", R.drawable.cover_truth_about_love);
        mContent.add(dsAlbumSupermodel);
        mContent.add(dsAlbumHalcyonDays);
        mContent.add(dsAlbumTheTruthAboutLove);
    }

    /**
     * Gets the dominant color for each Bitmap
     */
    private void generatePalette() {
        final int defaultColor = 0x000000;
        for (Object o : mContent) {
            if (o instanceof DsAlbum) {
                final DsAlbum album = (DsAlbum) o;
                Bitmap bmp = BitmapFactory.decodeResource(getResources(), album.getResIdImage());
                if (bmp != null && !bmp.isRecycled()) {
                    Palette.from(bmp).generate(new Palette.PaletteAsyncListener() {
                        @Override
                        public void onGenerated(Palette palette) {
                            album.setBackgroundColor(palette.getDarkVibrantColor(defaultColor));
                        }
                    });
                }
            }
        }
    }

    /*
     * NOTE: Palette is created asynchronously so we can't be sure that that we have all colors
     * in place once the delayed action is called. For demo purpose this is OK - in production you
     * should go for a different solution.
     */
    private void showContentWithDelay(long delay){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showContent();
            }
        }, delay);
    }

    private void showContent() {
        hideProgressBar();
        addContentToRecyclerView();
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void addContentToRecyclerView() {
        // Notify the RecyclerView that items have been added
        mAlbumAdapter.notifyItemRangeChanged(0, mContent.size());
    }

}
