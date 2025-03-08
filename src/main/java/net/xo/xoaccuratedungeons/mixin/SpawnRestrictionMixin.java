package net.xo.xoaccuratedungeons.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnLocation;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Map;

@Mixin(SpawnRestriction.class)
public abstract class SpawnRestrictionMixin {

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyEndermiteSpawnRestriction(CallbackInfo ci) {
        try {
            // Access the RESTRICTIONS map
            Field restrictionsField = SpawnRestriction.class.getDeclaredField("RESTRICTIONS");
            restrictionsField.setAccessible(true);
            Map<EntityType<?>, Object> restrictions = (Map<EntityType<?>, Object>) restrictionsField.get(null);

            // Access the Entry class
            Class<?> entryClass = Class.forName("net.minecraft.entity.SpawnRestriction$Entry");
            Constructor<?> entryConstructor = entryClass.getDeclaredConstructor(
                    SpawnLocation.class,
                    Heightmap.Type.class,
                    SpawnRestriction.SpawnPredicate.class
            );
            entryConstructor.setAccessible(true);

            // Create a new Entry instance
            Object newEntry = entryConstructor.newInstance(
                    SpawnLocationTypes.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                    (SpawnRestriction.SpawnPredicate<HostileEntity>) HostileEntity::canSpawnInDark
            );

            // Replace the existing Endermite entry
            restrictions.put(EntityType.ENDERMITE, newEntry);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}