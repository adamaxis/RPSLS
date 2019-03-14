package dmacc.beans;

import java.util.Random;

public class Game {
	private String player1;
	private String computerPlayer;
	private String winner;

	public Game() {
		super();

	}

	public Game(String player1) {
		super();
		this.player1 = player1;
		this.setComputerPlayer();
		this.determineWinner();
		
	}

	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getComputerPlayer() {
		return computerPlayer;
	}

	public void setComputerPlayer(String computerPlayer) {
		this.computerPlayer = computerPlayer;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	@Override
	public String toString() {
		return "Game [player1=" + player1 + ", computerPlayer=" + computerPlayer + ", winner=" + winner + "]";
	}

	public void setComputerPlayer() {
		Random num = new Random();
		int answer = num.nextInt(3) + 1;
		String player;
		if(answer == 1) {
			player = "rock";
		}else if (answer == 2) {
			player = "paper";
		}else {
			player = "scissors";
		}
		this.setComputerPlayer(player);
		
	}
	
	public void determineWinner() {
		String winner = "Computer";
		if(player1.equals("rock") && computerPlayer.equals("scissors")) {
			winner = "player";
		}else if(player1.equals("scissors") && computerPlayer.equals("paper")) {
			winner = "player";
		}else if(player1.equals("paper") && computerPlayer.equals("rock")) {
			winner = "player";
		}
		
		if(player1.equalsIgnoreCase(computerPlayer)) {
			winner = "both players";
		}
		this.setWinner(winner);
		
	}

}
