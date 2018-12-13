public class Game {


    Player[] players;
    int connectedPlayers;
    int totalplayers;

    Player currentPlayer;

    public Game(int players) {
        this.players = new Player[players];
        totalplayers = players;
        connectedPlayers = 0;
    }


}
