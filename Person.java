import javax.swing.JOptionPane;

public class Person {
public static void main(String[]args){
int qntMulher = 0;
int qntHomem = 0;
float altura =0 ;
int zero = 0;
float media = 0;
float maior = 0;
float menor = 0;

    while(zero != 9 ){
        int nbr = Integer.parseInt(JOptionPane.showInputDialog(null,"<html>Você é mulher ou homem? ;-; <br>1 - Mulher | 2 - Homem</html>"));
        altura = Float.parseFloat(JOptionPane.showInputDialog(null,"<html>Qual sua altura? </html>"));

        if (nbr == 1) {
            qntMulher ++;
        }
    
        if (nbr == 2) {
            qntHomem ++;
            media += altura;
        }
    
    
        if(zero == 0){
            maior = altura;
            menor = altura;

        }

        if (altura > maior) {
            maior = altura;
        }
        if (altura < menor) {
            menor = altura;
        }
    zero++;
    }

    media = media / qntHomem;

    
    JOptionPane.showMessageDialog(null, "<html>Resultado: <hr>"
    + "<br>Quant. de mulheres: " + qntMulher + "<br>Media dos homens: " + media + "<br>Maior altura: "+ maior + "<br>Menor altura:" + menor + "</html>");

}




}
