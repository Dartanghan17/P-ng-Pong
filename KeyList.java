import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyList implements KeyListener {
    //Bu sınıf klavyede bastığımız tuşların karşılığında uygulanacak programı yazacağımız kısım.
    //bi swicth case ile kullansam daha iyi olur sanki brodan gördüm.
    private boolean keyPressed[] = new boolean[128];
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed[e.getKeyCode()]= true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed[e.getKeyCode()]= false;
    }
    public boolean isKeyPressed(int keyCode){
        return keyPressed[keyCode];
    }
}
/* Ya burada adam buraya yazıcağı kodu ilerde şekillerin ekranda hareket etmesi için kullanıyo
       bende kendi kodumu onunkine göre uyarlayamadım.BUnu şimdilik izle öğren uygula sonra uyarlamayı
       deneme yoluna gidecğim.
        switch (e.getKeyChar()){
            case 'a':
                System.out.println("a ya basıldı");
                break;
            case 's':
                System.out.println("s ya basıldı");
                break;
            case 'w':
                System.out.println("w ya basıldı");
                break;
            case 'd':
                System.out.println("d ya basıldı");
                break;
        }
        */
/* //Adamın biri burada basitçe  128 elemanı bulunan boolean tipi bir dizi üretip
*  //Bu array içerisine Basıldığında kodun (int) karşılığı dizi elemanını true yapıp kaldırıldığında false yapacak şekilde programlıyor
*   private boolean keyPressed[] = new boolean[128]
*     @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        keyPressed[e.getKeyCode()] = true
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keyPressed[e.getKeyCode()] = false
    }
*  Şeklinde tasarladı ve de if yapısı kullanarak çalıştırdı  ben bunu bi düşüncem birde başka bir adam swicth yapısı ile kullandı
* */
