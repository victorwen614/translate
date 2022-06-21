package dev.xkmc.l2archery.init.registrate;

import dev.xkmc.l2archery.content.effect.*;
import dev.xkmc.l2archery.content.entity.GenericArrowEntity;
import dev.xkmc.l2archery.content.entity.GenericArrowRenderer;
import dev.xkmc.l2archery.init.L2Archery;
import dev.xkmc.l2library.repack.registrate.builders.NoConfigBuilder;
import dev.xkmc.l2library.repack.registrate.util.entry.EntityEntry;
import dev.xkmc.l2library.repack.registrate.util.entry.RegistryEntry;
import dev.xkmc.l2library.repack.registrate.util.nullness.NonNullSupplier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.ForgeRegistries;

public class ArcheryRegister {

	public static final EntityEntry<GenericArrowEntity> ET_ARROW = L2Archery.REGISTRATE
			.<GenericArrowEntity>entity("generic_arrow", GenericArrowEntity::new, MobCategory.MISC)
			.properties(e -> e.sized(0.5F, 0.5F)
					.clientTrackingRange(4).updateInterval(20)
					.setShouldReceiveVelocityUpdates(true))
			.renderer(() -> GenericArrowRenderer::new)
			.defaultLang().register();

	public static final RegistryEntry<FlameEffect> FLAME = genEffect("flame", () -> new FlameEffect(MobEffectCategory.HARMFUL, 0xFF0000));
	public static final RegistryEntry<IceEffect> ICE = genEffect("frozen", () -> new IceEffect(MobEffectCategory.HARMFUL, 0x7f7fff));
	public static final RegistryEntry<ArmorReduceEffect> ARMOR_REDUCE = genEffect("armor_reduce", () -> new ArmorReduceEffect(MobEffectCategory.HARMFUL, 0xFFFFFF));
	public static final RegistryEntry<MobEffect> RUN_BOW = genEffect("run_bow", () -> new RunBowEffect(MobEffectCategory.BENEFICIAL, 0xffffff));
	public static final RegistryEntry<QuickPullEffect> QUICK_PULL = genEffect("quick_pull", () -> new QuickPullEffect(MobEffectCategory.BENEFICIAL, 0xFFFFFF));

	public static <T extends MobEffect> RegistryEntry<T> genEffect(String name, NonNullSupplier<T> sup) {
		return L2Archery.REGISTRATE.entry(name, cb -> new NoConfigBuilder<>(L2Archery.REGISTRATE, L2Archery.REGISTRATE, name, cb, ForgeRegistries.Keys.MOB_EFFECTS, sup))
				.lang(MobEffect::getDescriptionId).register();
	}

	public static void register() {
	}

}
