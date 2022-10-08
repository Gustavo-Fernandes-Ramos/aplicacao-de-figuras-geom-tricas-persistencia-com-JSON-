import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
class Gui extends JFrame {
    // Tipo Atual de primitivo
    private TipoPrimitivo tipoAtual = TipoPrimitivo.NENHUM;

    // Cor atual
    private Color corAtual = Color.BLACK;

    // Espessura atual do primitivo
    private int espAtual = 1;

    // Componentes de GUI
    // barra de menu (inserir componente)
    private JToolBar barraComandos = new JToolBar();

    // mensagens
    private JLabel msg = new JLabel("Msg: ");

    // Painel de desenho
    private PainelDesenho areaDesenho = new PainelDesenho(msg, tipoAtual, corAtual, espAtual);

    // Botoes
    private JButton jbPonto = new JButton("Ponto");
    private JButton jbRetaMp = new JButton("Reta");
    private JButton jbCirculoMp = new JButton("Circulo");
    private JButton jbTrianguloMp = new JButton("Triangulo");
    private JButton jbRetanguloMp = new JButton("Retangulo");
    private JButton jbPoligonoMp = new JButton("Poligono");
    
    private JButton jbCarregar = new JButton("Carregar");
    private JButton jbSalvar = new JButton("Salvar");
    private JButton jbLimpar = new JButton("Limpar");
    private JButton jbCor = new JButton("Cor");
    private JButton jbSair = new JButton("Sair");

    // Entrada (slider) para definir espessura dos primitivos
    private JLabel jlEsp = new JLabel("   Espessura: " + String.format("%-5s", 1));
    private JSlider jsEsp = new JSlider(1, 50, 1);

    // Construtor
    public Gui(int larg, int alt) {

        super("Editor de figuras 2D");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larg, alt);
        setVisible(true);
        setResizable(false);

        barraComandos.add(jbPonto); //Botao Ponto
        barraComandos.add(jbRetaMp); //Botao Reta
        barraComandos.add(jbCirculoMp); //Botao Circulo
        barraComandos.add(jbTrianguloMp); //Botao Triangulo
        barraComandos.add(jbRetanguloMp); //Botao Retangulo
        barraComandos.add(jbPoligonoMp); //Botao Poligono
        barraComandos.add(jbCor); // Botao de Cores
        barraComandos.add(jbLimpar); // Botao de Limpar
        

        barraComandos.add(jlEsp); // Label para espessura
        barraComandos.add(jsEsp);    // Slider para espacamento
        areaDesenho.setEsp(espAtual); // define a espessura inicial
        
        barraComandos.add(jbCarregar); //Botao de carregar figura salva em arquivo json
        barraComandos.add(jbSalvar); //Botao de salvar figura em arquivo json
        barraComandos.add(jbLimpar); // Botao de Limpar
        barraComandos.add(jbSair); // Botao de Cores

        // adiciona os componentes com os respectivos layouts
        add(barraComandos, BorderLayout.NORTH);                
        add(areaDesenho, BorderLayout.CENTER);                
        add(msg, BorderLayout.SOUTH);

        // Adiciona "tratador" ("ouvidor") de eventos para 
        // cada componente
        jbPonto.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.PONTO;
            reconfigurarAmbiente(tipoAtual);
        });              
        jbRetaMp.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.RETA;
            reconfigurarAmbiente(tipoAtual);
        });            
        jbCirculoMp.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.CIRCULO;
            reconfigurarAmbiente(tipoAtual);
        });     
        jbTrianguloMp.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.TRIANGULO;
            reconfigurarAmbiente(tipoAtual);
        });   
        jbRetanguloMp.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.RETANGULO;
            reconfigurarAmbiente(tipoAtual);
        });  
        jbPoligonoMp.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.POLIGONO;
            reconfigurarAmbiente(tipoAtual);
        });
        jbCarregar.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.FIGURA;
            reconfigurarAmbiente(tipoAtual);
            //carrega o ultimo arquivo json gerado
            areaDesenho.carregarFiguraAnterior();
        }); 
        jbSalvar.addActionListener(e -> {
            reconfigurarAmbiente(tipoAtual);
            areaDesenho.salvarFigura();
        });
        jbLimpar.addActionListener(e -> {
            tipoAtual = TipoPrimitivo.NENHUM;
            areaDesenho.limparFigura();
            areaDesenho.removeAll();
            jsEsp.setValue(1); // inicia slider (necessario para limpar ultimo primitivoda tela) 
            reconfigurarAmbiente(tipoAtual);
            repaint();        
        });  
        jbCor.addActionListener(e -> {
            Color c = JColorChooser.showDialog(null, "Escolha uma cor", msg.getForeground()); 
            if (c != null){ 
                corAtual = c; // pega do chooserColor 
            }
            areaDesenho.setCorAtual(corAtual); // cor atual
        });  
        jsEsp.addChangeListener(e -> {
            espAtual = jsEsp.getValue();
            jlEsp.setText("   Espessura: " + String.format("%-5s", espAtual));
            areaDesenho.setEsp(espAtual);        
        });    
        jbSair.addActionListener(e -> {
            System.exit(0);
        }); 
    }
    
    //define o novo tipo, tambem cancela a definicao de qualquer primitivo apenas parcialmente definido
    public void reconfigurarAmbiente(TipoPrimitivo tipo){
        areaDesenho.setTipo(tipo);
        areaDesenho.setQtdDeClicks(0);
        areaDesenho.setPrimeiraVez(true);
    }
}