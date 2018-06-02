import java.util.Date;

public class Municipe implements Comparable<Municipe>{

    private String autarquia;
    private Date timeStamp;
    private String codigoPeriodo;
    private Double derramaIRC ;
    private Double financiamentoUE;
    private Double imi;
    private Double impostosMunicipais;
    private Double imt;
    private Double iuc;
    private Double outrasReceitas;
    private Double receitasTotais;
    private Double taxasMultasOutrosImpostos;
    private Double transferenciasOrcamentoEstado;
    private Double vendaBensServiços;


    public String getAutarquia() {
        return autarquia;
    }

    public void setAutarquia(String autarquia) {
        this.autarquia = autarquia;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public Double getDerramaIRC() {
        return derramaIRC;
    }

    public void setDerramaIRC(Double derramaIRC) {
        this.derramaIRC = derramaIRC;
    }

    public Double getFinanciamentoUE() {
        return financiamentoUE;
    }

    public void setFinanciamentoUE(Double financiamentoUE) {
        this.financiamentoUE = financiamentoUE;
    }

    public Double getImi() {
        return imi;
    }

    public void setImi(Double imi) {
        this.imi = imi;
    }

    public Double getImpostosMunicipais() {
        return impostosMunicipais;
    }

    public void setImpostosMunicipais(Double impostosMunicipais) {
        this.impostosMunicipais = impostosMunicipais;
    }

    public Double getImt() {
        return imt;
    }

    public void setImt(Double imt) {
        this.imt = imt;
    }

    public Double getIuc() {
        return iuc;
    }

    public void setIuc(Double iuc) {
        this.iuc = iuc;
    }

    public Double getOutrasReceitas() {
        return outrasReceitas;
    }

    public void setOutrasReceitas(Double outrasReceitas) {
        this.outrasReceitas = outrasReceitas;
    }

    public Double getReceitasTotais() {
        return receitasTotais;
    }

    public void setReceitasTotais(Double receitasTotais) {
        this.receitasTotais = receitasTotais;
    }

    public Double getTaxasMultasOutrosImpostos() {
        return taxasMultasOutrosImpostos;
    }

    public void setTaxasMultasOutrosImpostos(Double taxasMultasOutrosImpostos) {
        this.taxasMultasOutrosImpostos = taxasMultasOutrosImpostos;
    }

    public Double getTransferenciasOrcamentoEstado() {
        return transferenciasOrcamentoEstado;
    }

    public void setTransferenciasOrcamentoEstado(Double transferenciasOrcamentoEstado) {
        this.transferenciasOrcamentoEstado = transferenciasOrcamentoEstado;
    }

    public Double getVendaBensServiços() {
        return vendaBensServiços;
    }

    public void setVendaBensServiços(Double vendaBensServiços) {
        this.vendaBensServiços = vendaBensServiços;
    }

    @Override
    public int compareTo(Municipe municipe) {

        return this.getAutarquia().compareTo(municipe.getAutarquia());

    }
}
