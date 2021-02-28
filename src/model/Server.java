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
public class Server {

    private static final String URL_BASE_SERVER = "http://%s-lms.poly.edu.vn";
    private final String urlServer;

    public Server(ServerName serverName) {
        this.urlServer = String.format(URL_BASE_SERVER, serverName.toString());
    }

    public String parseURL() {
        return urlServer;
    }

    @Override
    public String toString() {
        return "Server{" + "urlServer=" + urlServer + '}';
    }

}
