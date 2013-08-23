package com.thedemgel.cenhance.modifier;

import java.util.UUID;

/**
 *
 */
public abstract class Modifier {
	private UUID modifierId;

	public UUID getModifierId() {
		return modifierId;
	}

	public void setModifierId(UUID modifierId) {
		this.modifierId = modifierId;
	}
}
