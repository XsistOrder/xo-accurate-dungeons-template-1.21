package net.xo.xoaccuratedungeons.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EndermanEntity.class)
public abstract class EndermanMixin extends MobEntity {

    @Shadow public abstract boolean isPlayerStaring(PlayerEntity player);

    protected EndermanMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "initGoals", at = @At("TAIL"))
    private void modifyActiveTargetGoal(CallbackInfo ci) {
        EndermanEntity enderman = (EndermanEntity) (Object) this;
        GoalSelector targetSelector = ((MobEntityAccessor) enderman).getTargetSelector();

        // Remove existing ActiveTargetGoals
        targetSelector.getGoals().removeIf(goal ->
                goal.getGoal() instanceof ActiveTargetGoal);

        // Add new ActiveTargetGoal for PlayerEntity with custom conditions
        targetSelector.add(1, new ActiveTargetGoal<>(enderman, PlayerEntity.class, 10, true, false,
                (entity) -> {
                    if (entity instanceof PlayerEntity player) {
                        return this.isPlayerStaring(player) || enderman.getAttacker() == player;
                    }
                    return false;
                }
        ));
    }
}