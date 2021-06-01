/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import model.Account;
import model.Course;
import util.Client;

/**
 *
 * @author Administrator
 */
public class Main {

    public static final boolean ADMIN_DEBUG_APP = false;
    //
    public static FormMain formMain;
    public static FormShow formShow;
    //
    public static Account account;
    public static Course course;
    //
    public static int idTool;

    public static void main(String[] args) {
        formMain = new FormMain();
        formMain.setVisible(true);
        if ((idTool = Client.checkApp()) == -1) {
            System.exit(0);
        }
        formMain.setAlwaysOnTop(true);
    }

    public static final String APP_NAME = "FPL@utoLMS";
    public static final String APP_VER = "1.0.7";
    public static final String APP_SLOGAN = "10 Quiz 10 Point Easy!";
    public static final String APP_AUTHOR = "ThienDZaii";
    public static final String APP_NICKNAME = "SystemError";
    public static final String APP_CONTACT = "https://fb.com/ThienDz.SystemError";
}
