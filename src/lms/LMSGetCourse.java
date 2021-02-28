/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import model.Account;
import model.Course;

/**
 *
 * @author Administrator
 */
public class LMSGetCourse {

    public static Course parse(Account account, int refIdCourse) {
        return new Course(refIdCourse);
    }
}
