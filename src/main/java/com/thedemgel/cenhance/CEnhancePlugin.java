package com.thedemgel.cenhance;

import org.spout.api.plugin.Plugin;
import org.spout.api.command.annotated.AnnotatedCommandExecutorFactory;

import com.thedemgel.cenhance.command.CEnhanceBaseCommand;
import com.thedemgel.cenhance.command.CEnhanceCommands;
import com.thedemgel.cenhance.configuration.CEnhanceConfiguration;

/**
 * Defines the main class of the plugin.
 */
public class CEnhancePlugin extends Plugin {
	private static CEnhancePlugin instance;
	private CEnhanceConfiguration config;

	@Override
	public final void onLoad() {
		setInstance(this);
		config = new CEnhanceConfiguration(getDataFolder());
		config.load();
		getLogger().info("loaded.");
	}

	@Override
	public final void onEnable() {
		// Register Base Command (/command)
		AnnotatedCommandExecutorFactory.create(new CEnhanceBaseCommand(this));
		// Register Commands under Base Command (/command command)
		AnnotatedCommandExecutorFactory.create(new CEnhanceCommands(this), getEngine().getCommandManager().getCommand("command"));

		// Register Events
		getEngine().getEventManager().registerEvents(new CEnhanceListener(this), this);

		getLogger().info("enabled.");
	}

	@Override
	public final void onDisable() {
		getLogger().info("disabled.");
	}

	private static void setInstance(final CEnhancePlugin plugin) {
		instance = plugin;
	}

	public static CEnhancePlugin getInstance() {
		return instance;
	}

	public final CEnhanceConfiguration getConfig() {
		return config;
	}
}
