package org.cqumsc.cquark;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.cqumsc.cquark.ui.Beans.lessonBeans;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class timetable extends AppCompatActivity {

    ArrayList<lessonBeans> list= new ArrayList<>();
    final int[] week = new int[1];
    public void setList (ArrayList<lessonBeans> list){
        this.list = list;
    }
    public void setWeek (int week){
        this.week[0] = week;
    }
    private int getDpi() {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int density = dm.densityDpi;
        return density;
    }
    private int generateColor(int randSeed){
        Random random = new Random();
        random.setSeed(0xFFFFFF+randSeed);
        int temp = random.nextInt(0xFFFFFF);
        int color = 0x6D000000 + temp;
        return color;
    }
    private void rmtimetable(GridLayout grid,ArrayList<lessonBeans> list){
        for (int i = 0; i < list.size(); i++) {
            grid.removeView(grid.findViewById(i));
        }
        list.clear();
    }
    private void showdetail(lessonBeans lesson,ArrayList<TextView> textViews){
        int tempend_time = lesson.getStart_time()+ lesson.getLen();
        textViews.get(0).setText("星期"+lesson.getStart_day()+"第"+lesson.getStart_time()+"-"+tempend_time);//lessonSection
        textViews.get(1).setText(lesson.getClassroom());//lessonClassroom
        textViews.get(2).setText(lesson.getLessoncode());//lessonCode
        textViews.get(3).setText(lesson.getTeacher());//lessonTeacher
        textViews.get(4).setText(lesson.getLessontime());//lessonTime
        textViews.get(5).setText(lesson.getAvailableweeks());//lessonWeek

    }
    private void showtimetable(GridLayout grid, ArrayList<lessonBeans> list, ArrayList<TextView> textViews){
        for (int i = 0; i < list.size(); i++) {
            TextView textView = new TextView(this);
            float Heightdp = 66 * list.get(i).getLen();
            float Widthdp = 55;
            int col = list.get(i).getStart_day(), row = list.get(i).getStart_time();
            int Widthpx = (int) Widthdp * getDpi() / 160;
            int Heightpx = (int) Heightdp * getDpi() / 160;
            textView.setWidth(Widthpx);
            textView.setHeight(Heightpx);
            textView.setTextSize(13);
            textView.setText(list.get(i).getClassroom() + "\n" + list.get(i).getName());
            textView.setGravity(Gravity.CENTER);
            textView.setBackgroundColor(this.generateColor(i));
            textView.setTextColor(0xFF777777);
            textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            textView.setId(i);
            lessonBeans lesson = list.get(i);
            grid.addView(textView, new GridLayout.LayoutParams(
                    GridLayout.spec(row,row+list.get(i).getLen(),GridLayout.CENTER),
                    GridLayout.spec(col, GridLayout.CENTER)));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showdetail(lesson,textViews);
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);


        TextView showweek = findViewById(R.id.showWeek);
        GridLayout grid = findViewById(R.id.grid_layout);
        Button prevWeek = findViewById(R.id.prevWeek);
        Button nextWeek = findViewById(R.id.nextWeek);
        ArrayList<TextView> textViews= new ArrayList<>();
        textViews.add(findViewById(R.id.lessonSection));
        textViews.add(findViewById(R.id.lessonClassroom));
        textViews.add(findViewById(R.id.lessonCode));
        textViews.add(findViewById(R.id.lessonTeacher));
        textViews.add(findViewById(R.id.lessonTime));
        textViews.add(findViewById(R.id.lessonWeek));
        showtimetable(grid,list,textViews);
        showweek.setText("第"+week[0]+"周");
        prevWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rmtimetable(grid,list);
                week[0] = week[0] - 1;
                //此处应该重新往arraylist中添加前一周的课表数据
                showtimetable(grid,list,textViews);
                showweek.setText("第"+week[0]+"周");
            }
        });
        nextWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rmtimetable(grid,list);
                week[0] = week[0] + 1;
                //此处应该重新往arraylist中添加后一周的课表数据
                showtimetable(grid,list,textViews);
                showweek.setText("第"+week[0]+"周");
            }
        });
    }
}