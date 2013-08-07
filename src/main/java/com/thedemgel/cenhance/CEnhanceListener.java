package com.thedemgel.cenhance;

import org.spout.api.event.EventHandler;
import org.spout.api.event.player.PlayerChatEvent;
import org.spout.api.event.Listener;

/**
 * Provides an example of an event listener class.
 */
public class CEnhanceListener implements Listener {
	private final CEnhancePlugin plugin;

	public CEnhanceListener(final CEnhancePlugin instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onPlayerChat(final PlayerChatEvent event) {
		// Do Something on PlayerChatEvent
	}
}
