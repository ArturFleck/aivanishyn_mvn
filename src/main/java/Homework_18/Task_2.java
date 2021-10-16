package Homework_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task_2 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();    // creating List of strings
        fillTheList(stringList);                        // filling List with data
        sortList(stringList);                           // filtering List and rewrite it
        stringList.forEach(System.out::println);        // printing List
    }

    public static void fillTheList(List<String> stringList) {
        String str = "Far off in the distance, the storm's closing in\n" +
                "The pressure collapsing, bright skies become dim\n" +
                "This scent all around me, give memories new life\n" +
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
                "Tattered and torn, pour gas on my life\n" +
                "You can burn up the book, but the pages survive";
        str = str.replace("?", "").replace(",", "").replace("\n", " "); // cleaning our string
        String[] arr = str.split(" ");
        stringList.addAll(Arrays.asList(arr)); // filling our list
    }

    public static void sortList(List<String> stringList) {
        List<String> outStringList = new ArrayList<>();
        outStringList.addAll(stringList.stream()
                //.peek(System.out::println) // print stream
                .map(String::toUpperCase)
                .filter(line -> (line.startsWith("A")) || (line.startsWith("E")) || (line.startsWith("I")) || (line.startsWith("O")) || (line.startsWith("U")) || (line.startsWith("Y")))
                .collect(Collectors.toList()));
        stringList.clear();
        stringList.addAll(outStringList.stream().collect(Collectors.toList()));
    }
}
