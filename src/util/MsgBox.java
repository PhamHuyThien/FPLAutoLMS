/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class MsgBox {

    public static boolean confirm(Component c, String content) {
        return JOptionPane.showConfirmDialog(c, content) == 0;
    }

    public static boolean confirmWar(Component c, String content) {
        return JOptionPane.showConfirmDialog(c, content, "AutoLMS Warning!!!", JOptionPane.WARNING_MESSAGE) == 0;
    }

    public static boolean confirmWar(String content) {
        return JOptionPane.showConfirmDialog(null, content, "AutoLMS Warning!!!", JOptionPane.WARNING_MESSAGE) == 0;
    }

    public static boolean confirmInf(Component c, String content) {
        return JOptionPane.showConfirmDialog(c, content, "AutoLMS Infomation!!!", JOptionPane.INFORMATION_MESSAGE) == 0;
    }

    public static boolean confirmInf(String content) {
        return JOptionPane.showConfirmDialog(null, content, "AutoLMS Infomation!!!", JOptionPane.INFORMATION_MESSAGE) == 0;
    }

    public static boolean confirmErr(Component c, String content) {
        return JOptionPane.showConfirmDialog(c, content, "AutoLMS Error!!!", JOptionPane.ERROR_MESSAGE) == 0;
    }

    public static boolean confirmErr(String content) {
        return JOptionPane.showConfirmDialog(null, content, "AutoLMS Error!!!", JOptionPane.ERROR_MESSAGE) == 0;
    }

    public static void alert(Component c, String content) {
        JOptionPane.showMessageDialog(c, content);
    }

    public static void alert(String content) {
        JOptionPane.showMessageDialog(null, content);
    }

    public static void alertInf(String s) {
        JOptionPane.showMessageDialog(null, s, "AutoLMS Info!!!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void alertWar(String s) {
        JOptionPane.showMessageDialog(null, s, "AutoLMS Warning!!!", JOptionPane.WARNING_MESSAGE);
    }

    public static void alertErr(String s) {
        JOptionPane.showMessageDialog(null, s, "AutoLMS Error!!!", JOptionPane.ERROR_MESSAGE);
    }

    public static void alertInf(Component c, String s) {
        JOptionPane.showMessageDialog(c, s, "AutoLMS Info!!!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void alertWar(Component c, String s) {
        JOptionPane.showMessageDialog(c, s, "AutoLMS Warning!!!", JOptionPane.WARNING_MESSAGE);
    }

    public static void alertErr(Component c, String s) {
        JOptionPane.showMessageDialog(c, s, "AutoLMS Error!!!", JOptionPane.ERROR_MESSAGE);
    }
}
