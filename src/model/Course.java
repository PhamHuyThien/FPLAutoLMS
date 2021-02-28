/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class Course {
    private int id;
    private String name;
    private int activeId;
    private Quiz[] quizs;

    public Course() {
    }

    public Course(int id) {
        this.id = id;
    }

    public Course(int id, String name, int activeId, Quiz[] quizs) {
        this.id = id;
        this.name = name;
        this.activeId = activeId;
        this.quizs = quizs;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActiveId() {
        return activeId;
    }

    public void setActiveId(int activeId) {
        this.activeId = activeId;
    }

    public Quiz[] getQuizs() {
        return quizs;
    }

    public void setQuizs(Quiz[] quizs) {
        this.quizs = quizs;
    }

    @Override
    public String toString() {
        return "Course{" + "id=" + id + ", name=" + name + ", activeId=" + activeId + ", quizs=" + quizs + '}';
    }





    
}
