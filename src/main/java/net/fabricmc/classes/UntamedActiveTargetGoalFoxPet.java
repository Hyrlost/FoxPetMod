package net.fabricmc.classes;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class UntamedActiveTargetGoalFoxPet <T extends LivingEntity> extends ActiveTargetGoal<T> {
    private final FoxTameable tameable;

    public UntamedActiveTargetGoalFoxPet(FoxTameable tameable, Class<T> targetClass, boolean checkVisibility, @Nullable Predicate<LivingEntity> targetPredicate) {
        super(tameable, targetClass, 10, checkVisibility, false, targetPredicate);
        this.tameable = tameable;
    }

    public boolean canStart() {
        return !this.tameable.isTamed() && super.canStart();
    }

    public boolean shouldContinue() {
        return this.targetPredicate != null ? this.targetPredicate.test(this.mob, this.targetEntity) : super.shouldContinue();
    }
}