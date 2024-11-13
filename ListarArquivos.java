import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ListarArquivos {
    public static void main(String[] args) {
        String caminhoDiretorio = "/mnt/d/Nova pasta";
        File diretorio = new File(caminhoDiretorio);

        if (diretorio.exists() && diretorio.isDirectory()) {
            File[] arquivos = diretorio.listFiles();
            if (arquivos != null) {
                Arrays.sort(arquivos, (a, b) -> Long.compare(b.lastModified(), a.lastModified()));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                for (File arquivo : arquivos) {
                    if (arquivo.isFile()) {
                        String dataModificacao = sdf.format(arquivo.lastModified());
                        System.out.println("Arquivo: " + arquivo.getName() + ", Data de Modificação: " + dataModificacao);
                    }
                }
            }
        } else {
            System.out.println("O diretório especificado não existe ou não é um diretório.");
        }
    }
}
