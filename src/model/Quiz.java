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
public class Quiz implements Comparable<Quiz> {

    private int id;
    private String name;
    private boolean automationSupport;
    private QuizState quizState;
    private AnswerBase[] answerBases;

    public Quiz() {
    }

    public Quiz(int id) {
        this.id = id;
    }

    public Quiz(int id, String name, QuizState quizState, AnswerBase[] answerBases) {
        this.id = id;
        this.name = name;
        this.quizState = quizState;
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

    public boolean isAutomationSupport() {
        return automationSupport;
    }

    public void setAutomationSupport(boolean automationSupport) {
        this.automationSupport = automationSupport;
    }

    public QuizState getQuizState() {
        return quizState;
    }

    public void setQuizState(QuizState quizState) {
        this.quizState = quizState;
    }

    public AnswerBase[] getAnswerBases() {
        return answerBases;
    }

    public void setAnswerBases(AnswerBase[] answerBases) {
        this.answerBases = answerBases;
    }

    @Override
    public String toString() {
        return "Quiz{" + "id=" + id + ", name=" + name + ", quizState=" + quizState.toString() + ", answerBases=" + Arrays.toString(answerBases) + '}';
    }

    @Override
    public int compareTo(Quiz o) {
        if (o == null) {
            return 1;
        }
        return this.getId() - o.getId();
    }

}
