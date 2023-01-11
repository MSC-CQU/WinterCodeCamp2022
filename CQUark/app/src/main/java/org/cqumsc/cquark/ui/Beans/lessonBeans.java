package org.cqumsc.cquark.ui.Beans;

import java.util.Random;

public class lessonBeans {
    String name;//课程名字
    String classroom;//该课程教室代号
    String teacher;//任课教师
    String availableweeks;//课程在何周开放(最好以(第x~x周,第x~x周...)的格式)
    String lessoncode;//课程编号
    String lessontime;//课程时间(最好以(HH:MM~HH:MM的格式))
    int start_day;//课程在第几天就是几,如周一就是1
    int start_time;//课程第几节课开始就是几,如在第一节开始就是1
    int len;//课程长度是几就是几,如高等数学长度是两节课,该值为2

    public lessonBeans(String name, String classroom, String teacher, String availableweeks, String lessoncode, String lessontime, int start_day, int start_time, int len) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.availableweeks = availableweeks;
        this.lessoncode = lessoncode;
        this.lessontime = lessontime;
        this.start_day = start_day;
        this.start_time = start_time;
        this.len = len;
    }

    public String getName() {
        return name;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getAvailableweeks() {
        return availableweeks;
    }

    public String getLessoncode() {
        return lessoncode;
    }

    public String getLessontime() {
        return lessontime;
    }

    public int getStart_day() {
        return start_day;
    }

    public int getStart_time() {
        return start_time;
    }

    public int getLen() {
        return len;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setAvailableweeks(String availableweeks) {
        this.availableweeks = availableweeks;
    }

    public void setLessoncode(String lessoncode) {
        this.lessoncode = lessoncode;
    }

    public void setLessontime(String lessontime) {
        this.lessontime = lessontime;
    }

    public void setStart_day(int start_day) {
        this.start_day = start_day;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public void setLen(int len) {
        this.len = len;
    }




}
