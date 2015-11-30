package com.spadatech.nanodegree.jokes;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class JokeProvider {

    List<String> jokes = Arrays.asList(
            "How many tickles does it take to make a squid laugh?" + System.getProperty("line.separator") + "Ten-tickles",
            "A Roman soldier walked into a bar. He held up two fingers and said to the bartender: \"Five beers please!\"",
            "What did the cell say to his sister when she stepped on his foot?" + System.getProperty("line.separator") + "Mitosis!",
            "What did E.T.\'s mother say to him when he got home?" + System.getProperty("line.separator") + "Where on Earth have you been?!",
            "There are two types of people in this world: Those who can extrapolate from incomplete data.",
            "How many ears does Mr. Spock have?" + System.getProperty("line.separator") + "Three: the right ear, the left ear, and the final front ear.",
            "What do you get when you cross a cow with an octopus?" + System.getProperty("line.separator") + "A meeting with the ethics committee and swift removal of your research funding.",
            "Wanna hear a joke about potassium?" + System.getProperty("line.separator") + "K.",
            "Why was Pavlov’s hair so soft?" + System.getProperty("line.separator") + "Classical conditioning.",
            "What do you get when you put root beer in a square glass?" + System.getProperty("line.separator") + "A beer.",
            "Why is air a lot like sex?" + System.getProperty("line.separator") + "Because it's no big deal unless you're not getting any.",
            "Why did Mickey Mouse get shot?" + System.getProperty("line.separator") + "Because Donald ducked.",
            "What was the name of the hair salon next to the graveyard?" + System.getProperty("line.separator") + "Curl Up and Dye.",
            "If at first you don't succeed, sky diving isn't for you.",
            "How many Frat boys does it take to change a light bulb?" + System.getProperty("line.separator") + "11 - One to hold the lightbulb, and 10 to drink until the room spins.",
            "Why did the belt get locked up?" + System.getProperty("line.separator") + "He held up a pair of pants.",
            "Where do lady ghosts go for haircuts?" + System.getProperty("line.separator") + "The Boo-ty Parlor!",
            "An 80-year-old man comes home and finds his 80-year-old wife doing a handstand, naked, against a wall." + System.getProperty("line.separator") +
                    "He asks, \"What are you doing?\"\n" + System.getProperty("line.separator") +
                    "She responds, \"I know you can't get it up, but maybe you can drop in.\"",
            "Why did Beethoven kill his chicken?" + System.getProperty("line.separator") + "It kept saying, \"Bach, Bach, Bach.\"",
            "Yo mama so fat, her portrait fell off the wall.",
            "Yo' Mama is so fat, when she went skydiving, she caused an eclipse.",
            "Yo' Mama is so fat, when she left her home country, the population dropped by 10%.",
            "Yo' Mama is so fat, her blood type is marinara."
    );

    public String getJoke(){
        String joke;

        Random random = new Random();
        int numb = random.nextInt(23);

        joke = jokes.get(numb);

        return joke;
    }
}
