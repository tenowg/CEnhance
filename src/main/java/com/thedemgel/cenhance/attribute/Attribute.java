/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thedemgel.cenhance.attribute;

import com.thedemgel.cenhance.annotation.Ability;
import com.thedemgel.cenhance.modifier.ModifierContainer;
import com.thedemgel.cenhance.modifier.SingleModifierContainer;

/**
 *
 * @author tenowg
 */
public class Attribute {
	private ModifierContainer modContainer;
	
	public <T extends ModifierContainer> T getModifierContainer(Class<? extends ModifierContainer> clazz) {
		if (clazz.isAnnotationPresent(Ability.class)) {
			return (T) modContainer;
		}
		
		return null;
	}
	
	public <T extends ModifierContainer> void setModContainer(T container) {
		this.modContainer = container;
	}
}
