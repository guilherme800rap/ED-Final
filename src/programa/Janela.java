package programa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Janela extends JFrame{
	private JLabel lblModelo, lblMunicao, lblCalibre, lblMarca, lblComposicao , lblNumRegistro;
	private JTextField txtModelo, txtMunicao, txtCalibre,  txtComposicao,txtNumRegistro;
	private JComboBox<String> cmbMarca;
	private JButton btnSalvar, btnListar, btnRemover;
	
	//Necess�rios para criar uma tabela
	private JScrollPane scroll;
	private JTable tabela;
	private DefaultTableModel dadosTabela;
	
	
	private ArrayList<Arma> ListaArmas;
	
	
	
	//Construtor
	public Janela(ArrayList<Arma> lista) {
		
		//Recebendo a lista de livros, que est� na classe Principal
		ListaArmas = lista;
		
		
		//Definiar algumas op��es da janela
		setTitle("Arsenal : Armas"); //NOME DA JANELA
		setSize(800,500); //TAMANHO, LARGURA, ALTURA
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null); //sem layout autom�tico
		
		
		
		criaComponentes();
		criaAcoes();
		
		//ULTIMA COISA DENTRO DO CONSTRUTOR
		setVisible(true); //EXIBIR A JANELA
	}
	private void criaComponentes() {
		// NOME
		
		lblModelo = new JLabel ("Modelo");
		lblModelo.setBounds(10, 10, 100, 25);
		add(lblModelo);
		
		txtModelo= new JTextField();
		txtModelo.setBounds(10, 35, 150, 25);
		add(txtModelo);
		
		
		lblMarca = new JLabel ("Marca");
		lblMarca.setBounds(10, 60, 100, 25);
		add(lblMarca);
		
		cmbMarca = new JComboBox();
		cmbMarca.setBounds(10, 80, 150, 25);
		cmbMarca.addItem("Benelli");
		cmbMarca.addItem("Beretta");
		cmbMarca.addItem("Bersa");
		cmbMarca.addItem("Boito");
		cmbMarca.addItem("Browning");
		cmbMarca.addItem("CBC");
		cmbMarca.addItem("Colt");
		cmbMarca.addItem("CZ");
		cmbMarca.addItem("FAMAE");
		cmbMarca.addItem("FN");
		cmbMarca.addItem("Glock");
		cmbMarca.addItem("Grand Power");
		cmbMarca.addItem("Hatsan");
		cmbMarca.addItem("HK");
		cmbMarca.addItem("IMBEL");
		cmbMarca.addItem("IWI");
		cmbMarca.addItem("Kimber");
		cmbMarca.addItem("Magnun");
		cmbMarca.addItem("Mossberg");
		cmbMarca.addItem("Remington");
		cmbMarca.addItem("Ruger");
		cmbMarca.addItem("Savage");
		cmbMarca.addItem("Sig Sauer");
		cmbMarca.addItem("Smith & Wesson");
		cmbMarca.addItem("Springfield");
		cmbMarca.addItem("Tanfoglio");
		cmbMarca.addItem("Taurus");
		cmbMarca.addItem("Thompson");
		cmbMarca.addItem("Walther");
		cmbMarca.addItem("Winchester");
		
		
		add(cmbMarca);
		
		
		lblMunicao = new JLabel ("Muniçao");
		lblMunicao.setBounds(200, 10, 100, 25);
		add(lblMunicao);
		
		txtMunicao= new JTextField();
		txtMunicao.setBounds(200, 35, 100, 25);
		add(txtMunicao);
		
		
		lblCalibre = new JLabel ("Calibre");
		lblCalibre.setBounds(200, 60, 100, 25);
		add(lblCalibre);
		
		txtCalibre= new JTextField();
		txtCalibre.setBounds(200, 80, 100, 25);
		add(txtCalibre);
		
		lblComposicao = new JLabel ("Composi��o");
		lblComposicao.setBounds(330, 10, 100, 25);
		add(lblComposicao);
		
		txtComposicao= new JTextField();
		txtComposicao.setBounds(330, 30, 100, 25);
		add(txtComposicao);
		
		lblNumRegistro = new JLabel ("Numero Registro");
		lblNumRegistro.setBounds(330, 60, 100, 25);
		add(lblNumRegistro);
		
		txtNumRegistro= new JTextField();
		txtNumRegistro.setBounds(330, 80, 100, 25);
		add(txtNumRegistro);
		
		
		
		//Salvar
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(650, 85, 100, 25);
		add(btnSalvar);
		
		//LISTAR
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(650, 50, 100, 25);
		add(btnListar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(650, 10, 100, 25);
		add(btnRemover);
		
		//TABELA
		
		dadosTabela = new DefaultTableModel();
		dadosTabela.addColumn("Modelo");
		dadosTabela.addColumn("Marca");
		dadosTabela.addColumn("Muni��o");
		dadosTabela.addColumn("Calibre");
		dadosTabela.addColumn("Composi�ao");
		dadosTabela.addColumn("Numero Registro");
		
		tabela = new JTable(dadosTabela);
		
		scroll = new JScrollPane(tabela);
		scroll.setBounds(10, 120, 765, 300);
		add(scroll);
		
		encheLista();
		
		
		
		
		
	}
	private void criaAcoes() {
		//Salvar um novo Livro na lista
		btnListar.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String modelo = txtModelo.getText();
				String marca = cmbMarca.getSelectedItem().toString();
				String municao = txtMunicao.getText();
				String calibre = txtCalibre.getText();
				String composicao = txtComposicao.getText();
				String numRegistro = txtNumRegistro.getText();
				
				//Criar um novo Objeto Livro
				Arma novaArma = new Arma(modelo, marca, municao, 
						calibre, composicao , numRegistro);
				
				//Adicionar este novo Livro na lista de Livros
				ListaArmas.add(novaArma);
				
				//listarTodosLivros();
				listaParaTabela();
			
		
				
				
			}

				
			
		});
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int i ;
				BufferedWriter bw = null;
				String a = ListaArmas.toString();
		        try {
		            bw = new BufferedWriter(new FileWriter("texto0.txt", true));
		            bw.write(ListaArmas.toString());
		            System.out.println(a);
		            bw.newLine();
		            bw.flush();
		        } catch (IOException ioe) {
		            ioe.printStackTrace();
		        } finally { // always close the file
		            if (bw != null) {
		                try {
		                    bw.close();
		                } catch (IOException ioe2) {
		                    // just ignore it
		                }
		            }
				
				
		        }
				
				
				
				
			}
		});
		//Remove um livro
		btnRemover.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Pega a linha selecionada
				
				int posicao = tabela.getSelectedRow();
				
				if (posicao > -1) {
					ListaArmas.remove(posicao);
					listaParaTabela();
				}
				
			}
		});
		
	
	}
	public void listaParaTabela() {
		
		//Limpar a tabela antes
		
		for (int i = dadosTabela.getRowCount() - 1; i >=0; i --) {
			dadosTabela.removeRow(i);
		}
		
		for (int i = 0; i < ListaArmas.size(); i++){
			//Pega o livro atual da lista
			Arma RERERE = ListaArmas.get(i);
			
			String[] linha = new String[6];
			linha[0] = RERERE.getModelo();
			linha[1] = RERERE.getMarca();
			linha[2] = RERERE.getMunicao();
			linha[3] = RERERE.getCalibre();
			linha[4] = RERERE.getComposicao();
			linha[5] = RERERE.getNumregistro();
			
			//Adiciona uma nova linha na tabela
			dadosTabela.addRow(linha);
			
		}
	}
	
	public void listarTodosLivros() {
			System.out.println("######ARMAS############");
			for (int i = 0; i < ListaArmas.size(); i++) {
				Arma RERERE = ListaArmas.get(i);
				 RERERE.info();
				
			}
	
			
		}
	private void encheLista() {
		Arma arma1 = new Arma ("Benelli", "Crosfire","aaa,","aaa", "aaaqq", "aa");
		
		Arma arma2 = new Arma ("Benelli", "Crosfire","aaa,","aaa", "aaaqq", "aa");
		
		Arma arma3 = new Arma ("Benelli", "Crosfire","aaa,","aaa", "aaaqq", "aa");
		
		Arma arma4 = new Arma ("Benelli", "Crosfire","aaa,","aaa", "aaaqq", "aa");
		
		Arma arma5 = new Arma ("Benelli", "Crosfire","aaa,","aaa", "aaaqq", "aa");
		
		Arma arma6 = new Arma ("Benelli", "Crosfire","aaa,","aaa", "aaaqq", "aa");
		
		Arma arma7 = new Arma ("Benelli", "Crosfire","aaa,","aaa", "aaaqq", "aa");
		
		
		
		ListaArmas.add(arma1);
		ListaArmas.add(arma2);
		ListaArmas.add(arma3);
		ListaArmas.add(arma4);
		ListaArmas.add(arma5);
		ListaArmas.add(arma6);
		ListaArmas.add(arma7);
		
		
		listaParaTabela();
		
	}
	
}
