package entidade;

public class Entidade{
   private double x;
   private double y;
   private double largura;
   private double altura;
   private double velocidade;


   public double getX(){
      return x;
   }


   public void setX(double x){
      this.x = x;
   }


   public double getY(){
      return y;
   }
   public void setY(double y){
      this.y = y;
   }


   public double getLargura(){
      return largura;
   }


   public void setLargura(double largura){
      this.largura = largura;
   }


   public double getAltura(){
      return altura;
   }


   public void setAltura(double altura){
      this.altura = altura;
   }


   public double getVelocidade(){
      return this.velocidade;
   }


   public void setVelocidade(double velocidade){
      this.velocidade = velocidade;
   }
}
