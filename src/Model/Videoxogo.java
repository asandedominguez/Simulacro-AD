package Model;

public class Videoxogo {
    public int id;
    public String Titulo;
    public String Plataforma;
    public int AnoLanzamento;
    public String Descripcion;

    public Videoxogo(int id, String Titulo, String Plataforma, int AnoLanzamento, String Descripcion) {
        this.id = id;
        this.Titulo = Titulo;
        this.Plataforma = Plataforma;
        this.AnoLanzamento = AnoLanzamento;
        this.Descripcion = Descripcion;
    }

    public String getNome() {
        return Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getAno() {
        return AnoLanzamento;
    }

    public String getPlataforma() {
        return Plataforma;
    }

    public int getId() {
        return id;
    }
}
