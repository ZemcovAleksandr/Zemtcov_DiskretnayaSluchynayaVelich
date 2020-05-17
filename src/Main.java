//Длина слова - дискретная случайная величина X. На вход программе передается текст.
//Найти закон распределения X в форме таблицы, например:
//Xi  4         5         8
//Pi  0.23    0.5     0.27
//Вычислите мат. ожидание и дисперсию X.



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
static int lki = 0;
    public static void main(String[] args) throws IOException {
        //Вызов содержимого из файла в  строку. Теперь я знаю, что лучше записывать не в строку, а в массив.
        //И разделять через Split
        String fileName = "src//notes.txt";
        String content = Files.lines(Paths.get(fileName)).reduce("", String::concat);
        ArrayList<Integer> LetterQuanity = new ArrayList<Integer>();
        ArrayList<Float> Percents = new ArrayList<Float>();
        ArrayList<Float> MatOjidanie = new ArrayList<Float>();
        ArrayList<Float> Dispersia = new ArrayList<Float>();
       content = removePunct(content);//Убрать знаки препинания из строки
       LetterQuanity = podschet(content);//Подсчёт количества букв в слове
        int size = LetterQuanity.size();//определяем количество слов
        Collections.sort(LetterQuanity);// Сортировка списка
        //////////////////Находим процент того, сколько раз определённой длины встречаются в тексте///////////////
             int Schetchik = 0;
        for(int i = 0; i < size; i++){
            Schetchik++;
                Percents.add(((float) Collections.frequency(LetterQuanity, Schetchik) / lki)*100);
            int q = i;
            if( Percents.get(i) >1 )
                System.out.println("Процент слов сотоящих из "+ q + " букв = " + (String.format("%(.2f ", Percents.get(i)) +"%"));
        }
        //////////////////Нахождение Мат.ожидания///////////////
        float MatOj =0, Disp = 0, MatOj3 = 0;
      int tg =0;
        for(int i=0; i < size; i++) {
            MatOjidanie.add(LetterQuanity.get(i) * (Percents.get(i))/100);
            MatOj = MatOj + MatOjidanie.get(i);
        }
        System. out. println("Математическое ожидание = " +  MatOj);
        //////////////////Нахождение Дисперсии///////////////
        for(int i=0; i < size; i++) {
            Dispersia.add((LetterQuanity.get(i) * LetterQuanity.get(i)) * (Percents.get(i))/100);
            Disp =  Disp + Dispersia.get(i);
        }
        Disp = Disp - (MatOj * MatOj);
        System. out. println("Дисперсия = " +  Disp);    }

/////////////////Подсчёт количества букв в слове//////////////
public static ArrayList<Integer> podschet(String ytr){
    ArrayList<Integer> LetterQuanity = new ArrayList<Integer>();
    String CurrentString = ytr;
    String[] separated = CurrentString.split(" ");
    String sResultString="";
   // LetterQuanity.add(0);
    int iWordCount = separated.length;
     lki = separated.length;
    for(int i=0;i<separated.length;i++)
    {
        String s = separated[i];
        LetterQuanity.add(s.length());
        sResultString = sResultString + s.length()+" ";
    }
      return LetterQuanity;
}
    ////Убрать символы из строки//////////////
    public static String removePunct(String str) {
        StringBuilder result = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c) || Character.isDigit(c) || Character.isSpaceChar(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}