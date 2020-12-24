import com.opencsv.bean.CsvBindByName;

public final class NCM {
    @CsvBindByName(column = "ncm")
    final private String NCM;

    @CsvBindByName(column = "secao")
    private String secao;

    @CsvBindByName(column = "capitulo")
    private String capitulo;

    @CsvBindByName(column = "posicao")
    private String posicao;

    @CsvBindByName(column = "subposicao")
    private String subposicao;

    @CsvBindByName(column = "item")
    private String item;

    @CsvBindByName(column = "subitem")
    private String subitem;

    public NCM(String ncm) {
        this.NCM = ncm;
    }

    @Override
    public String toString() {
        return NCM;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public void setCapitulo(String capitulo) {
        this.capitulo = capitulo;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public void setSubposicao(String subposicao) {
        this.subposicao = subposicao;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setSubitem(String subitem) {
        this.subitem = subitem;
    }

    public String getNumeroNCM() {
        return NCM;
    }

    public String getCapitulo() {
        return NCM.substring(0, 2);
    }

    public String getPosicao() {
        return NCM.substring(2, 4);
    }

    public String getSubPosicao() {
        return NCM.substring(4, 6);
    }

    public String getItem() {
        return NCM.substring(6, 7);
    }

    public String getSubItem() {
        return NCM.substring(7, 8);
    }
}
