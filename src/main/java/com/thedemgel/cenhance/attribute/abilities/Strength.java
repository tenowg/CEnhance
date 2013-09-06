/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thedemgel.cenhance.attribute.abilities;

import com.thedemgel.cenhance.AbilityType;
import com.thedemgel.cenhance.annotation.Ability;
import com.thedemgel.cenhance.annotation.ModifierType;
import com.thedemgel.cenhance.annotation.Value;
import com.thedemgel.cenhance.modifier.Modifier;
import com.thedemgel.cenhance.modifier.modifiers.Speed;
import com.thedemgel.cenhance.attribute.Skill;
import com.thedemgel.cenhance.modifier.SingleModifierContainer;

/**
 * Basic Strength Attribute.
 */
@Ability(type = AbilityType.ATTRIBUTE, name = "attribute-strength", container = SingleModifierContainer.class)
@ModifierType({Speed.class})
public class Strength extends Skill {
	
	@Value
	private Double value;
	private String nothing;
	
	@Override
	public final Double mod(Modifier modifier) {
		if (modifier instanceof Speed) {
			if(value >= 10) {
				return 5.0;
			}
		}
		
		return 0.0;
	}
}
