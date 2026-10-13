package Service;

import Connector.DBconnector;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExportadorService {

    public static void exportarTexto(String nomeFicheiro) {
        String sql = "SELECT * FROM Videoxogo";

        try (Connection conn = DBconnector.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             BufferedWriter bw = new BufferedWriter(new FileWriter(nomeFicheiro))) {

            while (rs.next()) {
                String liña = String.format("%d;%s;%s;%d;%s",
                        rs.getInt("id"),
                        rs.getString("Titulo"),
                        rs.getString("Descripcion"),
                        rs.getInt("AnoLanzamento"),
                        rs.getString("Plataforma")
                );
                bw.write(liña);
                bw.newLine();
            }

        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void exportarXML(String nomeFicheiro) {
        String sql = "SELECT * FROM Videoxogo";

        try (Connection conn = DBconnector.conexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(nomeFicheiro), "UTF-8");

            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("Videoxogos");

            while (rs.next()) {
                writer.writeStartElement("Videoxogo");

                writer.writeStartElement("id");
                writer.writeCharacters(String.valueOf(rs.getInt("id")));
                writer.writeEndElement();

                writer.writeStartElement("Titulo");
                writer.writeCharacters(rs.getString("Titulo") != null ? rs.getString("Titulo") : "");
                writer.writeEndElement();

                writer.writeStartElement("Descripcion");
                writer.writeCharacters(rs.getString("Descripcion") != null ? rs.getString("Descripcion") : "");
                writer.writeEndElement();

                writer.writeStartElement("AnoLanzamento");
                writer.writeCharacters(String.valueOf(rs.getInt("AnoLanzamento")));
                writer.writeEndElement();

                writer.writeStartElement("Plataforma");
                writer.writeCharacters(rs.getString("Plataforma") != null ? rs.getString("Plataforma") : "");
                writer.writeEndElement();

                writer.writeEndElement();
            }

            writer.writeEndElement();
            writer.writeEndDocument();

            writer.flush();
            writer.close();

        } catch (SQLException | XMLStreamException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}