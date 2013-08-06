package com.thedemgel.cenhance;

import org.spout.api.event.EventHandler;
import org.spout.api.event.player.PlayerChatEvent;
import org.spout.api.event.Listener;

/**
 * Provides an example of an event listener class.
 */
public class CEnhanceListener implements Listener {
	private CEnhancePlugin plugin;

	public CEnhanceListener(CEnhancePlugin instance) {
		this.plugin = instance;
	}
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		// Do Something on PlayerChatEvent
	}
}
