package com.kkangtongs.kt.adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.kkangtongs.kt.building.AiFragment;
import com.kkangtongs.kt.building.BionanoFragment;
import com.kkangtongs.kt.building.GachongwanFragment;
import com.kkangtongs.kt.building.SanhakFragment;
import com.kkangtongs.kt.building.VisionTowerFragment;

public class ContentsPagerAdapter extends FragmentStateAdapter {

    private int pageCnt = 5;

    public ContentsPagerAdapter(AppCompatActivity fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){

            case 0:
                AiFragment aiFragment = new AiFragment();
                return aiFragment;
            case 1:
                VisionTowerFragment visionTowerFragment = new VisionTowerFragment();
                return visionTowerFragment;
            case 2:
                SanhakFragment sanhakFragment = new SanhakFragment();
                return sanhakFragment;
            case 3:
                GachongwanFragment gachongwanFragment = new GachongwanFragment();
                return gachongwanFragment;
            case 4:
                BionanoFragment bionanoFragment = new BionanoFragment();
                return bionanoFragment;

            default:
                return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return pageCnt;
    }
}
