package me.alien.meksifi.mek;

import me.alien.meksifi.mek.items.Test;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Provider implements ICapabilityProvider {

    private final LazyOptional<IEnergyStorage> energy = LazyOptional.of(this::createEnergyStorage);

    public Provider(ItemStack stack, Test test) {
    }

    private <T> T createEnergyStorage() {
        return (T) new Energy();
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
        if (capability == CapabilityEnergy.ENERGY) {
            return energy.cast();
        }
        return LazyOptional.empty();
    }
}