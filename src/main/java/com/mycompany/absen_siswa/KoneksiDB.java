/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.absen_siswa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author muhro
 */
public class KoneksiDB {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_absensi";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            System.out.println("Koneksi ke database berhasil");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC tidak ditemukan");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal");
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
   
