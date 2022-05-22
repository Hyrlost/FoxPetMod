package net.fabricmc;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FoxEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.FoxEntityModel;
import net.minecraft.util.Identifier;

public class FoxPetModClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_FOX_LAYER = new EntityModelLayer(new Identifier("foxpetmod", "foxpet"), "main");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(FoxPetMod.FOX, (context) -> {
            return new FoxEntityRenderer(context);
        });

        EntityModelLayerRegistry.registerModelLayer(MODEL_FOX_LAYER, FoxEntityModel::getTexturedModelData);
    }
}
