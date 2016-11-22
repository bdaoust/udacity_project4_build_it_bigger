package com.example;

import java.util.ArrayList;

public class JokeProvider {

    // Sources for Jokes:
    // http://boredomtherapy.com/nerd-science-jokes/
    // http://www.makeuseof.com/tag/55-geeky-line-jokes/
    // http://onelinefun.com
    // http://www.kidspot.com.au/things-to-do/activities/why-did-the-chicken-cross-the-road-jokes
    // https://www.pinterest.com/explore/funny-jokes/

    private ArrayList<String> mJokes;

    public JokeProvider(){
        mJokes = new ArrayList<>();

        mJokes.add("How do you know the moon is going broke?\n\nIt's down to its last quarter");
        mJokes.add("An infectious disease enters a bar. The bartender says, \"We don't serve your kind in here.\" " +
                "It replies, \"Well, you're not a very good host.\"");
        mJokes.add("What is a cation afraid of?\n\nDogions");
        mJokes.add("A cop pulls Heisenberg over and asks him, \"Do you know how fast you were going?\" " +
                "Heisenberg replies, \"No, but I know where I am.\"");
        mJokes.add("Where does bad light end up?\n\nIn prism");
        mJokes.add("What does a subatommic duck say?\n\nQuark");
        mJokes.add("Why did the bear dissolve in water?\n\nIt was polar");
        mJokes.add("Two chemists walk into a bar. The first says, \"I'll have some H2O.\" The second says, " +
                "\"I'll have some H2O too.\" The second one died.");
        mJokes.add("Schrödinger got stopped by a cop. The cop searches the car and asks, \"Did you know " +
                "there's a dead cat in here?\". He replies, \"Well, now I do!\"");
        mJokes.add("There are 10 kinds of people in this world. Those who understand binary. And those who don't.");
        mJokes.add("Why did I divide sin by tan?\n\n Just cos");
        mJokes.add("Why can't you trust atoms?\n\nThey make up everything");
        mJokes.add("How many theoretical physicists does it take to screw in a light bulb?\n\nTwo. One to hold " +
                "the bulb and one to rotate the Universe.");
        mJokes.add("A photon checks into a hotel. The bellhop asks, \"Can I help you with your luggage?\" " +
                "It replies, \"I don't have any. I'm traveling light.\"");
        mJokes.add("To err is human - and to blame it on a computer is even more so.");
        mJokes.add("CAPS LOCK - Preventing Login Since 1980.");
        mJokes.add("Some things Man was never meant to know. For everything else, there's Google.");
        mJokes.add("UNIX is basically a simple operating system, but you have to be a genius to understand the simplicity.");
        mJokes.add("If at first you don't succeed; call it version 1.0");
        mJokes.add("If you give someone a program, you will frustrate them for a day; if you teach them how to program, " +
                "you will frustrate them for a lifetime.");
        mJokes.add("I wasn't originally going to get a brain transplant, but then I changed my mind.");
        mJokes.add("I'd tell you a chemistry joke but I know I wouldn't get a reaction.");
        mJokes.add("Why was Cinderella thrown off the basketball team? She ran away from the ball.");
        mJokes.add("I'm glad I know sign language, it's pretty handy.");
        mJokes.add("Did you hear about the guy who got hit in the head with a can of soda? He was lucky it was a soft drink.");
        mJokes.add("I'm reading a book about anti-gravity. It's impossible to put down.");
        mJokes.add("What was Forrest Gump's email password?\n\n\"1forrest1\"");
        mJokes.add("A book just fell on my head. I've only got myshelf to blame.");
        mJokes.add("Why did the scientist install a knocker on his door?\n\nHe wanted to win the No-bell prize!");
        mJokes.add("What do you call people who are afraid of Santa Claus?\n\nClaustrophobic");
        mJokes.add("I changed my password to \"incorrect\". So whenever I forget what it is the computer will say \"Your " +
                "password is incorrect\".");
        mJokes.add("Why did the rubber chicken cross the road?\n\n She wanted to stretch her legs.");
        mJokes.add("Why did the Roman chicken cross the road?\n\nShe was afraid someone would Caesar!");
        mJokes.add("Why did the chicken cross the playground?\n\nTo get to the other slide.");
        mJokes.add("Why did the duck cross the road?\n\nTo prove he wasn't chicken!");
        mJokes.add("Why did the cow cross the road?\n\nTo get to the udder side!");
        mJokes.add("If you ever get cold, just stand in a corner for a bit. They are usually around 90 degrees.");
        mJokes.add("How do you count cows?\n\nWith a cowculator");
        mJokes.add("What do you call an alligator in a vest?\n\nAn investigator.");
        mJokes.add("Which U.S. state has the smallest soft drinks?\n\nMinisoda.");
        mJokes.add("Did you hear about the new restaurant on the moon?\n\nThe food is great, but there's no atmosphere.");
        mJokes.add("Did you hear about the Italian chef that died?\n\nHe pasta way");
    }

    public JokeProvider(ArrayList<String> jokes){
        mJokes = jokes;
    }

    public int size(){
        return mJokes.size();
    }

    public String getRandomJoke(){
        int randomIndex;

        randomIndex = (int)Math.floor(mJokes.size()*Math.random());

        return mJokes.get(randomIndex);
    }
}
