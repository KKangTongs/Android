package com.example.kkangtongs.main;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.example.kkangtongs.R;
import com.google.android.material.snackbar.Snackbar;

public class MyPageFragment extends Fragment {

    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mypage, container, false);

        // 1. 즐겨찾기 편집
        Button editFavoritesButton = (Button) rootView.findViewById(R.id.editFavoritesButton);
        editFavoritesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Snackbar.make(v, "준비중인 기능입니다!\n빠른 시일 내로 업데이트 하겠습니다 :)", Snackbar.LENGTH_LONG).show();

            }
        });

        // 2. 건물 순서 편집
        Button editBuildingOrderButton = (Button) rootView.findViewById(R.id.editBuildingOrderButton);
        editBuildingOrderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Snackbar.make(v, "준비중인 기능입니다!\n빠른 시일 내로 업데이트 하겠습니다 :)", Snackbar.LENGTH_LONG).show();

            }
        });

        // 3. 다크 모드
        sharedPreferences = getActivity().getSharedPreferences("appPreferences", Context.MODE_PRIVATE);
        Button myPageDarkModeButton = rootView.findViewById(R.id.myPageDarkModeButton);
        myPageDarkModeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("다크 모드");

                // add a radio button list
                final String[] options = {"시스템 테마 적용", "다크 모드", "라이트 모드"};
                int checkedItem = sharedPreferences.getInt("checkedItem", 0); // Get saved item index
                builder.setSingleChoiceItems(options, checkedItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user checked an item
                        // Save the selected item's index
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putInt("checkedItem", which);
                        editor.apply();
                    }
                });

                // add OK and Cancel buttons
                builder.setPositiveButton("적용", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // user clicked OK
                        int savedOption = sharedPreferences.getInt("checkedItem", 0);
                        switch (savedOption) {
                            case 0:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                                break;
                            case 1:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                break;
                            case 2:
                                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                                break;
                        }
                    }
                });
                builder.setNegativeButton("취소", null);

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        // 4. 알림설정
        Button notificationSettingButton = (Button) rootView.findViewById(R.id.notificationSettingButton);
        notificationSettingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Snackbar.make(v, "준비중인 기능입니다!\n빠른 시일 내로 업데이트 하겠습니다 :)", Snackbar.LENGTH_LONG).show();

            }
        });

        // 5. 앱 버전
        Button myPageAppVersion1 = (Button) rootView.findViewById(R.id.myPageAppVersion1);
        myPageAppVersion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appVersionIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/taeyeop303/223112736290"));
                startActivity(appVersionIntent);
            }
        });
        Button myPageAppVersion2 = (Button) rootView.findViewById(R.id.myPageAppVersion2);
        myPageAppVersion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appVersionIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/taeyeop303/223112736290"));
                startActivity(appVersionIntent);
            }
        });

        // 6. 공지사항
        Button myPageAnnouncementButton = (Button) rootView.findViewById(R.id.myPageAnnouncementButton);
        myPageAnnouncementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent appVersionIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://blog.naver.com/taeyeop303/223112740293"));
                startActivity(appVersionIntent);
            }
        });

        // 7. 오픈소스 라이선스
        Button myPageOpenSourceButton = (Button) rootView.findViewById(R.id.myPageOpenSourceButton);
        myPageOpenSourceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Snackbar.make(v, "We didn't use any open-source software.\nWe made it all ourselves ;)", Snackbar.LENGTH_LONG).show();

            }
        });

        // 8. 문의하기
        Button myPageSupportEmailButton = (Button) rootView.findViewById(R.id.myPageSupportEmailButton);
        myPageSupportEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"taeyeop303@gachon.ac.kr"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "[문의] 가천대 빈 강의실 ver 1.0.0");
                startActivity(emailIntent);
            }
        });

        // 9. 오류 제보
        Button myPageErrorEmailButton = (Button) rootView.findViewById(R.id.myPageErrorEmailButton);
        myPageErrorEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get device information
                String manufacturer = android.os.Build.MANUFACTURER;
                String model = android.os.Build.MODEL;
                String version = android.os.Build.VERSION.RELEASE;
                int sdkVersion = android.os.Build.VERSION.SDK_INT;

                // Construct the email body
                String emailBody = "[Device Information] \n" +
                        "Manufacturer: " + manufacturer + "\n" +
                        "Model: " + model + "\n" +
                        "Android Version: " + version + "\n" +
                        "Android SDK Version: " + sdkVersion +"\n\n" +
                        "[오류 내용]\n";

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"taeyeop303@gachon.ac.kr"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "[오류 제보] 가천대 빈 강의실 ver 1.0.0");
                emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);
                startActivity(emailIntent);
            }
        });
        return rootView;
    }
}
