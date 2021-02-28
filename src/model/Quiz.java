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
public class Quiz {
    private int id;
    private String name;
    private AnswerBase[] answerBases;

    public Quiz() {
    }

    public Quiz(int id) {
        this.id = id;
    }

    public Quiz(int id, String name, AnswerBase[] answerBases) {
        this.id = id;
        this.name = name;
        this.answerBases = answerBases;
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

    public AnswerBase[] getAnswerBases() {
        return answerBases;
    }

    public void setAnswerBases(AnswerBase[] answerBases) {
        this.answerBases = answerBases;
    }

    @Override
    public String toString() {
        return "Quiz{" + "id=" + id + ", name=" + name + ", answerBases=" + Arrays.toString(answerBases) + '}';
    }
    
}
