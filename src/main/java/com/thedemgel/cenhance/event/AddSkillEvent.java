
package com.thedemgel.cenhance.event;

import com.thedemgel.cenhance.attribute.Skill;
import org.spout.api.entity.Player;
import org.spout.api.event.Cancellable;
import org.spout.api.event.Event;
import org.spout.api.event.HandlerList;
import org.spout.api.plugin.Plugin;


/**
 * Event fired when a player acquires a new skill.
 */
public class AddSkillEvent extends Event implements Cancellable {

	private static HandlerList handlers = new HandlerList();

	private final Player player;
	private final Skill skill;
	private final Plugin plugin;
	
	/**
	 * Required Constructor to fire event.
	 * 
	 * @param playerEffected
	 * @param skillAdded
	 * @param pluginAdding
	 */
	public AddSkillEvent(Player playerEffected, Skill skillAdded, Plugin pluginAdding) {
		this.player = playerEffected;
		this.skill = skillAdded;
		this.plugin = pluginAdding;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public void setCancelled(boolean cancelled) {
		super.setCancelled(cancelled);
	}

	public Player getPlayer() {
		return player;
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public Skill getSkill() {
		return skill;
	}
}
