import Connector.DBconnector;
import Model.Videoxogo;
import Service.VideoxogoService;

public class main {
    public static void main(String[] args) {
        DBconnector.conexion();

        Videoxogo videoxogo = new Videoxogo(1,"The Legend of Zelda: Ocarina of Time", "Nintendo 64", 1998, "Clásico xogo de aventura e acción 3D en Hyrule");
        VideoxogoService.insertar(videoxogo);
        Videoxogo videoxogo2 = new Videoxogo(2,"Elden Ring", "(Multiplataforma,", 2022, "RPG de acción desafiante nun mundo de fantasía escura");
        VideoxogoService.insertar(videoxogo2);
        Videoxogo videoxogo3 = new Videoxogo(3,"The Witcher 3: Wild Hunt", "(Multiplataforma,", 2015, "RPG de fantasía seguindo as aventuras do bruxo Geralt");
        VideoxogoService.insertar(videoxogo3);
        Videoxogo videoxogo4 = new Videoxogo(4,"Bloodborne", "(PlayStation 4,", 2015, "RPG de acción e terror gótico ambientado na cidade de Yharnam");
        VideoxogoService.insertar(videoxogo4);
        Videoxogo videoxogo5 = new Videoxogo(5,"Super Mario Odyssey", "(Nintendo Switch,", 2017, "Plataformas 3D con mecánicas de posesión de obxectos");
        VideoxogoService.insertar(videoxogo5);
    }
}
