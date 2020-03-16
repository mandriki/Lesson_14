package taskExpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        /** аписать программу, проверяющую, является ли введённая строка адресом электронного почтового ящика.
         В названии почтового ящика разрешить использование только букв,
         цифр и нижних подчёркиваний, при этом оно должно начинаться с буквы.
         Возможные домены верхнего уровня: .org .com */

        String m = "RFEFiiooouio232    131@DFDFDF.org";
        System.out.println("из стороки - " + email(m));

        /**2. Написать программу, выполняющую поиск в строке шестнадцатеричных чисел, записанных по правилам Java,
                с помощью регулярных выражений и выводящую их на страницу.*/

        String h = " вот элаьшоащолщ иргнпршг 878у9аы 99 98 98989 8ргргр9 989vd8989" +
                "dsfsdfsd 0x  dfd 0 0xC934E5D372B2AB6D0A50B9F0341A00ed029bdc15, 0x00000bb9";
        System.out.println("из стороки - " + hex(h));
       /** 3. Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть параметры, например <p id ="p1">,
                и замену их на простые теги абзацев <p>.*/

        String t = " <p id =p1>, и замену их на простые теги абзацев <p>.";
        System.out.println("\n из - "+ t);
        System.out.println("получилась сторока - " + teg(t));

       /** 4. Написать программу, выполняющую поиск в строке мобильных телефонных номеров в формате +375XXYYYYYYY
    и заменяющую каждый телефон на тот же, но в формате +375 (XX) YYY-YY-YY
    X - код оператора
    Y - номер телефона*/
        String tel = "+375298406892  и заменяющую каждый телефон на тот же, " +
                "но в формате +375 (XX) YYY-YY-YY";
        System.out.println("\n из - "+tel);
        System.out.println("получилась сторока - " + telefon(tel));

        /**5. Написать метод, который проверяет, является ли строка адресом IPv4.*/
        String ip = "198.064.0.1";
        System.out.println("\n из - "+ip);
        ipAddres(ip);
      
}
    private static String email(String m) {
        Pattern mail = Pattern.compile("^[a-zA-Z]+\\w+\\@[a-zA-Z]\\S*?\\.(com|org)$");
        Matcher matcher = mail.matcher(m);
        if (matcher.find()) {
            System.out.println("\n - Mail корректен - ");
        } else {
            System.out.println("\n - Mail не корректен - ");
        }
        return m;
    }
    private static String hex (String h) {
        Pattern hex = Pattern.compile("0[xX][0-9a-fA-F]+");
        Matcher matcher = hex.matcher(h);
        System.out.println(" ");
        while (matcher.find()) {
            System.out.println("Чило 16-е - "+matcher.group());
        }
        return h;
    }
    private static String teg(String t) {
        return t.replaceAll("<([a-z0-9]+) +[^>]+>", "<$1>");
    }
    private static String telefon(String tel) {
        return tel.replaceAll("(\\+375)(\\d{2})(\\d{3})(\\d{2})(\\d{2})", "$1 ($2) $3-$4-$5");
    }
    private static String ipAddres(String ip) {
        Pattern ipAddres = Pattern.compile("^(?!0)(?!.*\\.$)((1?\\d?\\d|25[0-5]|2[0-4]\\d)(\\.|$)){4}$");
        Matcher matcher = ipAddres.matcher(ip);
        if (matcher.find()) {
            System.out.println("IP правельный- "+matcher.group());
        }
        else System.out.println("Не правильно");
        return ip;
    }
}

/**1. Написать программу, проверяющую, является ли введённая строка адресом электронного почтового ящика.
      В названии почтового ящика разрешить использование только букв, цифр и нижних подчёркиваний, при этом оно должно начинаться с буквы.
      Возможные домены верхнего уровня: .org .com
        2. Написать программу, выполняющую поиск в строке шестнадцатеричных чисел, записанных по правилам Java,
        с помощью регулярных выражений и выводящую их на страницу.

        3. Написать программу, выполняющую поиск в строке всех тегов абзацев, в т.ч. тех, у которых есть параметры, например <p id ="p1">,
        и замену их на простые теги абзацев <p>.

        4. Написать программу, выполняющую поиск в строке мобильных телефонных номеров в формате +375XXYYYYYYY
        и заменяющую каждый телефон на тот же, но в формате +375 (XX) YYY-YY-YY
        X - код оператора
        Y - номер телефона
        5. Написать метод, который проверяет, является ли строка адресом IPv4.
        Пример корректных IPv4
        0.0.0.0
        0.0.1.0
        255.0.0.1
        255.55.255.255
        192.168.0.1

        Не корректный
        001.0.0.0
        256.1.1.1
        1.1.1.1.
        -1.0.-1.1
*/

