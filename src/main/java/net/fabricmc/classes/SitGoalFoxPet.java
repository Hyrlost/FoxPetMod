package net.fabricmc.classes;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;

import java.util.EnumSet;

public class SitGoalFoxPet extends Goal {
    private final FoxTameable tameable;

    public SitGoalFoxPet(FoxTameable tameable) {
        this.tameable = tameable;
        this.setControls(EnumSet.of(Control.JUMP, Control.MOVE));
    }

    public boolean shouldContinue() {
        return this.tameable.isSitting();
    }

    public boolean canStart() {
        if (!this.tameable.isTamed()) {
            return false;
        } else if (this.tameable.isInsideWaterOrBubbleColumn()) {
            return false;
        } else if (!this.tameable.isOnGround()) {
            return false;
        } else {
            LivingEntity livingEntity = this.tameable.getOwner();
            if (livingEntity == null) {
                return true;
            } else {
                return this.tameable.squaredDistanceTo(livingEntity) < 144.0 && livingEntity.getAttacker() != null ? false : this.tameable.isSitting();
            }
        }
    }

    public void start() {
        this.tameable.getNavigation().stop();
    }
}
