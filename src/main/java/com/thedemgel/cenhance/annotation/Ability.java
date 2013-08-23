/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thedemgel.cenhance.annotation;

import com.thedemgel.cenhance.AbilityType;
import com.thedemgel.cenhance.modifier.ModifierContainer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Class Annotation to give name/type of Ability.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Ability {
	String name();
	AbilityType type();
	Class<? extends ModifierContainer> container();
}
