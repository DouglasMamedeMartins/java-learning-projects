package revisao.revisao7;

public class Fruta {
    private String nome;
    private String cor;

    public Fruta(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String toLinhaArquivo() {
        return nome + ";" + cor;
    }

    public static Fruta fromLinhaArquivo(String linha) {
        String[] partes = linha.split(";");
        return new Fruta(partes[0], partes[1]);
    }

    @Override
    public String toString() {
        return "Fruta{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}
