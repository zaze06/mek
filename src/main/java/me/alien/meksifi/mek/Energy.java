package me.alien.meksifi.mek;

import net.minecraftforge.common.util.NonNullFunction;
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nonnull;

public class Energy implements IEnergyStorage {

    public final int maxEnergy = 100;
    public int energy;

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        System.out.println(energy+"/"+maxEnergy);
        if(simulate) return energy+maxReceive>maxEnergy ? maxEnergy : maxReceive;
        int tmp = 0;
        energy += energy+maxReceive>maxEnergy ? maxEnergy : maxReceive;
        return Math.min(maxReceive, maxEnergy);
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        System.out.println(energy+"/"+maxEnergy);
        return energy;
    }

    @Override
    public int getEnergyStored() {
        System.out.println(energy+"/"+maxEnergy);
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        System.out.println(energy+"/"+maxEnergy);
        return maxEnergy;
    }

    @Override
    public boolean canExtract() {
        return true;
    }

    @Override
    public boolean canReceive() {
        return true;
    }
}
