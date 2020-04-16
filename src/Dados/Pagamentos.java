/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

/**
 *
 * @author 277700
 */
public class Pagamentos {

    private int Cod_Pagamento;
    private String Tipo_Pagamento;
    private String Situacao_Cliente;
    private Double Valor_Pagamento;
    
    public int getCod_Pagamento() {
        return Cod_Pagamento;
    }

    public void setCod_Pagamento(int Cod_Pagamento) {
        this.Cod_Pagamento = Cod_Pagamento;
    }

    public String getTipo_Pagamento() {
        return Tipo_Pagamento;
    }

    public void setTipo_Pagamento(String Tipo_Pagamento) {
        this.Tipo_Pagamento = Tipo_Pagamento;
    }

    public String getSituacao_Cliente() {
        return Situacao_Cliente;
    }

    public void setSituacao_Cliente(String Situacao_Cliente) {
        this.Situacao_Cliente = Situacao_Cliente;
    }

    public Double getValor_Pagamento() {
        return Valor_Pagamento;
    }

    public void setValor_Pagamento(Double Valor_Pagamento) {
        this.Valor_Pagamento = Valor_Pagamento;
    }
    
    
}
