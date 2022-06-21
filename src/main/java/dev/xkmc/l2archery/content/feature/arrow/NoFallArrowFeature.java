package dev.xkmc.l2archery.content.feature.arrow;

import dev.xkmc.l2archery.content.feature.types.FlightControlFeature;

public class NoFallArrowFeature extends FlightControlFeature {

	public NoFallArrowFeature(int life) {
		this.gravity = 0;
		this.inertia = 1;
		this.water_inertia = 1;
		this.life = life;
	}

}
