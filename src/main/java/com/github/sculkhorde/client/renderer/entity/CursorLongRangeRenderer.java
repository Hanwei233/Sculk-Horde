package com.github.sculkhorde.client.renderer.entity;

import com.github.sculkhorde.common.entity.infection.CursorProberEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class CursorLongRangeRenderer extends EntityRenderer<CursorProberEntity> {
    public CursorLongRangeRenderer(EntityRendererManager p_i46179_1_) {
        super(p_i46179_1_);
    }

    /**
     * Returns the location of an entity's texture.
     *
     * @param pEntity
     */
    @Override
    public ResourceLocation getTextureLocation(CursorProberEntity pEntity) {
        return null;
    }
}
