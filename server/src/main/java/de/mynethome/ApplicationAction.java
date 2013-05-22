package de.mynethome;

import org.opendolphin.core.comm.Command;
import org.opendolphin.core.server.ServerAttribute;
import org.opendolphin.core.server.ServerDolphin;
import org.opendolphin.core.server.action.DolphinServerAction;
import org.opendolphin.core.server.comm.ActionRegistry;
import org.opendolphin.core.server.comm.CommandHandler;

import static de.mynethome.ApplicationConstants.ATT_ATTR_ID;
import static de.mynethome.ApplicationConstants.PM_APP;

import java.util.Date;
import java.util.List;

public class ApplicationAction extends DolphinServerAction{
    public void registerIn(ActionRegistry actionRegistry) {
      actionRegistry.register(ApplicationConstants.COMMAND_ID, new CommandHandler<Command>() {
        public void handleCommand(Command command, List<Command> response) {
          ServerAttribute date = getServerDolphin().getAt(PM_APP).getAt(ATT_ATTR_ID);
          ServerDolphin.changeValue(response, date, new Date());
        }
      });

    }
}
