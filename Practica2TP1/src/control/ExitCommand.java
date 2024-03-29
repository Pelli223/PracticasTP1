package control;

import logic.Game;

public class ExitCommand extends Command{
	public ExitCommand() {
		super("exit", "e", "[e]xit", "exit game");
	}

	public boolean execute(Game game) {
		game.exit();
		return false;
	}

	public Command parse(String[] commandWords) {
		return parseNoParamsCommand(commandWords);
	}
}
