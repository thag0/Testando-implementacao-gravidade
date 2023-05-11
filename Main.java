import javax.swing.JFrame;

import entidade.PainelPrincipal;

class Main{
   public static void main(String[] args){
      JFrame janela = new JFrame();
      janela.setVisible(true);
      janela.setResizable(false);
      janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      PainelPrincipal painelPrincipal = new PainelPrincipal();

      janela.add(painelPrincipal);
      janela.pack();
      janela.setLocationRelativeTo(null);

      painelPrincipal.iniciarThread();
   }
}