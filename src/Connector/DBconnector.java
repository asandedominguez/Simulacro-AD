package Connector;

import Model.Videoxogo;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnector {
    public static Connection conexion() {
        String url = "jdbc:postgresql://10.0.9.226:5432/probas";
        String usuario = "postgres";
        String contrasena = "admin";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, usuario, contrasena);
            if (conn != null) {
                System.out.println("Conexión establecida con exito");
            }
        } catch (Exception e) {
            System.out.println("Erro na conexión: " + e.getMessage());
        }
        return conn;
    }

    public static void XML(Videoxogo videoxogo) {
        try {
            XMLOutputFactory XOF = XMLOutputFactory.newInstance();
            XMLStreamWriter XSW = XOF.createXMLStreamWriter(new FileOutputStream("documento"), "UTF-8");

            XSW.writeStartDocument("1.0");
            XSW.writeStartElement("Videoxogos");
            XSW.writeStartElement("Videoxogo");

            XSW.writeStartElement("id");
            XSW.writeCharacters(String.valueOf(videoxogo.getId()));
            XSW.writeEndElement();

            XSW.writeStartElement("Titulo");
            XSW.writeCharacters(videoxogo.getNome() != null ? videoxogo.getNome() : "");
            XSW.writeEndElement();

            XSW.writeStartElement("Descripcion");
            XSW.writeCharacters(videoxogo.getDescripcion() != null ? videoxogo.getDescripcion() : "");
            XSW.writeEndElement();

            XSW.writeStartElement("AnoLanzamento");
            XSW.writeCharacters(String.valueOf(videoxogo.getAno()));
            XSW.writeEndElement();

            XSW.writeStartElement("Plataforma");
            XSW.writeCharacters(videoxogo.getPlataforma() != null ? videoxogo.getPlataforma() : "");
            XSW.writeEndElement();

            XSW.writeEndElement();
            XSW.writeEndElement();
            XSW.writeEndDocument();

            XSW.flush();
            XSW.close();
        }
        catch (XMLStreamException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

