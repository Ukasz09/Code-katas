public class GameRounds {
    int fstRoll;
    int sndRoll = 0;

    //----------------------------------------------------------------------//
    public GameRounds(int fstRoll, int sndRoll) {
        this.fstRoll = fstRoll;
        this.sndRoll = sndRoll;
    }

    public GameRounds(int fstRoll) {
        this.fstRoll = fstRoll;
    }

    //----------------------------------------------------------------------//
    public int getFstRoll() {
        return fstRoll;
    }

    public int getSndRoll() {
        return sndRoll;
    }
}
