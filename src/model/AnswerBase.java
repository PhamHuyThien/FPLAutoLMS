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
public class AnswerBase implements Comparable<AnswerBase> {

    private int id;
    private String question;
    private String[] answerTexts;
    private int[] bestSolutionIds;

    public AnswerBase() {
    }

    public AnswerBase(int id) {
        this.id = id;
    }

    public AnswerBase(int id, String question, String[] answerTexts, int[] bestSolutionIds) {
        this.id = id;
        this.question = question;
        this.answerTexts = answerTexts;
        this.bestSolutionIds = bestSolutionIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswerTexts() {
        return answerTexts;
    }

    public void setAnswerTexts(String[] answerTexts) {
        this.answerTexts = answerTexts;
    }

    public int[] getBestSolutionIds() {
        return bestSolutionIds;
    }

    public void setBestSolutionIds(int[] bestSolutionIds) {
        this.bestSolutionIds = bestSolutionIds;
    }

    @Override
    public String toString() {
        return "AnswerBase{" + "id=" + id + ", question=" + question + ", answerTexts=" + Arrays.toString(answerTexts) + ", bestSolutionIds=" + Arrays.toString(bestSolutionIds) + '}';
    }
    
    @Override
    public int compareTo(AnswerBase o) {
        if (o == null) {
            return 1;
        }
        return this.getId() - o.getId();
    }

}
