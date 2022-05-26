package com.app.kinonet.home.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.home.adapter.FoodNearByAdapter;
import com.app.kinonet.home.adapter.Food_Menu_Adapter2;
import com.app.kinonet.home.model.FoodNearByModel;

import java.util.ArrayList;
import java.util.List;


public class UserHomeFragment extends Fragment {


    private RecyclerView foodNearByList, recyclerView2, recyclerView3;
    private FoodNearByAdapter foodNearByAdapter, foodNearByAdapter2;
    private Food_Menu_Adapter2 adapter2;
    private LinearLayoutManager layoutManager1, layoutManager2, layoutManager3;
    private List<FoodNearByModel> foodList1, foodList2, foodList3;


    public UserHomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_chef_home, container, false);
        foodNearByList = view.findViewById(R.id.recyclerview2);
        recyclerView2 = view.findViewById(R.id.recyclerview1);
        recyclerView3 = view.findViewById(R.id.recyclerview3);
        foodNearByList.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setHasFixedSize(true);
        layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager3 = new LinearLayoutManager(getActivity());
        foodNearByList.setLayoutManager(layoutManager1);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView3.setLayoutManager(layoutManager3);
        foodList1 = new ArrayList<>();
        foodList2 = new ArrayList<>();
        foodList3 = new ArrayList<>();

        foodList1.add(new FoodNearByModel("Мстители Финал", "9.1", "120 мин", "Экшен", R.drawable.avenger, "843650"));
        foodList1.add(new FoodNearByModel("Доктор Стрендж 2", "7.7", "120 мин", "Ужасы", R.drawable.dr, "1219909"));
        foodList1.add(new FoodNearByModel("Человек Паук: Нет Пути Домой", "8.0", "120 мин", "Экшен", R.drawable.spd, "1309570"));
        foodList1.add(new FoodNearByModel("Дом Gucci", "7.0", "120 мин", "Биография", R.drawable.guc, "1449368"));
        foodList1.add(new FoodNearByModel("Анчартед", "6.8", "120 мин", "Приключения", R.drawable.un, "468373"));

        foodList2.add(new FoodNearByModel("Триггер", "8.5", "50 мин", "Драма", R.drawable.tr, "1"));
        foodList2.add(new FoodNearByModel("Постучись в мою дверь", "8.4", "45 мин", "Драма", R.drawable.ps, "2"));
        foodList2.add(new FoodNearByModel("Бесстыжие", "7.4", "40 мин", "Драма", R.drawable.bs, "3"));
        foodList2.add(new FoodNearByModel("Эйфория", "7.7", "55 мин", "Драма", R.drawable.eu, "4"));
        foodList2.add(new FoodNearByModel("Лунный Рыцарь", "7.3", "40 мин", "Фэнтези", R.drawable.mk, "5"));

        foodList3.add(new FoodNearByModel("Зеленая миля", "9.0", "189 мин", "Драма", R.drawable.zm, "435"));
        foodList3.add(new FoodNearByModel("Джентельмены Удачи", "8.5", "84 мин", "Комедия", R.drawable.du, "44386"));
        foodList3.add(new FoodNearByModel("Криминальное чтиво", "8.6", "154 мин", "Криминал", R.drawable.kc, "342"));
        foodList3.add(new FoodNearByModel("Ирония судьбы", "8.4", "184 мин", "Мелодрама", R.drawable.ir, "77331"));
        foodList3.add(new FoodNearByModel("Побег из Шоушенка", "9.1", "140 мин", "Драма", R.drawable.pb, "326"));


        foodNearByAdapter = new FoodNearByAdapter(foodList2, getActivity());
        foodNearByAdapter2 = new FoodNearByAdapter(foodList1, getActivity());
        adapter2 = new Food_Menu_Adapter2(foodList3, getActivity());
        foodNearByList.setAdapter(foodNearByAdapter);
        recyclerView2.setAdapter(foodNearByAdapter2);
        recyclerView3.setAdapter(adapter2);
        return view;
    }


}
