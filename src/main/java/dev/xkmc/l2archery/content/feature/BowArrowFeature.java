package dev.xkmc.l2archery.content.feature;

import dev.xkmc.l2archery.content.item.BowConfig;
import net.minecraft.network.chat.MutableComponent;

import java.util.List;

public interface BowArrowFeature {

	void addTooltip(List<MutableComponent> list);

	default boolean allowDuplicate() {
		return false;
	}

	default boolean allow(BowConfig config) {
		return true;
	}
}
