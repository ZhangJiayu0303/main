package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
/**
 * Calculates the average of all salaries
 */
public class AverageCommand extends Command {

    public static final String COMMAND_WORD = "average";

    public static final String MESSAGE_SUCCESS = "Showed the average salary of all persons: %.2f";

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        requireNonNull(model);
        int sum = 0;
        for (int i = 0; i < model.getFilteredPersonList().size(); i++) {
            sum += Integer.parseInt(String.valueOf(model.getFilteredPersonList().get(i).getSalary()));
        }

        return new CommandResult(
                String.format(MESSAGE_SUCCESS, (double) sum / model.getFilteredPersonList().size()));


    }
}



