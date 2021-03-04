/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public enum QuizState {
    NOT_WORKING, WORKING, FINISH_WORK, NEW_WORK;

    public int toInt() {
        switch (this) {
            case NOT_WORKING:
                return -1;
            case WORKING:
                return 0;
            case FINISH_WORK:
                return 1;
            case NEW_WORK:
                return 2;
        }
        return 1107;
    }

    @Override
    public String toString() {
        switch (this) {
            case NOT_WORKING:
                return "not_working";
            case WORKING:
                return "working";
            case FINISH_WORK:
                return "finish_work";
            case NEW_WORK:
                return "new_work";
        }
        return "";
    }
}
