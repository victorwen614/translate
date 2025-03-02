package dev.xkmc.l2archery.content.feature.core;

import dev.xkmc.l2archery.content.feature.BowArrowFeature;
import dev.xkmc.l2archery.content.item.BowConfig;
import dev.xkmc.l2archery.content.item.IBowConfig;
import dev.xkmc.l2archery.init.data.LangData;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;

public record StatFeature(float fov, int fov_time, float damage, int punch,
						  float speed) implements BowArrowFeature, IBowConfig {

	public static final StatFeature NOOP = new StatFeature(1, 1, 1, 0, 1);

	/**
	 * cannot be implemented due to pulling not having access to ItemStack
	 */
	@Override
	public int pull_time() {
		return 1;
	}

	@Override
	public List<MobEffectInstance> getEffects() {
		return List.of();
	}

	@Override
	public void addTooltip(List<MutableComponent> list) {
		if (damage() != NOOP.damage()) list.add(LangData.STAT_DAMAGE.get("x" + damage()));
		if (punch() != NOOP.punch()) list.add(LangData.STAT_PUNCH.get("+" + punch()));
		if (fov() != NOOP.fov()) list.add(LangData.STAT_FOV.get("x" + fov()));
		if (speed() != NOOP.speed()) list.add(LangData.STAT_SPEED.get("x" + speed()));
	}

	@Override
	public boolean allow(BowConfig config) {
		if (damage > 1f && config.damage() == 0f) return false;
		return !(fov() > 1f) || !(1 / (1 - config.fov()) >= 9.9f);
	}
}
