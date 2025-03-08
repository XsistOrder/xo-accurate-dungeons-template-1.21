package net.xo.xoaccuratedungeons.mixin;

import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MobEntity.class)
public interface MobEntityAccessor {

    @Accessor("goalSelector")  // Replace "goalSelector" with the actual field name
    public abstract GoalSelector getGoalSelector();
    @Accessor
    GoalSelector getTargetSelector();
}