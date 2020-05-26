package me.threalmck.casino.entities;

public class RouletteSlot {
    private final RouletteColour colour;
    private final RouletteHoriGroup horiGroup;
    private final RouletteVertiGroup vertiGroup;
    private final int number;

    public RouletteSlot(RouletteColour colour, RouletteHoriGroup horiGroup, RouletteVertiGroup vertiGroup, int number) {
        this.colour = colour;
        this.horiGroup = horiGroup;
        this.vertiGroup = vertiGroup;
        this.number = number;
    }

    public RouletteColour getColour() {
        return colour;
    }

    public RouletteHoriGroup getHoriGroup() {
        return horiGroup;
    }

    public RouletteVertiGroup getVertiGroup() {
        return vertiGroup;
    }

    public int getNumber() {
        return number;
    }
}
