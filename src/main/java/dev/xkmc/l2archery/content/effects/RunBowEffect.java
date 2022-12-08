package dev.xkmc.l2archery.content.effects;

import dev.xkmc.l2complements.content.effect.skill.SkillEffect;
import dev.xkmc.l2library.base.effects.api.InherentEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class RunBowEffect extends InherentEffect implements SkillEffect<RunBowEffect> {

	public RunBowEffect(MobEffectCategory type, int color) {
		super(type, color);
	}

}
