package net.fabricmc;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.classes.FoxPetEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FoxPetMod implements ModInitializer {
	public static final EntityType<FoxPetEntity> FOX = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier("foxpetmod", "foxpet"),
			FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, FoxPetEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
	);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(FOX, FoxPetEntity.createFoxAttributes());
	}
}
