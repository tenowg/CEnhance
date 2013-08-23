package com.thedemgel.cenhance.modifier.modifiers;

import com.thedemgel.cenhance.modifier.Modifier;
import com.thedemgel.cenhance.attribute.Skill;

/**
 * A Speed Modifier.
 */
public class Speed extends Modifier {
	private final Skill skill;
	
	public Speed(Skill settingSkill) {
		this.skill = settingSkill;
	}
	
	public Double getModifier() {
		return skill.mod(this);
	}
}
