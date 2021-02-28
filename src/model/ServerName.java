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
public enum ServerName {
    HaNoi, HoChiMinh, CanTho, TayNguyen, DaNang;

    @Override
    public String toString() {
        switch (this) {
            case HaNoi:
                return "hn";
            case HoChiMinh:
                return "hcm";
            case CanTho:
            case TayNguyen:
            case DaNang:
                return "dn";
        }
        return null;
    }
}
