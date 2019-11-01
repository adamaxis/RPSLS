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
		int answer = num.nextInt(5) + 1;
		String player;
		if(answer == 1) {
			player = "rock";
		}else if (answer == 2) {
			player = "paper";
		}else if (answer == 3){
			player = "scissors";
		} else if (answer == 4) {
			player = "lizard";
		} else {
			player = "spock";
		}
		this.setComputerPlayer(player);
		
	}
	
	public void determineWinner() {
		String winner = "Computer";
		if(player1.equals("rock") && computerPlayer.equals("scissors")) {
			winner = "player";
		}else if(player1.equals("rock") && computerPlayer.equals("lizard")) {
			winner = "player";
		}else if(player1.equals("scissors") && computerPlayer.equals("paper")) {
			winner = "player";
		}else if(player1.equals("scissors") && computerPlayer.equals("lizard")) {
			winner = "player";
		} else if(player1.equals("paper") && computerPlayer.equals("rock")) {
			winner = "player";
		} else if(player1.equals("paper") && computerPlayer.equals("spock")) {
			winner = "player";
		} else if(player1.equals("lizard") && computerPlayer.equals("paper")) {
			winner = "player";
		} else if(player1.equals("lizard") && computerPlayer.equals("spock")) {
			winner = "player";
		} else if(player1.equals("spock") && computerPlayer.equals("rock")) {
			winner = "player";
		} else if(player1.equals("spock") && computerPlayer.equals("scissors")) {
			winner = "player";
		} 
		
		if(player1.equalsIgnoreCase(computerPlayer)) {
			winner = "both players";
		}
		this.setWinner(winner);
		
	}
	
	
