/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thedemgel.cenhance.attribute;

import com.thedemgel.cenhance.AbilityType;
import com.thedemgel.cenhance.annotation.Ability;
import com.thedemgel.cenhance.modifier.Modifier;
import com.thedemgel.cenhance.modifier.SingleModifierContainer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author tenowg
 */
@Ability(name = "test", type = AbilityType.SKILL, container = SingleModifierContainer.class)
public abstract class Skill extends Attribute {
	private ConcurrentMap<UUID, Modifier> modifiers;

	public Skill() {
		this.modifiers = new ConcurrentHashMap<>();
		setModContainer(new SingleModifierContainer());
	}
	
	public abstract Double mod(Modifier modifier);

	public ConcurrentMap<UUID, Modifier> getModifiers() {
		getModifierContainer(getClass().getAnnotation(Ability.class).container());
		return modifiers;
	}

	public void setModifiers(ConcurrentMap<UUID, Modifier> modifiers) {
		this.modifiers = modifiers;
	}
}
