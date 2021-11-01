package com.kelompoktiga.tugaspertemuantiga;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

  // initialized variable
  MeowBottomNavigation bottomNavigation;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bottomNavigation = findViewById(R.id.bottom_navigation);
    bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_file_copy));
    bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_home));
    bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_folder));

    bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
      @Override
      public void onShowItem(MeowBottomNavigation.Model item) {
        Fragment fragment = null;
        switch(item.getId()) {
          case 1:
            fragment = new SemuaDataFragment();
            break;
          case 2:
            fragment = new HomeFragment();
            break;
          case 3:
              fragment = new DataGolonganFragment();
              break;
        }
        loadFragment(fragment);
      }
    });
    bottomNavigation.setCount(1, "10");
    bottomNavigation.show(2, true);
    bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
      @Override
      public void onClickItem(MeowBottomNavigation.Model item) {
        Toast.makeText(getApplicationContext(), "Anda Menekan " + item.getId(), Toast.LENGTH_SHORT).show();
      }
    });
    bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
      @Override
      public void onReselectItem(MeowBottomNavigation.Model item) {
        Toast.makeText(getApplicationContext(), "Anda Memilih Kembali " + item.getId(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void loadFragment(Fragment fragment) {
    getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.frame_layout, fragment)
        .commit();
  }
}