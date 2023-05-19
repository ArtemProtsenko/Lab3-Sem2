import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static String[] FindAndSortVowelWords(StringBuilder givenStringBuilder){
        String vowels = "уУеЕїЇіІаАоОєЄяЯюЮ";
        String[] vowelsArr = vowels.split("");
        String separators = ",.!;:'?";
        String[] separatorsArr = separators.split("");

        for(String i : separatorsArr){
            int index = 0;
            while(givenStringBuilder.indexOf(i, index) != -1){
                index = givenStringBuilder.indexOf(i, index);
                givenStringBuilder.deleteCharAt(index);
            }
        }

        String vowelsWords = "";

        for(String i : vowelsArr) {
            int prevIndex = 0;
            int nextIndex = 0;
            while (givenStringBuilder.indexOf(" " + i, prevIndex) != -1) {
                prevIndex = givenStringBuilder.indexOf(" " + i, prevIndex) + 1;
                nextIndex = givenStringBuilder.indexOf(" ", prevIndex);

                vowelsWords += givenStringBuilder.substring(prevIndex, nextIndex) + " ";
            }
        }

        vowelsWords = vowelsWords.substring(0, vowelsWords.lastIndexOf(" "));

        String[] vowelsWordsArr = vowelsWords.split(" ");

        Arrays.sort(vowelsWordsArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > 1 && o2.length() > 1){
                    return o1.charAt(1) - o2.charAt(1);
                }
                else if(o1.length() == 1){
                    return ' ' - o2.charAt(1);
                }
                else{
                    return o1.charAt(1) - ' ';
                }
            }
        });

        return vowelsWordsArr;
    }

    public static void main(String[] args) {
        System.out.println("C3 = " + 24 % 3 + ", type - StringBuilder.");
        System.out.println("C17 = " + 24 % 17 + ", Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.");

        StringBuilder line = new StringBuilder("На постійній основі. підприємство застосовує універсальні оригінальні технології бізнесу, зберігання даних та безпрограшних домовленостей. Одна з найбільших глобальних організацій надає широкий спектр послуг, зокрема послуги доставки кореспонденції, ремонт ювелірних виробів і годинників та передачу даних.");

        String[] sortedVowelWords = FindAndSortVowelWords(line);

        for(String i : sortedVowelWords) System.out.println(i);
    }
}