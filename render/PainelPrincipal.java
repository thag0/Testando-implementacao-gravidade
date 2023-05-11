package render;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entidade.Entidade;
import entidade.Player;
import objetos.GerenciadorObjetos;
import structure.LeitorTeclado;
import structure.Logica;

public class PainelPrincipal extends JPanel implements Runnable{
   public final int largura = 1280;
   public final int altura = 720;

   Graphics2D g2;
   Thread threadJogo;
   public final int fps = 60;
   int contadorLixo = 0;

   public Player player;
   public Logica logica;
   public GerenciadorObjetos gerenciadorObjetos;
   public LeitorTeclado leitorTeclado;


   public PainelPrincipal(){
      player = new Player();
      player.setVelocidade(fps/15);
      player.setVelocidadePadrao(player.getVelocidade());
      player.setPosicao( ((largura/2)-(player.getLargura()/2)), ((altura/2)-(player.getAltura()/2)));
      player.xPadrao = player.getX();
      player.yPadrao = player.getY();

      leitorTeclado = new LeitorTeclado();
      gerenciadorObjetos = new GerenciadorObjetos();
      logica  = new Logica(this);

      setPreferredSize(new Dimension(largura, altura));
      setBackground(Color.BLACK);
      setVisible(true);

      addKeyListener(leitorTeclado);
      setFocusable(true);
   }


   public void iniciarThread(){
      threadJogo = new Thread(this);
      threadJogo.start();
   }  


   public void desenhar(Entidade entidade){
      repaint();
   }


   @Override
   public void run(){

      //método mais eficiente pra calcular fps em termo de uso de cpu
      double intervaloDesenho = 1_000_000_000/fps;
      double proximoTempoDesenho = System.nanoTime() + intervaloDesenho;
      double tempoRestante;

      gerenciadorObjetos.adicionarObjetos();

      while(threadJogo != null){
         atualizar();
         repaint();
         limparLixo();

         try{
            tempoRestante = proximoTempoDesenho - System.nanoTime();
            tempoRestante /= 1000000;
            if(tempoRestante < 0) tempoRestante = 0;

            Thread.sleep((long)tempoRestante);
            proximoTempoDesenho += intervaloDesenho;

         }catch(Exception e){
            threadJogo.interrupt();
         }
      }
   }


   public void atualizar(){
      requestFocus();
      logica.atualizar();
   }


   @Override
   protected void paintComponent(Graphics g){
      super.paintComponent(g);
      g2 = (Graphics2D) g;

      gerenciadorObjetos.desenharObjetos(g2);

      player.desenhar(g2);

      desenharInformacoes();

      g2.dispose();
   }


   public void desenharInformacoes(){
      g2.setFont(getFont().deriveFont(16f));
      g2.setColor(Color.WHITE);
      g2.drawString("x: " + player.getX(),10, 20);
      g2.drawString("y: " + player.getY(),10, 40);
      g2.drawString("gravidade: " + logica.forcaGravitacional,10, 60);

      g2.drawString("podePular: " + logica.podePular,10, 80);
      g2.drawString("podeCair: " + logica.podeCair,10, 100);
      g2.drawString("pulando: " + logica.pulando,10, 120);

      int x = (largura/2) - 100;
      if(leitorTeclado.a){
         g2.setColor(Color.red);
         g2.drawString("a", x, 20);
      }else{
         g2.setColor(Color.white);
         g2.drawString("a", x, 20);         
      }

      x += 20;
      if(leitorTeclado.d){
         g2.setColor(Color.red);
         g2.drawString("d", x, 20);
      }else{
         g2.setColor(Color.white);
         g2.drawString("d", x, 20);         
      }

      x += 20;
      if(leitorTeclado.espaco){
         g2.setColor(Color.red);
         g2.drawString("esp", x, 20);
      }else{
         g2.setColor(Color.white);
         g2.drawString("esp", x, 20);         
      }

      x += 40;
      if(leitorTeclado.enter){
         g2.setColor(Color.red);
         g2.drawString("ent", x, 20);
      }else{
         g2.setColor(Color.white);
         g2.drawString("ent", x, 20);         
      }
   }


   public void limparLixo(){
      contadorLixo++;
      if(contadorLixo == (fps * 60)){
         System.gc();
         contadorLixo = 0;
      }
   }

}
