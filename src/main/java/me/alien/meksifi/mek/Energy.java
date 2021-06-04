package me.alien.meksifi.mek;

import net.minecraftforge.energy.IEnergyStorage;

public class Energy implements IEnergyStorage {

    public final int maxEnergy = 100;
    public int energy = 0;

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        return maxEnergy-energy;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        return energy;
    }

    @Override
    public int getEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
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
