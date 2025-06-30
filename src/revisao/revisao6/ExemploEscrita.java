package revisao.revisao6;

import java.io.FileWriter;
import java.io.IOException;

public class ExemploEscrita {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("alunos.txt", true);
            writer.write("Douglas Mamede;202012053456; ADS\n");
            writer.close();
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
