package programa;

public class Arma {
	protected String modelo;
	protected String marca;
	protected String municao;
	protected String calibre;
	protected String composicao;
	protected String numregistro;
	public Arma(String modelo, String marca, String municao, String calibre, String composicao, String numregistro) {
		
		this.modelo = modelo;
		this.marca = marca;
		this.municao = municao;
		this.calibre = calibre;
		this.composicao = composicao;
		this.numregistro = numregistro;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getMunicao() {
		return municao;
	}
	public void setMunicao(String municao) {
		this.municao = municao;
	}
	public String getCalibre() {
		return calibre;
	}
	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
	public String getComposicao() {
		return composicao;
	}
	public void setComposicao(String composicao) {
		this.composicao = composicao;
	}
	public String getNumregistro() {
		return numregistro;
	}
	public void setNumregistro(String numregistro) {
		this.numregistro = numregistro;
	}
	public void  info() {
		System.out.println("O nome do livro é :" + this.getModelo());
		System.out.println("O autor é :" + this.getMarca());
		System.out.println("O Preço é :" + this.getMunicao());
		System.out.println("O número de paginas é :" + this.getCalibre());
		System.out.println("A editora é :" + this.getComposicao());
		System.out.println("aaaa: " + this.getNumregistro());
		System.out.println("##########################################");
	}
	
}
