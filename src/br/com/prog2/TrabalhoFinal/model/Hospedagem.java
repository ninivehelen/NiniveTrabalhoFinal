package br.com.prog2.TrabalhoFinal.model;

public class Hospedagem {
	private int codHospedagem;
	private int codChale;
	private String estado;
	private String dataInicio;
	private String dataFim;
	private Integer QuntiPessoas;
	private Integer desconto;
	private Double  valorFinal;
	
	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public int getCodChale() {
		return codChale;
	}

	public void setCodChale(int codChale) {
		this.codChale = codChale;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getQuntiPessoas() {
		return QuntiPessoas;
	}

	public void setQuntiPessoas(Integer quntiPessoas) {
		QuntiPessoas = quntiPessoas;
	}

	public Integer getDesconto() {
		return desconto;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	public Double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(Double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public Hospedagem(){}
	//get/set

}
