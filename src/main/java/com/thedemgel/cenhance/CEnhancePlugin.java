package com.thedemgel.cenhance;

import org.spout.api.plugin.Plugin;
import org.spout.api.command.annotated.AnnotatedCommandExecutorFactory;

import com.thedemgel.cenhance.command.CEnhanceBaseCommand;
import com.thedemgel.cenhance.command.CEnhanceCommands;
import com.thedemgel.cenhance.configuration.CEnhanceConfiguration;

/**
 * Define structure of Skill/Abilty/Effect search.
 * 
 * Use Annotations to get passive modifiers for Skills/Abilities/Effects
 * 
 * Modifiers
 *   Effects/Skills/Abilities can add to Modifiers list.
 *   ConcurrentMap (Modified (Class), ConcurrentMap(modifierId, modifier)
 *   When skill is added, look for @Modifier on Modifier fields
 *   when skill is removed, reverse process
 * 
 *   Events fired on addition/removal of Modifiers/Skills/Effects
 * 
 *   ModifierHandler
 * 
 *   Modifier class
 *     modifierId = UUID or Long
 *     One method (modify) - returns Object with proper modifier
 * 
 * Effects can stack: options
 *   Effect container - map and sorted list
 *     Sorted List is descending from time left of effect
 *     Map effectid/Effect - effectid = UUID or Long
 * 
 *   Effect Object
 *     stack = how much it can stack (default)
 *     getpossiblestack will calculate stack amount possible at moment
 *     execute will perform the effect
 * 
 * Skills Cannot be stacked
 *   Map skillid/Skill - skillid = UUID or Long
 * 
 *   Skill Object
 *     Cooldown = long milliseconds
 *     execute will perform the skill.
 * 
 *   Skills can add passive Modifiers, or active Effects
 * 
 * Map (TypeofAbility (Enum?)/Map("stringid"/Ability-Skill))
 *   Type is Class Annotation and stringid is class annotation
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
