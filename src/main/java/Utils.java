import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<NCM> readCSVFile(String path) throws Exception {
        List<NCM> listaNCM = new ArrayList<>();

        FileReader reader = new FileReader(path);
        CSVReader csvReader = new CSVReader(reader);

        List<String[]> linhas = csvReader.readAll();
        linhas.remove(0); // Remove o primeiro item referente ao cabeçalho do arquivo CSV.

        linhas.forEach(linha -> {
            listaNCM.add(new NCM(linha[0]));
        });

        reader.close();
        csvReader.close();

        return listaNCM;
    }

}