/*
	public class RockPaperScissorsDraper {
		public static void main(String[] args) {
			// initialize constants
			final int ROCK = 1;
			final int PAPER = 2;
			final int SCISSORS = 3;
			final int LIZARD = 4;
			final int SPOCK = 5;
			// game end state constants
			final int PLAYER_ONE = 1;
			final int PLAYER_TWO = 2;
			final int DRAW = 0;
			// initialize variables
			int playerOneMove;
			int playerTwoMove;
			int winner=0;
			Scanner in = new Scanner(System.in);
			// get input from player 1
			System.out.print("Player 1, enter your move: ");
			String playerOneInput = in.nextLine();
			
			// decipher move
			if (playerOneInput.equalsIgnoreCase("rock")) {
				playerOneMove = ROCK;
			} else if (playerOneInput.equalsIgnoreCase("paper")) {
				playerOneMove = PAPER;
			} else if (playerOneInput.equalsIgnoreCase("scissors")) {
				playerOneMove = SCISSORS;
			} else if (playerOneInput.equalsIgnoreCase("lizard")) {
				playerOneMove = LIZARD;
			} else { // they either entered spock or gibberish(which spock fixes)
				if (!playerOneInput.equalsIgnoreCase("spock")) {
					System.out.println("*Spock glances casually about, before stepping forward*");
				}
				playerOneMove = SPOCK;
			}
			
			// get input from player 2
			System.out.print("Player 2, enter your move: ");
			String playerTwoInput = in.nextLine();

			// decipher move
			if (playerTwoInput.equalsIgnoreCase("rock")) {
				playerTwoMove = ROCK;
			} else if (playerTwoInput.equalsIgnoreCase("paper")) {
				playerTwoMove = PAPER;
			} else if (playerTwoInput.equalsIgnoreCase("scissors")) {
				playerTwoMove = SCISSORS;
			} else if (playerTwoInput.equalsIgnoreCase("lizard")) {
				playerTwoMove = LIZARD;
			} else { // they either entered spock or gibberish(which spock fixes)
				if (!playerTwoInput.equalsIgnoreCase("spock")) {
					System.out.println("*Spock glances casually about, before stepping forward*");
				}
				playerTwoMove = SPOCK;
			}
			
			// game logic
			if (playerOneMove == ROCK) {
				if (playerTwoMove == LIZARD) {
					winner = PLAYER_ONE;
					System.out.println("Rock crushes lizard.");
				} else if (playerTwoMove == SCISSORS) {
					winner = PLAYER_ONE;
					System.out.println("Rock crushes scissors.");
				} else if (playerTwoMove == PAPER) {
					winner = PLAYER_TWO;
					System.out.println("Paper covers rock.");
				} else if (playerTwoMove == SPOCK) {
					winner = PLAYER_TWO;
					System.out.println("Spock vaporizes rock.");
				} else if (playerTwoMove == ROCK) {
					winner = DRAW;
					System.out.println("The two rocks stare at each other for a moment.");
				}
		
			} else if (playerOneMove == PAPER) {
				if (playerTwoMove == ROCK) {
					winner = PLAYER_ONE;
					System.out.println("Paper covers rock.");
				} else if (playerTwoMove == SPOCK) {
					winner = PLAYER_ONE;
					System.out.println("Paper disproves Spock.");
				} else if (playerTwoMove == SCISSORS) {
					winner = PLAYER_TWO;
					System.out.println("Scissors cuts paper.");
				} else if (playerTwoMove == LIZARD) {
					winner = PLAYER_TWO;
					System.out.println("Lizard eats paper.");
				} else if (playerTwoMove == PAPER) {
					winner = DRAW;
					System.out.println("The papers lie motionless.");
				}
				
			} else if (playerOneMove == SCISSORS) {
				if (playerTwoMove == LIZARD) {
					winner = PLAYER_ONE;
					System.out.println("Scissors decapitates lizard.");
				} else if (playerTwoMove == PAPER) {
					winner = PLAYER_ONE;
					System.out.println("Scissors cuts paper.");
				} else if (playerTwoMove == SPOCK) {
					winner = PLAYER_TWO;
					System.out.println("Spock smashes scissors.");
				} else if (playerTwoMove == ROCK) {
					winner = PLAYER_TWO;
					System.out.println("Rock crushes scissors.");
				} else if (playerTwoMove == PAPER) {
					winner = DRAW;
					System.out.println("The scissors lie motionless.");
				}
			} else if (playerOneMove == LIZARD) {
				if (playerTwoMove == PAPER) {
					winner = PLAYER_ONE;
					System.out.println("Lizard eats paper.");
				} else if (playerTwoMove == SPOCK) {
					winner = PLAYER_ONE;
					System.out.println("Lizard poisons Spock.");
				} else if (playerTwoMove == ROCK) {
					winner = PLAYER_TWO;
					System.out.println("Rock crushes lizard.");
				} else if (playerTwoMove == SCISSORS) {
					winner = PLAYER_TWO;
					System.out.println("Scissors decapitates lizard.");
				} else if (playerTwoMove == LIZARD) {
					winner = DRAW;
					System.out.println("The lizards circle each other briefly before scampering off.");
				}
				
			} else { // Spock
				if (playerTwoMove == ROCK) {
					winner = PLAYER_ONE;
					System.out.println("Spock vaporizes rock.");
				} else if (playerTwoMove == SCISSORS) {
					winner = PLAYER_ONE;
					System.out.println("Spock smashes scissors.");
				} else if (playerTwoMove == LIZARD) {
					winner = PLAYER_TWO;
					System.out.println("Lizard poisons Spock.");
				} else if (playerTwoMove == PAPER) {
					winner = PLAYER_TWO;
					System.out.println("Paper disproves Spock.");
				} else if (playerTwoMove == SPOCK) {
					winner = DRAW;
					System.out.println("The two Vulcans stare at each other briefly, before driving away in a Mercedes-Benz to \"The Ballad of Bilbo Baggins.\"");
				}
			}
			// declare winner
			if (winner == PLAYER_ONE) {
				System.out.println("Player one wins!");
			} else if (winner == PLAYER_TWO) {
				System.out.println("Player two wins!");
			} else {
				System.out.println("It's a draw!");
			}
			
			in.close();
		}
	}
*/

}
