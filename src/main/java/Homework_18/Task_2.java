package Homework_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task_2 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        fillTheList(stringList);

        //sortList(stringList);

        stringList.stream()

                .map(String::toUpperCase)
                .filter(line -> (line.startsWith("F"))||(line.startsWith("B")))

                //.collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("-------------");

        //stringList.stream().forEach(System.out::println);

        /*List<String> newValues = stringList.stream().map(String::toUpperCase)
                .peek(System.out::println).collect(Collectors.toList());

        System.out.println("-------------");*/

    }

    public static boolean fillTheList(List<String> stringList) {
        String str = "Far off in the distance, the storm's closing in\n" +
                "The pressure collapsing, bright skies become dim\n" +
                /*"This scent all around me, give memories new life\n" +
                "Knots that I've loosened still tangled inside\n" +
                "Ominous clouds, no sun in the sky\n" +
                "Is this a metaphor for my tragic demise?\n" +
                "The colors are grey on my canvas of life\n" +
                "The picture's complete, but the paint just won't dry\n" +
                "The smell of rain in the sky\n" +
                "The tears are gone, the well is dry\n" +
                "Why is my feeling of loss like a welcome home?\n" +
                "So welcome home\n" +
                "All the light fades to dark\n" +
                "All that's good gets torn apart\n" +
                "Why is this feeling of loss like a welcome home?\n" +
                "So welcome home\n" +
                "And those dirty little whispers, demon's voice in my head\n" +
                "Angel over my shoulder, evil needs to be fed\n" +
                "Hot flashes turn cold as day turns to night\n" +
                "My head starts to ache because something's not right\n" +
                "Pour salt in my wounds, I'm cut deep inside\n" +
                "Battered and bruised, bones breaking, teeth bite\n" +
                "Tattered and torn, pour gas on my life\n" +*/
                "You can burn up the book, but the pages survive";
        str = str.replace("?", "");
        str = str.replace(",", "");
        String[] arr = str.split(" ");
        //stringList = Arrays.asList(str.split(" "));
        return stringList.addAll(Arrays.asList(arr));
    }

    public static List<String> sortList(List<String> stringList){
             stringList.stream()
                     .sorted(Comparator.comparing(line -> line.startsWith("A")))
                     .map(String::toUpperCase)
                     .filter(line -> line.startsWith("A"))
                     .filter(line -> line.startsWith("E"))
                     .filter(line -> line.startsWith("I"))
                     .filter(line -> line.startsWith("O"))
                     .filter(line -> line.startsWith("U"))
                     .filter(line -> line.startsWith("Y"))
                     .peek(System.out::println);
                     //.collect(Collectors.toList());
        return stringList;
    }
}
