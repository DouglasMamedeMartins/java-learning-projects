package revisao.revisao7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Frutas {
    public static void main(String[] args) {
        Fruta fruta1 = new Fruta("Pera", "verde");
        Fruta fruta2 = new Fruta("maça", "vermelha");
        Fruta fruta3 = new Fruta("Banana", "Amarela");

        List<Fruta> frutas = List.of(fruta1, fruta2, fruta3);


        try (FileWriter writer = new FileWriter("arquivoteste/frutas.txt", false)) {
            for (Fruta fruta : frutas) {
                writer.write(fruta.toLinhaArquivo() + "\n");
            }
            System.out.println("Arquivo criado com Sucesso!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("arquivoteste/frutas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Fruta fruta = Fruta.fromLinhaArquivo(linha);
                System.out.println("Fruta: " + fruta);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
