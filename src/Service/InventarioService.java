package Service;

import Connector.DBconnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventarioService {

    public static void insertarEntrada(String titulo, double prezoCompra, double prezoVenda, int stock) {
        String sql = "INSERT INTO InventarioTenda (videoxogo_id, prezo_compra, prezo_venda, stock) " +
                "VALUES ((SELECT id FROM Videoxogo WHERE Titulo = ?), ?, ?, ?)";

        try (Connection conn = DBconnector.conexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setDouble(2, prezoCompra);
            ps.setDouble(3, prezoVenda);
            ps.setInt(4, stock);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Inventario engadido para: " + titulo);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao insertar no inventario: " + e.getMessage());
        }
    }
}