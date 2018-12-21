package Model.Requests;

public class NextTurnRequest  extends  Request{
    private int numberOfTurn ;

    public NextTurnRequest(int numberOfTurn) {
        this.numberOfTurn = numberOfTurn;
    }

    public int getNumberOfTurn() {
        return numberOfTurn;
    }
}
