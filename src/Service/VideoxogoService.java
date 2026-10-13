package Service;

import Connector.DBconnector;
import Model.Videoxogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Videoxogo;

public class VideoxogoService {
    public static void insertar(Videoxogo videoxogo) {
        String sql = "INSERT INTO Videoxogo (id, Titulo, Descripcion, AnoLanzamento, Plataforma) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBconnector.conexion();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, videoxogo.getNome());
            ps.setString(2, videoxogo.getDescripcion());
            ps.setInt(3, videoxogo.getAno());
            ps.setString(4, videoxogo.getPlataforma());
            System.out.println("Videoxogos añadidos con exito");

            ps.executeUpdate();

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void leer_id(Videoxogo videoxogo) {
        String sql = "SELECT * FROM Videoxogo WHERE id = ?";
        try (Connection conn = DBconnector.conexion();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, videoxogo.getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getInt("id"));
                    System.out.println(rs.getString("Titulo"));
                    System.out.println(rs.getString("Plataforma"));
                    System.out.println(rs.getInt("AnoLanzamento"));
                    System.out.println(rs.getString("Descripcion"));
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertar2(Videoxogo videoxogo) {

    }
}
