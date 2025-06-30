package revisao.revisao6;

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String toLinhaArquivo() {
        return nome + ":" + matricula + ";" + curso;
    }

    public static Aluno fromLInhaArquivo(String linha) {
        String[] partes = linha.split(":");
        return new Aluno(partes[0], partes[1], partes[2]);
    }
}
