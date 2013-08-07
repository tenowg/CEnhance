package com.thedemgel.cenhance.command;

import org.spout.api.command.annotated.CommandDescription;
import org.spout.api.command.annotated.Permissible;
import org.spout.api.command.CommandArguments;
import org.spout.api.command.CommandSource;
import org.spout.api.exception.CommandException;

import com.thedemgel.cenhance.CEnhancePlugin;

/**
 * Provides an example of a base command.
 */
public class CEnhanceBaseCommand {
	private final CEnhancePlugin plugin;

	public CEnhanceBaseCommand(final CEnhancePlugin instance) {
		this.plugin = instance;
	}

	/**
	 * Provides an example command that can be issued to the Spout server.
	 * @param source CommandSource source of the Command
	 * @param args CommandArguments arguments for the Command
	 * @throws CommandException Exception if command fails
	 */
	@CommandDescription(aliases = { "command", "cmd" }, desc = "This is an example of what a command might look like. Try it out with /cmd !")
	@Permissible("CEnhance.some.permission")
	public final void exampleBaseCommand(final CommandSource source, final CommandArguments args) throws CommandException {
		// Calling this command will send whoever issued it the message below.
		source.sendMessage("The CEnhance plugin base command has been successfully issued. (Type a sub-command)");
	}
}
