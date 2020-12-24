import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class Siscomex {
    public static void main(String[] args) throws Exception {
        List<NCM> arquivoCSV = Utils.readCSVFile("/home/gabriel/Área de Trabalho/Tabela-NCM-2020-Oobj-NCM-2020.csv");

        open("https://portalunico.siscomex.gov.br/classif/#/sumario?perfil=publico");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if($(".modal.theme-pucomex.fade.ng-scope.ng-isolate-scope.in").exists()) {
            $(".modal.theme-pucomex.fade.ng-scope.ng-isolate-scope.in").click();
        }
        WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        for (NCM item : arquivoCSV) {
            $(By.id("txtCriterio")).setValue(item.getNumeroNCM());
            $(By.id("btnPesquisa")).click();
            WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            item.setSecao($(".row.conteudo").$("p").getText().trim());

            item.setCapitulo($(".row.conteudo").$(".ng-binding.ng-scope").$("span").getText().trim());

            item.setPosicao($(".row.conteudo").$(".ng-binding.ng-scope", 1).$("span").getText().trim());

            if ($(".row.conteudo").$(".ng-binding.ng-scope", 2).$("span").exists()) {
                item.setSubposicao($(".row.conteudo").$(".ng-binding.ng-scope", 2).$("span").getText().trim());
            }

            if ($(".row.conteudo").$(".ng-binding.ng-scope", 3).$("span").exists()) {
                item.setItem($(".row.conteudo").$(".ng-binding.ng-scope", 3).$("span").getText().trim());
            }

            int i = 0;
            while($("div.ui-grid-canvas").$("div.ui-grid-row.ng-scope", i).exists()) {
                String numeroNcm = $("div.ui-grid-canvas").$("div.ui-grid-row.ng-scope", i).$("span").getText().replace(".", "");
                if (numeroNcm.equals(item.getNumeroNCM())) {
                    item.setSubitem($("div.ui-grid-canvas").$("div.ui-grid-row.ng-scope", i).$("span", 1).getText().trim());
                    break;
                }
                i++;
            }
            WebDriverRunner.getWebDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        }
    }
}
